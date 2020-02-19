package efinder.emfocl.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS;

public abstract class AbstractEmfOclTest {

	/**
	 * For instance, if fileName = "people.ocl" it would load:
	 *    
	 *    "efinder.emfocl.tests/resources/ocl/people.ocl"
	 * 
	 * @param fileName
	 * @return
	 */
	protected Model loadOclDocument(@NonNull String fileName) {
		return loadOclDocumentFromURI("efinder.emfocl.tests/resources/" + fileName);
	}
	
	protected Model loadOclDocumentFromURI(@NonNull String uri) {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.getResource(URI.createPlatformPluginURI(uri, true), true);
			
		CompleteOCLDocumentCS document = (CompleteOCLDocumentCS) r.getContents().get(0);
		assertEquals(0,  r.getErrors().size());
		Model pivot = (Model) document.getPivot();
		
		return pivot;
	}

	protected OclTestOracle readTestOracle(@NonNull String fileName) throws IOException {
		return OclTestOracle.newTestOracle(fileName);
	}
	
	protected void saveModel(String fileName, @NonNull Resource model) throws FileNotFoundException, IOException {
		File f = new File(fileName);
		if (! f.getParentFile().exists()) 
			f.getParentFile().mkdirs();
		model.save(new FileOutputStream(f), null);		
	}

}
