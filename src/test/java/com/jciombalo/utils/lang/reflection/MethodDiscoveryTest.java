package com.jciombalo.utils.lang.reflection;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class MethodDiscoveryTest {
	
	@Test
	public void given_a_method_reference_When_getting_Then_return_its_reflection() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method returningMethod = MethodDiscovery.getMethod(TestClass.class, TestClass::returningMethod);
		Method voidMethod = MethodDiscovery.getMethod(TestClass.class, TestClass::voidMethod);
		TestClass testObj = new TestClass();
		assertThat(returningMethod).isEqualTo(TestClass.class.getMethod("returningMethod"));
		assertThat(voidMethod).isEqualTo(TestClass.class.getMethod("voidMethod"));
		assertThat(returningMethod.invoke(testObj)).isEqualTo(testObj.returningMethod());
	}
	
}
