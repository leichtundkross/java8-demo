package com.github.leichtundkross.java8.streams;

import java.util.ArrayList;
import java.util.List;

import com.github.leichtundkross.java8.streams.model.Person;

/**
 * Reduce a stream of n elements to exactly one element
 */
public class Reduce {

	public int getPersonsMaxAge(List<Person> allPersons) {
		return allPersons //
				.stream() //
				// reduce takes a BiFunction, acts like a comparator
				.reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2) //
				.get().getAge();
	}

	public List<Person> getCharliesChildren(List<Person> mothers) {
		return mothers //
				.stream() //
				// reduce creates a new Person that will be 'aggregated' for all stream elements
				.reduce(new Person("Charlie", 50, new ArrayList<>()), (charlie, mother) -> {
					charlie.getChildren().addAll(mother.getChildren());
					return charlie;
				}) //
				.getChildren();
	}

	public List<Person> getCharliesChildren_SolveWithoutReduce(List<Person> mothers) {
		final Person charlie = new Person("Charlie", 50, new ArrayList<>());
		mothers //
				.stream() //
				.forEach(mother -> charlie.getChildren().addAll(mother.getChildren()));

		return charlie.getChildren();
	}
}
