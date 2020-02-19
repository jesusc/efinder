package efinder.core.footprint;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;

import efinder.core.EFinderModel;
import efinder.core.utils.IRUtils;
import efinder.ir.EFClass;
import efinder.ir.EFEnum;
import efinder.ir.EFType;
import efinder.ir.Specification;
import efinder.ir.ocl.OclDerivedProperty;
import efinder.ir.ocl.OclOperation;

/**
 * A wrapper over EFinderModel which provides query facilities. 
 * 
 * @author jesus
 *
 */
public class IRFootprintedModel {

	private @NonNull EFinderModel model;
	private @NonNull IFootprint footprint;

	public IRFootprintedModel(@NonNull EFinderModel model, @NonNull IFootprint footprint) {
		this.model = model;
		this.footprint = footprint;
	}

	@NonNull
	public List<? extends EFClass> getAllClasses() {
		Specification spec = model.getSpecification();
		return spec.getMetamodels().stream()
				.flatMap(m -> m.getRoots().stream())
				.flatMap(p -> p.getClasses().stream())
				.filter(c -> footprint.hasClass(c.getKlass()))
				.collect(Collectors.toList());
	}

	@NonNull
	public List<? extends EAttribute> getAttributes(EClass c) {
		return c.getEAttributes().stream().filter(footprint::hasFeature).collect(Collectors.toList());
	}

	@NonNull
	public List<? extends EReference> getReferences(EClass c) {
		return c.getEReferences().stream().filter(footprint::hasFeature).collect(Collectors.toList());
	}
	
	@NonNull
	public List<? extends EFEnum> getAllEnumerations() {
		Specification spec = model.getSpecification();
		return spec.getMetamodels().stream()
				.flatMap(m -> m.getRoots().stream())
				.flatMap(p -> p.getEnumerations().stream())
				.collect(Collectors.toList());
	}

	@NonNull
	public Map<EFType, Collection<OclDerivedProperty>> getDerivedProperties() {
		Specification spec = model.getSpecification();
		// TODO: Also filter derived properties according to whether they are touched by contrainst or not (this doesn't appear in IFootprint now)
		return IRUtils.getDerivedPropertiesAsMap(spec, footprint);
	}

	@NonNull
	public Map<EFType, Collection<OclOperation>> getOperations() {
		Specification spec = model.getSpecification();
		return IRUtils.getOperationsAsMap(spec, footprint);		
	}

	@NonNull
	public Specification getSpecification() {
		return model.getSpecification();
	}

	
}
