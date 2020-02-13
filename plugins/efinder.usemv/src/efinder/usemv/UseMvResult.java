package efinder.usemv;

import org.eclipse.jdt.annotation.NonNull;

import efinder.core.IModelFinder.Result;
import efinder.core.IModelFinder.Status;
import efinder.core.management.EMFModel;

public abstract class UseMvResult implements Result {

	public static class SAT extends UseMvResult {
		
		@NonNull
		private EMFModel witness;

		public SAT(@NonNull EMFModel witness) {
			this.witness = witness;
		}

		@Override
		public @NonNull Status getStatus() {
			return Status.SAT;
		}		
		
		@Override
		public EMFModel getWitness() {
			return witness;
		}
		
	}


	public static class UNSAT extends UseMvResult {

		@Override
		public @NonNull Status getStatus() {
			return Status.UNSAT;
		}

		@Override
		public EMFModel getWitness() {
			throw new IllegalStateException();
		}

	}

	
	
}
