package efinder.emfocl.tests.ocldataset;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import javax.xml.bind.DatatypeConverter;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import efinder.emfocl.tests.ocldataset.Dataset.Mode;

/**
 * Evaluates the OclDataset and reports statistics about coverage:
 * 
 * See https://github.com/tue-mdse/ocl-dataset
 * 
 * @author jesus
 *
 */
public class DatasetEvaluationTest {

	public static Set<String> invalidCases = getInvalidCases();	
	private static Set<String> getInvalidCases() {
		Set<String> invalids = new HashSet<String>();
		// This invariant is wrong because SelectionDivergence is type, not an enumerate
		//    invariant mustDefineTriggerIfComingFromDivergence: if self.incoming->collect(1_ : statesml::Edge[1] | 1_.source)->=(statesml::SelectionDivergence)
		invalids.add("edonjakupi/model-engineering/Lab 1/Group16_Lab1/model/statesml.ecore");

		// The meta-model is wrong, contains duplicated elements Student - Student
		invalids.add("siba88/ame/at.ac.tuwien.big.momot.examples.university.ocl/model/university_ocl.ecore");
		
		// The meta-model is wrong. Opposite is the same reference
		invalids.add("songhui/cspadapt/vmplacement/vmplace/model/VmPlacement-Backup.ecore");
		
		// There is a non-boolean invariant
		invalids.add("SSGunduz/foo/TicketSystemSerdarSuatGunduz/org.eclipse.example.Ticketmodel/model/Ticket.ecore");
		
		
		// REMOVE WHEN TIMEOUT IS IMPLEMENTED
		invalids.add("ablunk/dmx/dev-plugins/hub.sam.dmx/resources/dbl.ecore");
		
		// Invalid because a property with 'derivation' annotation is changeable => make the witness model creation fail
		invalids.add("adilinam/QVTdCaseStudy/org.eclipse.ocl.examples.xtext.tests/model/OCLinEcoreTutorial.ecore");
		
		return invalids;
	}

	
	@Test
	public void testEvaluation() throws FileNotFoundException, IOException, ParseException, Exception {
		String where = System.getenv("OCL_DATASET");		
		if (where == null) {
			where = System.getProperty("user.home") + "/third-party/ocl-dataset";			
		}
		String resultFolder = "result";
		doTest(where + "/dataset/meta.json", 
			   where + "/dataset/repos",
			   resultFolder);
	}

	private void doTest(@NonNull String metadataFile, @NonNull String repoDir, String results) throws FileNotFoundException, IOException, ParseException {
		Predicate<String> predicate = (f) -> true;
		// Uncomment and replace with the proper path if you want to test a single file
		//Predicate<String> onlyOneFile = (f) -> f.contains("M2TiiLEnvDev/TuringProject/model/projetTuring.ecore");
		//predicate = onlyOneFile;

		Mode evaluationMode = Mode.COMPLETE_FILE;
		Dataset dataset = load(metadataFile, repoDir, predicate);		
		Stats stats = dataset.evaluate(evaluationMode);
		stats.printTo(System.out);
	}
	
	
	private Dataset load(@NonNull String metaJson, @NonNull String repos, @Nullable Predicate<String> filter) throws FileNotFoundException, IOException, ParseException {
		Dataset dataset = new Dataset();
		
		JSONParser parser = new JSONParser();        
        Object obj = parser.parse(new FileReader(metaJson));
        JSONObject root = (JSONObject) obj;
        
        JSONObject files = (JSONObject) root.get("oclas");
        Map<String, String> hashToFile = new HashMap<>();
        
        for (Object key: files.keySet()) {
        	JSONArray elements = (JSONArray) files.get(key);

        	// Each element is a reference to an Ecore or an OCL file
        	for (Object object : elements) {
				String s = (String) object;				
				if ( filter != null && ! filter.test(s) )
					continue;
				
				Logger.log("Adding: " + s);
				
				String hash = hashFile(repos + File.separator + s);
				if ( hash != null ) {
					if ( hashToFile.containsKey(hash) ) {
						Logger.log("Duplicated: " + s);
						continue;
					}
					hashToFile.put(hash, s);
				}
				
				if ( invalidCases.contains(s) ) {
					continue;
				}
								
				if ( s.endsWith(".ocl")) {
					dataset.addOclFile(repos + File.separator + s);
				}
				else if ( s.endsWith(".ecore") ) {
					dataset.addEcoreFile(repos + File.separator + s);
				} else {
					throw new RuntimeException("Cannot handle: " + s);
				}
        	}
        }
        
        return dataset;
	}
	
	/** 
	 * Computes the hash of file. This is used here to use only unique files, per content.
	 */
	private String hashFile(String file) {
		try {
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 byte[] contents = Files.readAllBytes(new File(file).getAbsoluteFile().toPath());		 
		 md.update(contents);		 
		 byte[] digest = md.digest();		 
		 String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();		         	
		 return myHash;
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
	}
}
