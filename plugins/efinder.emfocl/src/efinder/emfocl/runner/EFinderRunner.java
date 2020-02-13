package efinder.emfocl.runner;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Model;

import com.google.common.base.Preconditions;

import efinder.core.EFinderModel;
import efinder.core.IDialectAdaptation;
import efinder.core.IModelFinder;
import efinder.core.IModelFinder.Result;
import efinder.emfocl.PivotOclCompiler;
import efinder.emfocl.use.EMFOCL2UseFixer;

public class EFinderRunner {

	private final @NonNull Model pivot;
	private @NonNull IModelFinder finder;
	private final @NonNull TransformRegistry registry = new TransformRegistry();
	
	public EFinderRunner(@NonNull Model pivot) {
		this.pivot = pivot;
		// Configuration:
		registry.add("use", new EMFOCL2UseFixer());
		
	}
	
	@NonNull
	public static EFinderRunner withOclModel(@NonNull Model pivot) {
		return new EFinderRunner(pivot);
	}
	
	@NonNull
	public EFinderRunner withFinder(@NonNull IModelFinder finder) {
		this.finder = finder;
		return this;
	}

	@NonNull 
	public Result find() {
		PivotOclCompiler compiler = new PivotOclCompiler(pivot);
		EFinderModel ir = compiler.compile();	
		// TODO: Set the bounds and different configuration options in Finder
		Preconditions.checkState(this.finder != null);
		
		List<? extends IDialectAdaptation> transforms = registry.get(finder.backendId());
		for (IDialectAdaptation adaptation : transforms) {
			adaptation.transform(ir);
		}
		
		return finder.find(ir);
	}
	
	
}
