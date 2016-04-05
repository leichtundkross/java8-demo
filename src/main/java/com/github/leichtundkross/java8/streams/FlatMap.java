package com.github.leichtundkross.java8.streams;

import java.util.List;
import java.util.stream.Collectors;

import com.github.leichtundkross.java8.streams.model.Person;

public class FlatMap {

	public List<Person> getAllChildren(List<Person> parents) {
		return parents.stream() //
				.flatMap(p -> p.getChildren().stream()) //
				.collect(Collectors.toList());
	}
}
