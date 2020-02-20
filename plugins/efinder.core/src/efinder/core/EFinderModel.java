package efinder.core;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;

import com.google.common.collect.ImmutableMap;

import efinder.ir.Specification;

/**
 * Represents an IR model
 * 
 * @author jesus
 *
 */
public class EFinderModel {

	private @NonNull Specification specification;
	
	public EFinderModel(@NonNull Specification specification) {
		this.specification = specification;
	}
	
	/**
	 * Puts the current specification into the given resource.
	 *  
	 * @return The same resource given as argument
	 */
	@NonNull
	public Resource asResource(@NonNull Resource r) {
		if (specification.eResource() != null)
			throw new IllegalStateException();
		
		r.getContents().add(specification);
		return r;
	}

	@NonNull
	public Specification getSpecification() {
		return specification;
	}
	
}
