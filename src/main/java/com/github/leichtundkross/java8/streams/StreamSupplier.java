package com.github.leichtundkross.java8.streams;

import java.util.function.Supplier;
import java.util.stream.Stream;

class StreamSupplier {

	Stream<String> createStream() {
		Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c");
		return stream;
	}

	Supplier<Stream<String>> createStreamSupplier() {
		Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c");
		Supplier<Stream<String>> streamSupplier = () -> stream;
		return streamSupplier;
	}
}
