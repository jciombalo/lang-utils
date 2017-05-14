package com.jciombalo.utils.lang.reflection;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Proxy class that intercepts the function call and tracks the method invoked.
 * 
 * @author Jorge.Ciombalo
 *
 */
class MethodRecorder implements MethodInterceptor {
	
	Method invokedMethod;
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		this.invokedMethod = method;
		return null;
	}

	public Method getInvokedMethod() {
		return invokedMethod;
	}
	
}
