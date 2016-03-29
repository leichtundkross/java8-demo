package com.github.leichtundkross.java8.streams;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ProcessingOrder {

	public String print(Stream<String> stream) {
		StringBuilder sb = new StringBuilder();
		stream.filter(s -> {
			sb.append(" filter: ").append(s);
			return true;
		})
		.forEach(s -> sb.append(" forEach: ").append(s).append("\n"));

		return sb.toString().trim();
	}

	public int countOperations(Stream<String> stream) {
		AtomicInteger operations = new AtomicInteger(0);
		stream
		.map(s -> {
			operations.incrementAndGet();
			return s.toUpperCase();
		})
		.anyMatch(s -> {
			operations.incrementAndGet();
			return s.startsWith("A");
		});

		return operations.get();
	}

	public int orderMatters(Stream<String> stream) {
		AtomicInteger operations = new AtomicInteger(0);
		stream
		.sorted((s1, s2) -> {
			operations.incrementAndGet();
			return s1.compareTo(s2);
		})
		.filter(s -> {
			operations.incrementAndGet();
			return s.startsWith("a");
		})
		.forEach(s -> operations.incrementAndGet());

		return operations.get();
	}
	
	public int orderReallyMatters(Stream<String> stream) {
		AtomicInteger operations = new AtomicInteger(0);
		stream
		.filter(s -> {
			operations.incrementAndGet();
			return s.startsWith("a");
		})
		.sorted((s1, s2) -> {
			operations.incrementAndGet();
			return s1.compareTo(s2);
		})
		.forEach(s -> operations.incrementAndGet());

		return operations.get();
	}
}
