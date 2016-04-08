package com.github.leichtundkross.java8.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.leichtundkross.java8.streams.model.Person;

public class FlatMap {

	/**
	 * @return a list of all 'direct' children
	 */
	public List<Person> getAllChildren(List<Person> parents) {
		return parents.stream() //
				.flatMap(parent -> parent.getChildren().stream()) //
				.collect(Collectors.toList());
	}

	/**
	 * @return a list of all children, grandchildren and so on
	 */
	public List<Person> getAllGrandchildren(List<Person> parents) {
		return parents //
				.stream() //
				.flatMap(parent -> parent.getChildren().stream().flatMap(FlatMap::mapRecursive)) //
				.collect(Collectors.toList());
	}

	private static Stream<Person> mapRecursive(Person p) {
		return Stream.concat(Stream.of(p), p.getChildren().stream().flatMap(FlatMap::mapRecursive));
	}
}
