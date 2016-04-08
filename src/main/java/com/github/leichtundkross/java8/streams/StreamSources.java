package com.github.leichtundkross.java8.streams;

import java.util.Random;
import java.util.stream.Stream;

public class StreamSources {

	public Stream<Integer> fromListOfValues() {
		return Stream.of(1, 2, 3, 4);
	}

	public Stream<Integer> customGenerator() {
		return Stream.generate(() -> {
			Random random = new Random();
			return random.nextInt();
		});
	}

	public Stream<Integer> empty() {
		return Stream.empty();
	}

	public Stream<Integer> concat() {
		return Stream.concat(Stream.of(1), customGenerator());
	}
}
