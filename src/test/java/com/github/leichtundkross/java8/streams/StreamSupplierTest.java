package com.github.leichtundkross.java8.streams;

import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamSupplierTest {

	private StreamSupplier supplier = new StreamSupplier();

	@Test(expected = IllegalStateException.class)
	public void reuseAStrem() {
		Stream<String> stream = supplier.createStream();

		// first terminal operation on a stream: ok
		stream.anyMatch(s -> true);

		// another terminal operation on a stream: exception
		stream.noneMatch(s -> true);
	}

	@Test
	public void reuseAStremWithSupplier() {
		Supplier<Stream<String>> streamSupplier = supplier.createStreamSupplier();

		// calling get() on the supplier creates a new stream
		streamSupplier.get().anyMatch(s -> true);

		// calling get() again creates another stream
		streamSupplier.get().noneMatch(s -> true);
	}
}
