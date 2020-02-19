package efinder.emfocl.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.eclipse.ocl.pivot.Model;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import efinder.core.EFinderModel;
import efinder.emfocl.PivotOclCompiler;
import tinytools.debug.DebugUtils;

public class EmfOclTranslationTest extends AbstractEmfOclTest {

	private static Logger LOG = LoggerFactory.getLogger(EmfOclTranslationTest.class); 
	
	@Test
	public void testTranslation() throws IOException {		
		Model pivot = loadOclDocument("ocl/people.ocl");
		
		PivotOclCompiler compiler = new PivotOclCompiler(pivot);
		EFinderModel model = compiler.compile();

		System.out.println(DebugUtils.toTree(model.getSpecification()));
		
		assertEquals(1, model.getSpecification().getMetamodels().size());
	}
	

}
