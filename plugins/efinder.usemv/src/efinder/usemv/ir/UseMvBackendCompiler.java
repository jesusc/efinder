package efinder.usemv.ir;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;

import com.google.common.base.Preconditions;

import efinder.core.errors.UnsupportedTranslationException;
import efinder.core.footprint.IRFootprintedModel;
import efinder.core.management.EcoreMetamodel;
import efinder.ir.Constraint;
import efinder.ir.EFClass;
import efinder.ir.EFEnum;
import efinder.ir.EFEnumLiteral;
import efinder.ir.EFMetamodel;
import efinder.ir.EFPackage;
import efinder.ir.EFPrimitiveType;
import efinder.ir.EFType;
import efinder.ir.MetaTypeRef;
import efinder.ir.Parameter;
import efinder.ir.Specification;
import efinder.ir.TypeRef;
import efinder.ir.VariableDeclaration;
import efinder.ir.ocl.OclDerivedProperty;
import efinder.ir.ocl.OclExpression;
import efinder.ir.ocl.OclInvariant;
import efinder.ir.ocl.OclOperation;
import efinder.usemv.UseModel;
import efinder.usemv.ir.UseMapping.AssociationData;
import efinder.usemv.utils.EMFUtils;

/**
 * Compiles an IR specification into a USE model
 *  
 * @author jesus
 *
 */
public class UseMvBackendCompiler {

	private final IRFootprintedModel ir;
	@NonNull
	private final UseMapping mapping;
	@NonNull
	private UseTypeCompiler typeCompiler;
	@NonNull
	private final UseExpressionsCompiler compiler;  
	
	public UseMvBackendCompiler(IRFootprintedModel model) {
		this.ir = model;
		this.mapping = new UseMapping(model.getSpecification().getMetamodels());
		this.typeCompiler = new UseTypeCompiler(mapping);
		this.compiler = new UseExpressionsCompiler(mapping, typeCompiler);
	}
	
	@NonNull
	public UseModel compile() {
		return doCompile();
	}
	
	@NonNull
	public UseMapping getMapping() {
		return mapping;
	}
	
