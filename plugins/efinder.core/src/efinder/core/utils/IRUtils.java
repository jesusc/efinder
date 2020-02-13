package efinder.core.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

import efinder.ir.AbstractFunction;
import efinder.ir.EFType;
import efinder.ir.Specification;
import efinder.ir.ocl.OclDerivedProperty;
import efinder.ir.ocl.OclOperation;

public class IRUtils {

	@NonNull
	public static Map<EFType, Collection<OclDerivedProperty>> getDerivedPropertiesAsMap(@NonNull Specification spec) {
		return asMap(spec.getProperties(), OclDerivedProperty.class);
	}

	@NonNull
	public static Map<EFType, Collection<OclOperation>> getOperationsAsMap(@NonNull Specification spec) {
		return asMap(spec.getOperations(), OclOperation.class);
	}

	@NonNull
	private static <T extends AbstractFunction, R> Map<EFType, Collection<R>> asMap(@NonNull Collection<? extends T> elements, Class<? extends R> type) {
		Map<EFType, Collection<R>> map = new HashMap<>();
		for (T e : elements) {
			if (type.isInstance(e)) {
				EFType ctx = e.getContext();
				map.computeIfAbsent(ctx, (k) -> new ArrayList<>());
				map.get(ctx).add(type.cast(e));
			}
		}
		return map;
	}	
	
}
