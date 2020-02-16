package efinder.usemv;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.Collections;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalINIConfiguration;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.tzi.kodkod.model.config.impl.PropertyConfigurationVisitor;
import org.tzi.kodkod.model.iface.IInvariant;
import org.tzi.kodkod.model.iface.IModel;
import org.tzi.use.kodkod.UseKodkodModelValidator;
import org.tzi.use.kodkod.UseScrollingKodkodModelValidator;
import org.tzi.use.kodkod.plugin.PluginModelFactory;
import org.tzi.use.kodkod.transform.InvariantTransformator;
import org.tzi.use.kodkod.transform.enrich.ModelEnricher;
import org.tzi.use.kodkod.transform.enrich.ObjectDiagramModelEnricher;
import org.tzi.use.main.Session;
import org.tzi.use.parser.use.USECompiler;
import org.tzi.use.uml.mm.MClassInvariant;
import org.tzi.use.uml.mm.MModel;
import org.tzi.use.uml.mm.ModelFactory;
import org.tzi.use.uml.sys.MSystem;
import org.tzi.use.uml.sys.MSystemState;

import com.google.common.annotations.VisibleForTesting;

import efinder.core.EFinderModel;
import efinder.core.IBoundsProvider;
import efinder.core.IModelFinder;
import efinder.core.errors.Report;
import efinder.core.errors.UnsupportedTranslationException;
import efinder.core.management.EMFModel;
import efinder.usemv.UseMvResult.UnsupportedTranslation;
import efinder.usemv.ir.BoundsCompiler;
import efinder.usemv.ir.UseFeatureChecker;
import efinder.usemv.ir.UseMvBackendCompiler;
import kodkod.engine.Solution;
import kodkod.engine.Solution.Outcome;

public class UseMvFinder implements IModelFinder {

	public static enum FindingMode {
		NORMAL,
		SCROLL,
		SCROLL_ALL
	}
	
	/** Default scope provider just uses (0, 5) intervals */
	private IBoundsProvider scopeProvider = IBoundsProvider.FIXED;
	
	private FindingMode mode = FindingMode.NORMAL;	
	protected Session fSession;
	private IUseInputPartialModel partialModel;
	private int timeOutMillis = -1;
	
	public UseMvFinder() {
		// Can I have several sessions in parallel?
		fSession = new Session();
	}

	@Override
	public @NonNull String backendId() {
		return "use";
	}
	
	@Override
	public @NonNull Result find(@NonNull EFinderModel ir) {
		Report report = new UseFeatureChecker().check(ir);
		if (report.isUnsupported()) {
			return new UseMvResult.Unsupported(report);
		}
		
		UseMvBackendCompiler compiler;
		UseModel model;
		try {
			compiler = new UseMvBackendCompiler(ir);		
			model = compiler.compile();
			System.out.println(model.getText());
		} catch (UnsupportedTranslationException e) {
			report.addUnsupported(e.getMessage(), null, Report.Action.STOP, e.getReason());
			return new UseMvResult.Unsupported(report);
		}
		
		BoundsCompiler bounds = new BoundsCompiler(ir, compiler.getMapping());
		System.out.println(bounds.toProperties(scopeProvider));
		
		StringReader inputScopeProperties = new StringReader(bounds.toProperties(scopeProvider));
		
		UseMvResult r = doFind(ir, model, inputScopeProperties);
		return r;
	}

	
	@NonNull
	public UseMvFinder withMode(@NonNull FindingMode mode) {
		this.mode = mode;
		return this;
	}
	
	@Override
	public UseMvFinder withTimeOut(int millis) {
		this.timeOutMillis  = millis;
		return this;
	}
	
	@NonNull
	public UseMvFinder withBoundsProvider(@NonNull IBoundsProvider provider) {
		this.scopeProvider = provider;
		return this;
	}
	
	@NonNull
	public UseMvFinder withPartialModel(@NonNull EMFModel partialModel) {
		return withPartialModel(new UseInputPartialModel(partialModel));
	}
		
	@VisibleForTesting
	/* pp */ @NonNull UseMvFinder withPartialModel(IUseInputPartialModel partialModel) {
		this.partialModel = partialModel;
		return this;
	}

	public static interface InternalSolutionGetter {
		public Solution getSolution();
	}

	public class InternalUseValidator extends UseKodkodModelValidator implements InternalSolutionGetter {
		public InternalUseValidator(Session session) {
			super(session);

		}
		
		public Solution getSolution() {
			return solution;
		}
	}
	
	public class InternallScrollingMV extends UseScrollingKodkodModelValidator implements InternalSolutionGetter {

