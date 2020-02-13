package efinder.core;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public interface IBoundsProvider {

	Interval getScope(EClass klass);
	Interval getScope(EReference feature);
	int getDefaultMaxScope();
	
	public static class Interval {
		private int min;
		private int max;
		public Interval(int min, int max) {
			this.min = min;
			this.max = max;
		}
		
		public int getMin() { return min; }
		public int getMax() { return max; }
	}

	boolean incrementScope();
	
	// void setMetamodelRewrite(IMetamodelRewrite rewrite);

	public static final IBoundsProvider FIXED = new Fixed(5, 20);
	
	public static class Fixed implements IBoundsProvider {

		private int maxObjects;
		private int maxReferences;

		public Fixed(int maxObjects, int maxReferences) {
			this.maxObjects = maxObjects;
			this.maxReferences = maxReferences;
		}
		
		@Override
		public Interval getScope(EClass klass) {
			return new Interval(0, maxObjects);
		}

		@Override
		public Interval getScope(EReference feature) {
			return new Interval(0, maxReferences);
		}

		@Override
		public int getDefaultMaxScope() {
			return 5;
		}

		@Override
		public boolean incrementScope() {
			return false;
		}
		
	}
	
}