	private UseModel doCompile() {
		// Specification spec = ir.getSpecification();
		
		List<? extends EFClass> allClasses = ir.getAllClasses(); // getAllClasses(spec);
		List<? extends EFEnum> allEnumerations = ir.getAllEnumerations(); // getAllEnumerations(spec);
		
		Map<EFType, Collection<OclDerivedProperty>> properties = ir.getDerivedPropertiesAsMap(); // IRUtils.getDerivedPropertiesAsMap(spec);
		Map<EFType, Collection<OclOperation>> operations = ir.getOperationsAsMap(); // IRUtils.getOperationsAsMap(spec);		
		
		List<EAttribute> nonUndefined = new ArrayList<EAttribute>();		
		
		StringBuilder text = new StringBuilder();
		
		text.append("model " + mapping.toModelName());
		text.append("\n\n");
		
		for (EFClass efc : allClasses) {
			EClass c = efc.getKlass();
			Collection<OclDerivedProperty> classDerived = properties.getOrDefault(efc, Collections.emptyList());
			Collection<OclOperation> classOperations = operations.getOrDefault(efc, Collections.emptyList());
			
			if (c.isAbstract()) {
				text.append("abstract ");
			}
			
			text.append("class ").append(mapping.toUseTypeName(c));
			
			List<? extends EClass> superTypes = ir.getSupertypes(c);
			if (! superTypes.isEmpty()) {
				text.append(" < ");
				String separator = "";
				for (EClass sc : superTypes) {
					text.append(separator).append(mapping.toUseTypeName(sc));
					separator = ", ";
			    }						
			}
			
			text.append("\n");
			
			if (!c.getEAttributes().isEmpty() || !classDerived.isEmpty()) {
				text.append("attributes\n");
				
				ATTR:
				for (EAttribute att : ir.getAttributes(c)) {
					if (! EMFUtils.isNullable(att)) {
						nonUndefined.add(att);
					}
					
					if (att.isDerived()) {
						// If this is already implemented somehow, we don't put it
						for (OclDerivedProperty p : classDerived) {
							if (isAttributeProperty(p) && p.getName().equals(att.getName())) {
								continue ATTR;
							}
						}
					}
					
					String type = toUseDataType(att);					
					text.append("  " + mapping.toUsePropertyName(att) + " : " + type + "\n");
				}
				
				for (OclDerivedProperty p : classDerived) {
					if (isAttributeProperty(p)) {
						String type = toUseType(p.getType());						
						text.append("  " + p.getName() + " : " + type + " derive = ");
						appendExpression(text, p.getBody());
						text.append("\n");
					}
				}
			}
			
			if (!classOperations.isEmpty()) {
				text.append("operations\n");
				for (OclOperation op : classOperations) {
					String type = toUseType(op.getType());						
					text.append("  " + op.getName() + "(");
					
					String separator = "";
					for (Parameter p : op.getParameters()) {
						text.append(separator).append(mapping.toUseVarName(p.getName())).append(" : ").append(toUseType(p.getType()));
						separator = ", ";
				    }	
					
					text.append(") : " + type + " = ");
					appendExpression(text, op.getBody());
					text.append("\n");
				}
			}

			text.append("end").append("\n\n");
		}

		for (EFEnum efe : allEnumerations) {
			text.append("enum ").append(mapping.toUseTypeName(efe)).append(" { ");
			String separator = "";
			for (EFEnumLiteral literal : efe.getLiterals()) {
				text.append(separator);
				text.append(mapping.toUseLiteralName(literal));
				separator = ", ";
			}
			
			text.append(" }").append("\n");
		}

		
		// References
		Set<AssociationData> alreadyCreated = new HashSet<>();
		for (EFClass efc : allClasses) {
			EClass c = efc.getKlass();
			for (EReference ref : ir.getReferences(c)) {
				String associationType = ref.isContainment() ? "composition" : "association";
				AssociationData assoc = mapping.getAssociation(ref);
				if (alreadyCreated.contains(assoc))
					continue;
				
				text.append(associationType).append(" ").append(assoc.getName()).append(" between\n");
				text.append("  ").append(assoc.getEnd1().getType()).append(assoc.getEnd1().getCardinality()).append(" role ").append(assoc.getEnd1().getName()).append("\n");
				text.append("  ").append(assoc.getEnd2().getType()).append(assoc.getEnd2().getCardinality()).append(" role ").append(assoc.getEnd2().getName()).append("\n");
				text.append("end").append("\n\n");
				
				alreadyCreated.add(assoc);
			}			
		}		
				
		// constraints
		addConstraints(text);
		addNullableConstraints(text, nonUndefined);
		
		EcoreMetamodel mm = toEcoreMetamodel(ir.getSpecification());		
		return new UseModel(text.toString(), mapping, mm);
	}		
	
	private void addNullableConstraints(StringBuilder text, Collection<? extends EAttribute> nonUndefined) {
		for (EAttribute att : nonUndefined) {
			String className = mapping.toUseTypeName(att.getEContainingClass());
			text.append("context ").append("self").append(" : ").append(className)
				.append(" inv ").append("nonNull_" + className + "_" + att.getName()).append(":\n")
				.append(indent(1));
			if (att.isMany()) {
				text.append("self." + mapping.toUsePropertyName(att) + "<>" + "Undefined implies " + mapping.toUsePropertyName(att) + "->forAll(v | not v.isUndefined())")
					.append("\n");	
			} else {
				text.append("not self." + mapping.toUsePropertyName(att) + ".isUndefined()")
					.append("\n");					
			}
			text.append("\n");
		}		
	}

	/**
	 * Constraints have the form:
	 * <pre>
	 * 		
	 * constraints
	 *	context self : Person inv personInvariant:
	 *		self.age > 10
	 *
	 *	context self : Person inv personInvariant2:
	 *		self.name <> Undefined	 
	 * </pre>
	 * @param text
	 * @param mapping 
	 */
	private void addConstraints(@NonNull StringBuilder text) {
		text.append("constraints\n\n");
		
		for(Constraint c : ir.getConstraints()) {
			if (c instanceof OclInvariant) {
				OclInvariant invariant = (OclInvariant) c;
				addContext(text, ir.getSpecification(), invariant);
 			} else {
 				throw new UnsupportedOperationException();
 			}
		}		
	}