		private boolean finished = false;
		
		public InternallScrollingMV(Session session) {
			super(session);
		}
		
		public Solution getSolution() {
			return solution;
		}		
		
		@Override
		protected void unsatisfiable() {
			finished = true;
		}
		
		@Override
		protected void trivially_unsatisfiable() {
			finished = true;
		}
		
		public boolean isFinished() {
			return finished;
		}
	}
	
	@VisibleForTesting
	/* pp */ UseMvResult doFind(@NonNull EFinderModel ir, UseModel useModel, @NonNull StringReader metamodelBounds) {
		ByteArrayInputStream inputUseSpecification = new ByteArrayInputStream(useModel.getText().getBytes());

		KodkodResult kodkod;
		try {
			kodkod = doFind(inputUseSpecification, metamodelBounds);
		} catch (InvalidUseTranslation e) {
			return e.getResult();
		}

		UseMvResult r;
		if (kodkod != null && kodkod.isSatisfiable()) {			
			EMFModel witness = useModel.toEMF(fSession.system().state());
			r = new UseMvResult.SAT(witness);
		} else {
			r = new UseMvResult.UNSAT();
		}
		
		return r;
	}

	
	@Nullable
	/* pp */ KodkodResult doFind(ByteArrayInputStream inputUseSpecification, @NonNull StringReader metamodelBounds) throws InvalidUseTranslation {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		PrintWriter fLogWriter = new PrintWriter(output);		
		MModel model = USECompiler.compileSpecification(inputUseSpecification, "<generated>", fLogWriter, new ModelFactory());       
        
        MSystem system;
        if (model != null) {
            // fLogWriter.println(model.getStats());
            // create system
            system = new MSystem(model);
            // Possibly only if some kind of debug flag is active
            System.out.println(output.toString());
        } else {
            system = null;
            // Log always
            System.out.println(output.toString());
            throw new InvalidUseTranslation(new UseMvResult.UnsupportedTranslation(output.toString()));
        }
                
        fSession.setSystem(system);
        
        // PluginModelFactory.INSTANCE.registerForSession(fSession);
		PluginModelFactory.INSTANCE.onClassInvariantUnloaded(null); // new in USE 4.1.1 (enforce model reload)
		UseKodkodModelValidator modelValidator = new InternalUseValidator(fSession);
		
		if ( mode == FindingMode.SCROLL ) {
			// modelValidator = new UseScrollingKodkodModelValidator(fSession);
			modelValidator = new InternallScrollingMV(fSession);
		} else if ( mode == FindingMode.SCROLL_ALL ) {
			// modelValidator = new UseScrollingAllKodkodModelValidator(fSession);
			modelValidator = new InternallScrollingMV(fSession);
		}


		if (partialModel != null) {
			partialModel.makeUseObjects(fSession);
		}
		/*
		
		// UseScrollingKodkodModelValidator scrolling = new UseScrollingKodkodModelValidator(fSession);
		
		if ( partialModel != null ) {
			partialModel.init(fSession);
		}		
*/
		// Partial model
//		if ( true ) {
//			UseSystemApi sysApi = UseSystemApi.create(fSession);
//			try {
//				MObject p = sysApi.createObject("Person", "personABC");				
//			} catch (UseApiException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		

		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(InvariantTransformator.class);
		WriterAppender appender = new WriterAppender(new SimpleLayout(), bs);
		logger.addAppender(appender);
				
        org.tzi.kodkod.model.iface.IModel kodkodModel = PluginModelFactory.INSTANCE.getModel(system.model());        

		logger.removeAppender(appender);
		String useOutput = bs.toString();
        if ( useOutput.contains("Cannot transform invariant") ) {
        	// This will end-up into a NOT_SUPPORTED_BY_USE
        	// return new Pair<Outcome, Boolean>(Outcome.UNSATISFIABLE, false);
        	return null;
        }
    	
		// configure
		org.apache.commons.configuration.Configuration config = extractConfigFromFile(metamodelBounds);
		
		kodkodModel.reset();
		PropertyConfigurationVisitor newConfigurationVisitor = new PropertyConfigurationVisitor(config, fLogWriter);
		kodkodModel.accept(newConfigurationVisitor);
		
		if (newConfigurationVisitor.containErrors()) {
			System.out.println("error! " + newConfigurationVisitor.toString());
			return null;
			// throw new ConfigurationException(LogMessages.configurationError);
		}
		// end-of-configure

		UseUtils.printModel(system);		
		
		// Log.setDebug(true);

		// ModelEnricher enricher = KodkodModelValidatorConfiguration.INSTANCE.getModelEnricher(); ==> Returns a NullModelEnricher
		ModelEnricher enricher = new ObjectDiagramModelEnricher();		
        org.tzi.kodkod.model.iface.IModel kodkodModel2 = PluginModelFactory.INSTANCE.getModel(system.model());        
		enricher.enrichModel(system, kodkodModel2);
		
		configureInvariantSettingsFromGenerator(kodkodModel2, model);		

		modelValidator.validate(kodkodModel2);
		
		// no this.atoms.
		
        //fSession.system().registerPPCHandlerOverride(Shell.getInstance());
		MSystemState result = system.state();	
//		KodkodModelValidatorConfiguration.INSTANCE.setBitwidth(8);
//		KodkodModelValidatorConfiguration.INSTANCE.setSatFactory("DefaultSAT4J");
		
//		.put("defaultsat4j", "DefaultSAT4J")
//		.put("lightsat4j", "LightSAT4J")
//		.put("lingeling", "Lingeling")
//		.put("minisat", "MiniSat")
//		.put("minisatprover", "MiniSatProver")
//		.put("cryptominisat", "CryptoMiniSat")
//		.put("zchaffmincost", "ZChaffMincost")

		
		// check whether the result satisfies all invariants
		boolean     ok = result.check(fLogWriter, true, true, true, Collections.<String>emptyList());
		System.out.println(ok);
		
		System.out.println("=> After kodkod");
		UseUtils.printModel(system);
		
		Solution solution = ((InternalSolutionGetter) modelValidator).getSolution();
		if (solution == null) {
			// Kodkod couldn't find a solution.
			// An example is when the bounds are less that what it is required by the constraint
			return null;
		}
		
		//this.result = result;
		Outcome outcome = solution.outcome();
		System.out.println(outcome);
		if ( outcome == null )
			return null;

		/*
		if ( ok && (outcome == Outcome.SATISFIABLE || outcome == Outcome.TRIVIALLY_SATISFIABLE) && (mode == FindingMode.SCROLL || mode == FindingMode.SCROLL_ALL) ) {
			this.scrollingValidator = (InternallScrollingMV) modelValidator;
		} 
		*/

		return new KodkodResult(outcome, ok);
	}

