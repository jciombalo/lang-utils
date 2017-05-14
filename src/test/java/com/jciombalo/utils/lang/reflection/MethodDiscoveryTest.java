package com.jciombalo.utils.lang.reflection;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class MethodDiscoveryTest {
	
	@Test
	public void given_a_method_reference_When_getting_Then_return_its_reflection() throws NoSuchMethodException, SecurityException {
		Method m = MethodDiscovery.getMethod(TestClass.class, TestClass::testMethod);
		assertThat(m).isEqualTo(TestClass.class.getMethod("testMethod"));
	}
	
	@Test
	public void given_a_discovered_method_When_invoking_Then_return_its_original_value() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method m = MethodDiscovery.getMethod(TestClass.class, TestClass::testMethod);
		TestClass testObj = new TestClass();
		assertThat(m.invoke(testObj)).isEqualTo(testObj.testMethod());
	}
}
