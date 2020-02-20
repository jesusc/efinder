package efinder.emfocl.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Model;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import efinder.core.EFinderModel;
import efinder.core.IModelFinder.Result;
import efinder.emfocl.PivotOclCompiler;
import efinder.emfocl.runner.EFinderRunner;
import efinder.usemv.UseMvFinder;

@RunWith(Parameterized.class)
public class ValidationTest extends AbstractEmfOclTest {
	
	@Parameters(name="{0}")
	public static Collection<Object[]> data() throws IOException {
		File folder = new File("resources/ocl");
		Files.list(folder.toPath()).forEach(System.out::println);
		return Files.list(folder.toPath()).filter(p -> p.toFile().getName().endsWith(".ocl")).map(f -> {
			File oclFile = f.toFile();
			String name = oclFile.getName().replace(".ocl", ".yaml");
			Path spec = f.resolveSibling(name);
			if (spec.toFile().exists()) {
				return new TestData("ocl/" + oclFile.getName(), spec.toFile());	
			}
			return new TestData("ocl/" + oclFile.getName(), null);
		}).map(d -> new Object[] { d }).collect(Collectors.toList());
	}
	
	private static class TestData {
		private @NonNull String oclFileName;
		private @NonNull File oracle;

		public TestData(@NonNull String oclFileName, @NonNull File oracle) {
			this.oclFileName = oclFileName;
			this.oracle = oracle;
		}
		
		public String getWitnessAsFileOutput() {
			return this.oclFileName.replace(".ocl", ".xmi");
		}
		
		@Override
		public String toString() {
			return oclFileName;
		}
	}

	private @NonNull TestData data;

	public ValidationTest(@NonNull TestData data) {
		this.data = data;
	}
	
	@Test
	public void testValidation() throws IOException {
		Model pivot = loadOclDocument(data.oclFileName);

		// Assume that in all tests there is a root class called Model
		TestBoundsProvider boundsProvider = new TestBoundsProvider().withInterval("Model", 1, 1); 
		UseMvFinder finder = new UseMvFinder().withBoundsProvider(boundsProvider);
				
		EFinderRunner runner = EFinderRunner.
				withOclModel(pivot).
				withFinder(finder);
		
		Result result = runner.find();
		
		// Save to debug, possibly use a flag
		if (result.isSat()) {
			saveModel("outputs/" + data.getWitnessAsFileOutput(), result.getWitness().getResource());
		}
		
		if (data.oracle != null ) {
			OclTestOracle oracle = readTestOracle(data.oracle.getAbsolutePath());
			oracle.assertResult(result);
		}
	}

}