	/* pp */ static class KodkodResult {
		private Outcome outcome;
		private boolean satisfyAllInvariants;

		public KodkodResult(Outcome outcome, boolean satisfyAllInvariants) {
			this.outcome = outcome;
			this.satisfyAllInvariants = satisfyAllInvariants;
		}
		
		public boolean isSatisfiable() {
			return satisfyAllInvariants && 
					outcome == Outcome.SATISFIABLE ||
					outcome == Outcome.TRIVIALLY_SATISFIABLE;
		}
	}
	
	
	private void configureInvariantSettingsFromGenerator(IModel model, MModel mModel) {
		for(IInvariant inv : model.classInvariants()){
			MClassInvariant srcInv = mModel.getClassInvariant(inv.qualifiedName());
			if(!srcInv.isActive() && inv.isActivated()){
				inv.deactivate();
				// LOG.info(LogMessages.flagChangeInfo(inv, true));
				continue;
			}
			
			if(srcInv.isNegated() && !inv.isNegated()){
				inv.negate();
				// LOG.info(LogMessages.flagChangeInfo(inv, false));
				continue;
			}
		}
	}
	
	protected Configuration extractConfigFromFile(Reader reader) {
		// ConfigurablePlugin#extractConfigFromFile
		HierarchicalINIConfiguration hierarchicalINIConfiguration = new HierarchicalINIConfiguration();
		try {
			hierarchicalINIConfiguration.load(reader);
		} catch (ConfigurationException e) {
			throw new IllegalStateException(e);
		}
		if(hierarchicalINIConfiguration.getSections().isEmpty()){
			return hierarchicalINIConfiguration.getSection(null);
		} else {
			String section = (String) hierarchicalINIConfiguration.getSections().iterator().next();
			return hierarchicalINIConfiguration.getSection(section);
		}
	}

	private static class InvalidUseTranslation extends Exception {		
		private static final long serialVersionUID = 6690365179442013481L;
		private efinder.usemv.UseMvResult.UnsupportedTranslation result;
		
		public InvalidUseTranslation(efinder.usemv.UseMvResult.UnsupportedTranslation invalidTranslation) {
			this.result = invalidTranslation;
		}
		
		public efinder.usemv.UseMvResult.UnsupportedTranslation getResult() {
			return result;
		}
	}
}
