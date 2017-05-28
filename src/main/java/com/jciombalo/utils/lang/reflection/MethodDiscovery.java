package com.jciombalo.utils.lang.reflection;

import java.lang.reflect.Method;
import java.util.function.Consumer;
import java.util.function.Function;

import net.sf.cglib.proxy.Enhancer;

/**
 * Provides auxiliary methods to help when dealing with {@link Function} references.
 * 
 * @author Jorge.Ciombalo
 *
 */
public class MethodDiscovery {

	/**
	 * Discovers the {@link Method} reflection of a given function reference.
	 * 
	 * @param clazz
	 *            The class owner of the Method to be discovered.
	 * @param function
	 *            Function reference that needs to be discovered.
	 * @return The {@link Method} of the given function reference.
	 */
	public static <T, R> Method getMethod(Class<T> clazz, Function<T, R> function) {
		MethodRecorder recorder = new MethodRecorder();
		@SuppressWarnings("unchecked")
		T obj = (T) Enhancer.create(clazz, recorder);
		function.apply(obj);
		return recorder.getInvokedMethod();
	}
	
	public static <T> Method getMethod(Class<T> clazz, Consumer<T> consumer) {
		MethodRecorder recorder = new MethodRecorder();
		@SuppressWarnings("unchecked")
		T obj = (T) Enhancer.create(clazz, recorder);
		consumer.accept(obj);
		return recorder.getInvokedMethod();
	}

	protected MethodDiscovery() {
		super();
	}

}
