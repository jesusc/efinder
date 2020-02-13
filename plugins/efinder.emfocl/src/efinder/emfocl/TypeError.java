package efinder.emfocl;

import org.eclipse.jdt.annotation.NonNull;

@SuppressWarnings("serial")
public class TypeError extends RuntimeException {
	
	public TypeError(@NonNull String message) {
		super(message);
	}

}
