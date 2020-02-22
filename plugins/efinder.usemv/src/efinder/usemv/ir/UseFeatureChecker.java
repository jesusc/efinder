package efinder.usemv.ir;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.tzi.use.uml.ocl.type.TupleType;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import efinder.core.EFinderModel;
import efinder.core.errors.Report;
import efinder.core.footprint.IRFootprintedModel;
import efinder.ir.Constraint;
import efinder.ir.DerivedProperty;
import efinder.ir.EFTupleType;
import efinder.ir.MetaTypeRef;
import efinder.ir.Operation;
import efinder.ir.ocl.CollectionCallExp;
import efinder.ir.ocl.IterateExp;
import efinder.ir.ocl.OclConstraint;
import efinder.ir.ocl.OclDerivedProperty;
import efinder.ir.ocl.OclExpression;
import efinder.ir.ocl.OclOperation;
import efinder.ir.ocl.OperationCallExp;
import efinder.ir.ocl.TupleLiteralExp;
import efinder.ir.ocl.UnsupportedExp;

/**
 * Checks if the IR model is supported by USE or not, and reports useful messages. 
 * 
 * @author jesus
 *
 */
public class UseFeatureChecker {
	
	public Report check(@NonNull IRFootprintedModel model) {
		Report report = new Report();
		
		for (Constraint c : model.getConstraints()) {
			if (c instanceof OclConstraint) {
				check(c, report);
			} else {
				report.addUnsupported("Constraint type not supported" + c.eClass().getName(), c, Report.Action.STOP, "constraint-lang");
			}
		}
		
		for (Operation c : model.getOperations()) {
			if (c instanceof OclOperation) {
				check(c, report);
			} else {
				report.addUnsupported("Operation type not supported" + c.eClass().getName(), c, Report.Action.STOP, "operation-lang");
			}
		}

		for (DerivedProperty c : model.getDerivedProperties()) {
			if (c instanceof OclDerivedProperty) {
				check(c, report);
			} else {
				report.addUnsupported("Property type not supported" + c.eClass().getName(), c, Report.Action.STOP, "property-lang");
			}
		}
		
		return report;
	}

	private void check(@NonNull EObject element, @NonNull Report report) {
		TreeIterator<EObject> it = element.eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (obj instanceof CollectionCallExp) {
				outCollectionCallExp((CollectionCallExp) obj, report);
			} else if (obj instanceof OperationCallExp) {
				outOperationCallExp((OperationCallExp) obj, report);
			} else if (obj instanceof TupleLiteralExp) {
				report.addUnsupported("Tuple literals are unsupported", obj, Report.Action.STOP, "tuple");
			} else if (obj instanceof MetaTypeRef && ((MetaTypeRef) obj).getType() instanceof EFTupleType) {
				report.addUnsupported("TupleType not unsupported", obj, Report.Action.STOP, "tuple");
			} else if (obj instanceof IterateExp) {
				report.addUnsupported("IterateExp is not unsupported", obj, Report.Action.STOP, "iterate");
			} else if (obj instanceof UnsupportedExp) {
				UnsupportedExp exp = (UnsupportedExp) obj;
				report.addUnsupported(exp.getDescription(), obj, Report.Action.STOP, exp.getReason());
			}
		}
	}

	private static ImmutableMap<String, String> unsupportedOperations = ImmutableMap.<String, String>builder()
			.put("String", "matches")
			.put("OclAny", "oclType")
			.build();
	
	// TODO: Use the type of the expression... which is something that we don't check yet, or normalize the operations
	// in a previous phase. Actually, the operation names are disjunct across types so, this is not very bad
	private static Set<String> unsupportedOperationsSet = new HashSet<>(unsupportedOperations.values());			
			
	private void outOperationCallExp(OperationCallExp obj, Report input) {		
		String name = obj.getName();
		if (unsupportedOperationsSet.contains(name)) {
			input.addUnsupported("Unsupported operation " + name, obj, Report.Action.STOP, name);
		}
	}

	private static ImmutableSet<String> unsupportedCollectionOperations = ImmutableSet.<String>builder()
			.add("indexOf")
			.add("at")
			.add("first") /* Could be emulated sometimes with ->any(true) */
			.add("last")  /* Could be emulated sometimes with ->any(true) */
			.build();
	
	private void outCollectionCallExp(@NonNull CollectionCallExp obj, @NonNull Report input) {
		String name = obj.getName();
		if (unsupportedCollectionOperations.contains(name)) {
			input.addUnsupported("Unsupported collection operation " + name, obj, Report.Action.STOP, name);
		}
	}
	
}
