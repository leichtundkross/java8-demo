package com.github.leichtundkross.java8.staticmethods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class MyInterfaceTest {

	public static class MyImplementation implements MyInterface {

		@Override
		public Collection<String> someMethodToImplement() {
			return Arrays.asList("hello", "static", "method");
		}
	}

	@Test
	public void empty() {
		MyInterface emptyInstance = MyInterface.empty();

		assertNotNull(emptyInstance);
		assertEquals(0, emptyInstance.someMethodToImplement().size());
	}

	@Test
	public void inheritance() {
		// works:
		MyInterface.empty();

		// will not compile
		// MyImplementation.empty();
	}
}
