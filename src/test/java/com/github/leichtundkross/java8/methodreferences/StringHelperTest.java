package com.github.leichtundkross.java8.methodreferences;

import static org.junit.Assert.assertEquals;

import java.util.function.Supplier;

import org.junit.Test;

public class StringHelperTest {

	private StringHelper printer = new StringHelper();

	@Test
	public void getLength_innerClass() {
		final StringBuilder builder = new StringBuilder() //
				.append("how ") //
				.append("long ") //
				.append("is ") //
				.append("this ") //
				.append("string?");

		int length = printer.getLength(new Supplier<String>() {

			@Override
			public String get() {
				return builder.toString();
			}
		});

		assertEquals(24, length);
	}

	@Test
	public void getLength_simpleLambda() {
		StringBuilder builder = new StringBuilder() //
				.append("how ") //
				.append("long ") //
				.append("is ") //
				.append("this ") //
				.append("string?");

		int length = printer.getLength(() -> builder.toString());

		assertEquals(24, length);
	}

	@Test
	public void getLength_boundMethodReferenz() {
		StringBuilder builder = new StringBuilder() //
				.append("how ") //
				.append("long ") //
				.append("is ") //
				.append("this ") //
				.append("string?");

		// bound non-static method, expect objectName::instanceMethodName
		int length = printer.getLength(builder::toString);

		assertEquals(24, length);
	}

	@Test
	public void getLength_unboundMethodReferenz() {
		StringBuilder builder = new StringBuilder() //
				.append("how ") //
				.append("long ") //
				.append("is ") //
				.append("this ") //
				.append("string?");

		// unbound non-static method, expect className::instanceMethodName
		int length = printer.getLength(StringBuilder::toString, builder);

		assertEquals(24, length);
	}

	@Test
	public void getLength_constructorMethodReferenz() {
		// Constructor, expect className::new
		int length = printer.getLength(String::new);

		assertEquals(0, length);
	}
}
