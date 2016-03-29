package com.github.leichtundkross.java8.streams;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.Test;

public class LazinessTest {

	@Test
	public void printTheWrongWay() {
		String output = new Laziness().printTheWrongWay(Stream.of("Hello", "World"));

		assertEquals("", output);
	}

	@Test
	public void printTheRightWay() {
		String output = new Laziness().printTheRightWay(Stream.of("Hello", "World"));

		assertEquals("Hello World", output);
	}
}
