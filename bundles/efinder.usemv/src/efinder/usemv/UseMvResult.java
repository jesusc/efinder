package efinder.usemv;

import org.eclipse.jdt.annotation.NonNull;

import efinder.core.IModelFinder.Result;
import efinder.core.IModelFinder.Status;
import efinder.core.errors.Report;
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
	
	public static class Unsupported extends UseMvResult {

		private Report report;

		public Unsupported(@NonNull Report report) {
			this.report = report;
		}
		
		@Override
		public @NonNull Status getStatus() {
			return Status.UNSUPPORTED_FEATURE;
		}

		@Override
		public @NonNull EMFModel getWitness() {
			throw new IllegalStateException();
		}
		
		@NonNull
		public Report getReport() {
			return report;
		}
	}

	public static class UnsupportedTranslation extends UseMvResult {

		private @NonNull String useErrors;

		public UnsupportedTranslation(@NonNull String useErrors) {
			this.useErrors = useErrors;
		}
		
		@Override
		public @NonNull Status getStatus() {
			return Status.INVALID_TRANSLATION;
		}

		@Override
		public @NonNull EMFModel getWitness() {
			throw new IllegalStateException();
		}

		@NonNull
		public String getUseErrors() {
			return useErrors;
		}
		
	}
	
	
}
