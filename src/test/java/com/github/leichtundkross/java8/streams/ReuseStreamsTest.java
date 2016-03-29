package com.github.leichtundkross.java8.streams;

import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

public class ReuseStreamsTest {

	@Test(expected = IllegalStateException.class)
	public void reuseAStrem() {
		Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c");

		// ok
		stream.anyMatch(s -> true);

		// exception
		stream.noneMatch(s -> true);
	}

	@Test
	public void reuseAStremWithSupplier() {
		Supplier<Stream<String>> streamSupplier = () -> Stream.of("d2", "a2", "b1", "b3", "c");

		// ok
		streamSupplier.get().anyMatch(s -> true);

		// ok
		streamSupplier.get().noneMatch(s -> true);
	}
}
