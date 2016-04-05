package com.github.leichtundkross.java8.lambda;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EasyComparisonTest {

	@Test
	public void compareStrings() {
		int returnValue = new EasyComparison().compareStrings("Hello", "Java7");

		assertTrue(returnValue < 0);
	}

	@Test
	public void compareStringsWithJava8() {
		int returnValue = new EasyComparison().compareStringsWithJava8("Hello", "Java7");

		assertTrue(returnValue < 0);
	}

	@Test
	public void compareStringsWithJava8Shorter() {
		int returnValue = new EasyComparison().compareStringsWithJava8Shorter("Hello", "Java7");

		assertTrue(returnValue < 0);
	}

	@Test
	public void compareStringsWithJava8EvenShorter() {
		int returnValue = new EasyComparison().compareStringsWithJava8EvenShorter("Hello", "Java7");

		assertTrue(returnValue < 0);
	}
}
