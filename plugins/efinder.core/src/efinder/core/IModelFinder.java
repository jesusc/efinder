package efinder.core;

import org.eclipse.jdt.annotation.NonNull;

import efinder.core.management.EMFModel;

public interface IModelFinder {
	
	@NonNull
	public Result find(@NonNull EFinderModel spec);
	
	/**
	 * @return A unique id to represent this particular backend.
	 */
	@NonNull
	public String backendId();
	
	/** Configuration options */
	@NonNull
	public IModelFinder withBoundsProvider(@NonNull IBoundsProvider provider);

	@NonNull
	public IModelFinder withTimeOut(int millis);

	public static interface Result {		
		
		@NonNull
		Status getStatus();
		
		@NonNull
		EMFModel getWitness();		
		
		default boolean isSat() { 
			return getStatus() == Status.SAT;
		}
		
		default boolean isUnsat() { 
			return getStatus() == Status.UNSAT;
		}

	}

	public static enum Status {
		SAT,
		UNSAT,
		UNSUPPORTED_FEATURE,
		INVALID_TRANSLATION
	}
}
