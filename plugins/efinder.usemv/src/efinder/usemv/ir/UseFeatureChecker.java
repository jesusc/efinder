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
import efinder.ir.ocl.CollectionCallExp;
import efinder.ir.ocl.IterateExp;
import efinder.ir.ocl.OperationCallExp;
import efinder.ir.ocl.TupleLiteralExp;

/**
 * Checks if the IR model is supported by USE or not, and reports useful messages. 
 * 
 * @author jesus
 *
 */
public class UseFeatureChecker {
	
	public Report check(@NonNull EFinderModel model) {
		Report report = new Report();
		
		TreeIterator<EObject> it = model.getSpecification().eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (obj instanceof CollectionCallExp) {
				outCollectionCallExp((CollectionCallExp) obj, report);
			} else if (obj instanceof OperationCallExp) {
				outOperationCallExp((OperationCallExp) obj, report);
			} else if (obj instanceof TupleLiteralExp) {
				report.addUnsupported("Tuple literals are unsupported", obj, Report.Action.STOP, "tuple");
			}  else if (obj instanceof IterateExp) {
				report.addUnsupported("IterateExp is not unsupported", obj, Report.Action.STOP, "iterate");
			}
		}
		
		return report;
	}

	private static ImmutableMap<String, String> unsupportedOperations = ImmutableMap.<String, String>builder()
			.put("String", "matches")
			.build();
	
	// TODO: Use the type of the expression... which is something that we don't check yet, or normalize the operations
	// in a previous phase
	private static Set<String> unsupportedOperationsSet = new HashSet<>(unsupportedOperations.values());			
			
	private void outOperationCallExp(OperationCallExp obj, Report input) {		
		String name = obj.getName();
		if (unsupportedOperationsSet.contains(name)) {
			input.addUnsupported("Unsupported operation " + name, obj, Report.Action.STOP, name);
		}		
	}

	private static ImmutableSet<String> unsupportedCollectionOperations = ImmutableSet.<String>builder()
			.add("indexOf")
			.build();
	
	private void outCollectionCallExp(@NonNull CollectionCallExp obj, @NonNull Report input) {
		String name = obj.getName();
		if (unsupportedCollectionOperations.contains(name)) {
			input.addUnsupported("Unsupported collection operation " + name, obj, Report.Action.STOP, name);
		}
	}
	
}
