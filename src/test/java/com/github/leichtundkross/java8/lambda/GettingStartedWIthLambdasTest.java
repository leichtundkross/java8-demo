package com.github.leichtundkross.java8.lambda;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GettingStartedWIthLambdasTest {

	@Test
	public void callInnerClass() {
		String returnValue = new GettingStartedWIthLambdas().callInnerClass();

		assertEquals("Hello Java7!", returnValue);
	}

	@Test
	public void callLambda() {
		String returnValue = new GettingStartedWIthLambdas().callLambda();

		assertEquals("Hello Java8!", returnValue);
	}
}
