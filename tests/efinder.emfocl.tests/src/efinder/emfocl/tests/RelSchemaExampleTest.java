package efinder.emfocl.tests;

import static org.junit.Assert.assertTrue;

import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.pivot.Model;
import org.junit.Test;

import efinder.core.IModelFinder.Result;
import efinder.core.management.EMFModel;
import efinder.core.utils.ResourceUtils;
import efinder.emfocl.runner.EFinderRunner;
import efinder.usemv.UseMvFinder;

public class RelSchemaExampleTest extends AbstractEmfOclTest {
	
	@Test
	public void testValidation() throws IOException {
		Model pivot = loadOclDocumentFromURI("efinder.emfocl.tests/resources/examples/relschema.ocl");

		// Assume that in all tests there is a root class called Model
		TestBoundsProvider boundsProvider = new TestBoundsProvider()
				.withInterval("RelModel", 1, 1)
				.withInterval("RelSchema", 1, 1)
				.withInterval("AttrMap", 2, 2);
		
		UseMvFinder finder = new UseMvFinder()
				.withBoundsProvider(boundsProvider);
		
		EFinderRunner runner = EFinderRunner.
				withOclModel(pivot).
				withFinder(finder);
		
		Result result = runner.find();
		assertTrue(result.isSat());
		
		Resource model = result.getWitness().getResource();
		model.save(new FileOutputStream("outputs/" + "relschema.xmi"), null);
	}

	@Test
	public void testPartialModel() throws IOException {
		String xmiPartialModel = "partial-model-1.xmi";
		Model pivot = loadOclDocumentFromURI("efinder.emfocl.tests/resources/examples/relschema.ocl");
		EMFModel partialModel = ResourceUtils.fromFile("resources/examples/" + xmiPartialModel, "resources/examples/RelSchema.ecore");		

		// Assume that in all tests there is a root class called Model
		TestBoundsProvider boundsProvider = new TestBoundsProvider()
				.withInterval("RelModel", 1, 1)
				.withInterval("Attribute", 3, 3) /* Make it has one more attribute */
				.withInterval("Row", 1, 1)
				.withInterval("AttrMap", 2, 2)
				.withInterval("Value", 1, 4)
				;
		
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
