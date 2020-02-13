package efinder.emfocl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Constraint;

/**
 * Record of the issues in the translation.
 * 
 * @author jesus
 */
public class Report {

	public static enum Action {
		IGNORE
	}

	public void addUnsupported(@NonNull String message, @NonNull Constraint object, @NonNull Action action) {
		System.out.println(message + "\n   - " + object + "\n   - " + action);
	}
	
}
