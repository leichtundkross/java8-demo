package com.github.leichtundkross.java8.streams;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.Test;

public class ProcessingOrderTest {

	@Test
	public void printTheRightWay() {
		String output = new ProcessingOrder().print(Stream.of("Hello", "World"));

		assertEquals("filter: Hello forEach: Hello\n" + //
				" filter: World forEach: World", output);
	}

	@Test
	public void countOperations() {
		int operations = new ProcessingOrder().countOperations(Stream.of("d2", "a2", "b1", "b3", "c"));

		assertEquals(4, operations);
	}

	@Test
	public void orderMatters() {
		int operations = new ProcessingOrder().orderMatters(Stream.of("d2", "a2", "b1", "b3", "c"));

		assertEquals(14, operations);
	}

	@Test
	public void orderReallyMatters() {
		int operations = new ProcessingOrder().orderReallyMatters(Stream.of("d2", "a2", "b1", "b3", "c"));

		assertEquals(6, operations);
	}
}
