package efinder.emfocl.use;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;

import efinder.core.EFinderModel;
import efinder.core.IDialectAdaptation;
import efinder.core.ir.IRBuilder;
import efinder.core.visitor.AbstractIRVisitor;
import efinder.ir.CollectionTypeRef;
import efinder.ir.OrderedSetTypeRef;
import efinder.ir.Specification;
import efinder.ir.TypeRef;
import efinder.ir.TypedElement;
import efinder.ir.ocl.OclFactory;
import efinder.ir.ocl.OperationCallExp;
import efinder.ir.ocl.PropertyCallExp;
import efinder.ir.ocl.SetLiteralExp;

public class EMFOCL2UseFixer extends AbstractIRVisitor<Void, Void> implements IDialectAdaptation {

	@Override
	public void transform(@NonNull EFinderModel ir) {
		Specification spec = ir.getSpecification();
		// Poor's man approach
		spec.eAllContents().forEachRemaining(o -> {
			if (o instanceof OperationCallExp) {
				inOperationCallExp((OperationCallExp) o);
			} else if (o instanceof PropertyCallExp) {
				inPropertyCallExp((PropertyCallExp) o);			
			} else if (o instanceof TypedElement) {
				inTypedElement((TypedElement) o);
			}
		});
	}

	private void inPropertyCallExp(PropertyCallExp o) {
		if (o.getName().equals("oclContainer")) {
			OperationCallExp newOp = IRBuilder.newOperationCallExp(o.getName(), o.getSource());
			EcoreUtil.replace(o, newOp);
		}
	}

	private void inTypedElement(TypedElement self) {
		if (self.getType() instanceof CollectionTypeRef) {
			CollectionTypeRef ref = (CollectionTypeRef) self.getType();
			if (ref instanceof OrderedSetTypeRef) {
				TypeRef newType = IRBuilder.newSetTypeRef(ref.getContainedType());
				EcoreUtil.replace(ref, newType);
			}
		}
	}

	// Report the changes?
	public void inOperationCallExp(@NonNull OperationCallExp self) {
		if ( self.getName().equals("oclAsSet") ) {			
			SetLiteralExp set = OclFactory.eINSTANCE.createSetLiteralExp();
			EcoreUtil.replace(self, set);			
			set.getParts().add(self.getSource());
			return;
		} else if (self.getName().equals("oclIsInvalid")) {
			// TODO: Report => This is probably what you mean:
			self.setName("oclIsUndefined");
		}
	}
	
}
