package efinder.emfocl.tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Model;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import efinder.core.EFinderModel;
import efinder.core.IModelFinder.Result;
import efinder.core.management.EMFModel;
import efinder.core.utils.ResourceUtils;
import efinder.emfocl.PivotOclCompiler;
import efinder.emfocl.runner.EFinderRunner;
import efinder.usemv.UseMvFinder;

public class RelSchemaExampleTest extends AbstractEmfOclTest {
	
	@Test
	public void testValidation() throws IOException {
		String xmiPartialModel = "partial-model-1.xmi";
		Model pivot = loadOclDocumentFromURI("efinder.emfocl.tests/resources/examples/relschema.ocl");
		EMFModel partialModel = ResourceUtils.fromFile("resources/examples/" + xmiPartialModel, "resources/examples/RelSchema.ecore");		

		// Assume that in all tests there is a root class called Model
		TestBoundsProvider boundsProvider = new TestBoundsProvider().withInterval("Model", 1, 1);
		UseMvFinder finder = new UseMvFinder()
				.withBoundsProvider(boundsProvider)
				.withPartialModel(partialModel);
		
		EFinderRunner runner = EFinderRunner.
				withOclModel(pivot).
				withFinder(finder);
		
		Result result = runner.find();
		if (result.isSat()) {
			Resource model = result.getWitness().getResource();
			model.save(new FileOutputStream("outputs/" + xmiPartialModel.replace(".xmi",".complete.xmi")), null);
		
		}
//		// Save to debug, possibly use a flag
//		if (result.isSat()) {
//			Resource model = result.getWitness().getResource();
//			model.save(new FileOutputStream("outputs/" + data.getWitnessAsFileOutput()), null);
//		}
//		
//		if (data.oracle != null ) {
//			OclTestOracle oracle = readTestOracle(data.oracle.getAbsolutePath());
//			oracle.assertResult(result);
//		}
	}

}
