package efinder.usemv.ir;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import com.google.common.base.Preconditions;

import efinder.ir.EFClass;
import efinder.ir.EFEnum;
import efinder.ir.EFEnumLiteral;
import efinder.ir.EFPackage;

/**
 * Instantiation of a given mapping.
 * 
 * @author jesus
 *
 */
public class UseMapping {

	@NonNull
	private final Map<String, AssociationData> associations = new HashMap<>();
	
	@NonNull
	private final Map<String, String> strings2new = new HashMap<String, String>();
	@NonNull
	private final Map<String, String> new2Strings = new HashMap<String, String>();
	@NonNull
	private final Map<String, String> useToEcoreTypeNames = new HashMap<String, String>();
	
	public String addStringConstant(@NonNull String string) {
		String newString = strings2new.get(string);
		if (newString == null) {
			newString = "string" + (strings2new.size() + 1);
			strings2new.put(string, newString);
			new2Strings.put(newString, string);
		}
		return newString;
	}

	public String undoStringConstant(String v) {		
		return new2Strings.getOrDefault(v, v);
	}

	public int getStringCount() {
		return strings2new.size();
	}
	
	@NonNull
	public String toUseTypeName(@NonNull EFClass klass) {		
		return toUseClass(klass.getKlass());
	}

	@NonNull
	public String toUseLiteralName(@NonNull EFEnumLiteral literal) {
		String original = literal.getName();
		String name = UseReservedWords.toUseName(original);
		useToEcoreTypeNames.put(name, original);
		return name;
	}
	
	@NonNull
	public String toUseTypeName(@NonNull EFEnum enum_) {
		String original = enum_.getEnum_().getName();
		String name = UseReservedWords.toUseName(original);
		useToEcoreTypeNames.put(name, original);
		return name;
	}

	@NonNull
	public String toModelName(@NonNull EFPackage pkg) {
		return pkg.getPkg().getName();
	}

	@NonNull
	public String toUseClass(@NonNull EClass klass) {
		String name = UseReservedWords.toUseName(klass.getName());
		useToEcoreTypeNames.put(name, klass.getName());
		return name;
	}

	@NonNull
	public String toUsePropertyName(@NonNull EReference reference) {
		return UseReservedWords.toUseName(reference.getName());
	}
	
	public String toUsePropertyName(EAttribute feature) {
		return UseReservedWords.toUseName(feature.getName());
	}


	@NonNull
	public AssociationData getAssociation(@NonNull EReference reference) {
		boolean hasOpposite = reference.getEOpposite() != null;
		String associationName;
		AssociationEndData end1;
		if (hasOpposite) {
			EReference reference0 = reference.getEOpposite();
			// By convention, sort the references 
			if (reference0.getName().compareTo(reference.getName()) < 0) {
				reference0 = reference;
				reference = reference0.getEOpposite();
			}
			
			associationName = reference0.getEContainingClass().getName() + "_" + reference0.getName() + "_" +
							  reference.getEContainingClass().getName() + "_" + reference.getName();
			String end1_type = toUseClass(reference0.getEReferenceType());
			String end1_name = toUsePropertyName(reference0);
			String end1_cardinality = cardinalityToString(reference0);
			end1 = new AssociationEndData(end1_name, end1_type, end1_cardinality);			
		} else {
			associationName = reference.getEContainingClass().getName() + "_" + reference.getName();
			String end1_type = toUseClass(reference.getEContainingClass());
			String end1_name = associationName + "_source";
			String end1_cardinality = reference.isContainment()? "[0..1]" : "[*]";
			end1 = new AssociationEndData(end1_name, end1_type, end1_cardinality);			
		}
		
		if (associations.containsKey(associationName))
			return associations.get(associationName);
		
		String end2_type = toUseClass(reference.getEReferenceType());
		String end2_name = toUsePropertyName(reference);
		String end2_cardinality = cardinalityToString(reference);
		AssociationEndData end2 = new AssociationEndData(end2_name, end2_type, end2_cardinality, reference);
		AssociationData data = new AssociationData(associationName, end1, end2);
		associations.put(associationName, data);
		return data;
	}

	@Nullable
	public AssociationData getAssociationByName(@NonNull String name) {
		return associations.get(name);
	}

	public static class AssociationData {

		private AssociationEndData end1;
		private AssociationEndData end2;
		private String name;

		public AssociationData(String associationName, AssociationEndData end1, AssociationEndData end2) {
			this.name = associationName;
			this.end1 = end1;
			this.end2 = end2;
		}
		
		public String getName() {
			return name;
		}
		
		public AssociationEndData getEnd1() {
			return end1;
		}
		
		public AssociationEndData getEnd2() {
			return end2;
		}		
	}
	
	public static class AssociationEndData {

		private String name;
		private String type;
		private String cardinality;
		@Nullable
		private EReference reference;

		public AssociationEndData(@NonNull String name, @NonNull String type, @NonNull String cardinality) {
			this.name = name;
			this.type = type;
			this.cardinality = cardinality;
		}
		
		public AssociationEndData(@NonNull String name, @NonNull String type, @NonNull String cardinality, @NonNull EReference reference) {
			this(name, type, cardinality);
			this.reference = reference;
		}

		public String getCardinality() {
			return cardinality;
		}
		
		public String getName() {
			return name;
		}
		
		public String getType() {
			return type;
		}
		
		public EReference getEReference() {
			return reference;
		}
		
	}
	
	@NonNull
	private String cardinalityToString(@NonNull EReference ref) {
		Preconditions.checkNotNull(ref);
		return "[" + 
	           /* lower */ (ref.getLowerBound()==ref.getUpperBound() || (ref.getLowerBound()==0 && ref.getUpperBound()==-1)? "" : ref.getLowerBound() + "..") +
		       /* upper */ (ref.getUpperBound()==-1? "*" : ref.getUpperBound()) +
		       "]";
	}

	/**
	 * Undo the name modification
	 */
	@NonNull 
	public String getInverseTypeName(@NonNull String name) {
		return useToEcoreTypeNames.getOrDefault(name, name);
	}

	@NonNull 
	public String getInverseLiteralName(@NonNull String name) {
		// This is currently using the same map for everything, but this is only an implementation detail right now
		return useToEcoreTypeNames.getOrDefault(name, name);
	}
}