	private void addContext(@NonNull StringBuilder text, @NonNull Specification specification, @NonNull OclInvariant invariant) {
		VariableDeclaration ctx = invariant.getContextVariable();
		text.append("context ").append(ctx.getName()).append(" : ").append(mapping.toUseTypeName(invariant.getKlass()))
			.append(" inv ").append(toInvariantName(specification, invariant)).append(":\n")
			.append(indent(1));
		appendExpression(text, invariant.getExpression());
		text.append("\n\n");
	}

	private void appendExpression(@NonNull StringBuilder text, @NonNull OclExpression expression) {		
		compiler.compile(expression, text);
	}
	
	private String indent(int level) {
		String s = "";
		for(int i = 0; i < level; i++)
			s += "  ";
		return s;
	}

	@NonNull
	private String toInvariantName(@NonNull Specification specification, @NonNull OclInvariant invariant) {
		int idx = specification.getConstaints().indexOf(invariant);
		return invariant.getKlass().getKlass().getName() + "_" + idx;
	}
	
	@NonNull
	private EcoreMetamodel toEcoreMetamodel(@NonNull Specification spec) {
		List<EPackage> pkgs = new ArrayList<EPackage>();
		for (EFMetamodel efm : spec.getMetamodels()) {
			for (EFPackage pkg : efm.getRoots()) {
				pkgs.add(pkg.getPkg());
			}
		}
		
		Preconditions.checkState(pkgs.size() > 0);
		return new EcoreMetamodel(pkgs);
	}

	private String toUseDataType(EAttribute att) {
		String basicType = toUseDataType(att.getEAttributeType());
		if (att.isMany()) {
			// TODO: For the moment this always returns a Set, but if it is ordered should be sequence
			return "Set(" + basicType + ")";
		}
		return basicType;
	}
		
	private String toUseType(TypeRef t) {
		return typeCompiler.toTypeText(t);
	}
	
	// TODO: Move to UseTypeCompiler
	@NonNull
	private String toUseDataType(@NonNull EDataType dt) {
		String type = dt.getName();

		if (type.equals("EInt") || type.equals("Integer") || type.equals("IntegerObject") || 
				type.endsWith("Integer") || 
				"java.lang.Integer".equals(dt.getInstanceClassName()) || "EIntegerObject".equals(dt.getName()) ||
				"int".equals(dt.getInstanceClassName()) ||
				"ELong".equals(type) || "Long".equalsIgnoreCase(type) ||
				"EByte".equals(type))
			return "Integer";
		
		if (type.equals("EBoolean") ||  "java.lang.Boolean".equals(dt.getInstanceClassName()) || "boolean".equals(dt.getInstanceClassName()) ) 
			return "Boolean";
			
		if (type.equals("EString") || type.equals("String") || type.endsWith("String"))
			return "String";

        if ( type.equals("EFloat")  || type.equals("float")  || type.equals("EFloatObject")  || type.equals("Float")  || type.endsWith("Float") ||
                type.equals("EDouble") || type.equals("double") || type.equals("EDoubleObject") || type.equals("Double") || type.endsWith("Double") ||
                "java.lang.Double".equals(dt.getInstanceClassName()) ||
                "double".equals(dt.getInstanceClassName()) ||
                "java.lang.Float".equals(dt.getInstanceClassName()) || 
                "float".equals(dt.getInstanceClassName()) ||
                "EBigDecimal".equals(dt.getName())) 
        	return "Real";
        
		if (dt instanceof EEnum)               
			return mapping.toUseTypeName(dt);

		// TODO: Indicate this as part of compilation errors/limitations
		
		throw new UnsupportedTranslationException("DataType not suported: " + dt.getName(), dt.getName());
	}
		
	/**
	 * Flattens a meta-model if needed.
	 */
	private EFPackage toFlattened(List<? extends EFPackage> roots) {
		if (roots.size() != 1)
			throw new UnsupportedOperationException("Not supported yet");
	
		return roots.get(0);
	}
	
	private boolean isAttributeProperty(@NonNull OclDerivedProperty p) {
		TypeRef ref = p.getType();
		if (ref instanceof MetaTypeRef)
			return ((MetaTypeRef) ref).getType() instanceof EFPrimitiveType;
		return true;
	}
}
