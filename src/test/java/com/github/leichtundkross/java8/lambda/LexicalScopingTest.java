package com.github.leichtundkross.java8.lambda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LexicalScopingTest {

	@Test
	public void sayHello() {
		String greetings = new LexicalScoping().sayHello();

		// anonymous toString() is called
		assertTrue(greetings.startsWith("com.github.leichtundkross.java8.lambda.LexicalScoping$"));
	}

	@Test
	public void sayHelloLambda() {
		String greetings = new LexicalScoping().sayHelloLambda();

		// toString() of next outermost scope is called
		assertEquals("LexicalScoping's toString()", greetings);
	}
}
