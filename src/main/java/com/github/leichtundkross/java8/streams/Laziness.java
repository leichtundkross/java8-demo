package com.github.leichtundkross.java8.streams;

import java.util.stream.Stream;

public class Laziness {

	public String printTheWrongWay(Stream<String> stream) {
		StringBuilder sb = new StringBuilder();
		// filter is a lazy operation
		// lazy operations will only be executed when a terminal operation is present
		stream.filter(s -> {
			sb.append(s).append(" ");
			return true;
		});

		return sb.toString().trim();
	}

	/**
	 * This method works. However, the 'right way' - using filter() instead of forEach() - is not the best way.
	 */
	public String printTheRightWay(Stream<String> stream) {
		StringBuilder sb = new StringBuilder();
		stream.filter(s -> {
			sb.append(s).append(" ");
			return true;
		}) //
			// count is a terminal operation and leads to execution of operation pipeline
				.count();

		return sb.toString().trim();
	}
}
