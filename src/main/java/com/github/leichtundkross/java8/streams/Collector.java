package com.github.leichtundkross.java8.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.github.leichtundkross.java8.streams.model.Person;

public class Collector {

	public List<Person> getPersonsOlderThan18(List<Person> allPersons) {
		return allPersons //
				.stream() //
				.filter(p -> p.getAge() >= 18) //
				.collect(Collectors.toList());
	}

	public Map<Integer, List<Person>> groupPersonsByAge(List<Person> allPersons) {
		return allPersons //
				.stream() //
				.collect(Collectors.groupingBy(p -> p.getAge()));
	}

	public Map<String, Person> toMapByName(List<Person> allPersons) {
		return allPersons //
				.stream() //
				.collect(Collectors.toMap( //
						p -> p.getName(), //
						p -> p));
	}

	public double getPersonsAverageAge(List<Person> allPersons) {
		return allPersons //
				.stream() //
				.collect(Collectors.averagingInt(p -> p.getAge()));
	}

	public int getPersonsMaxAge(List<Person> allPersons) {
		return allPersons //
				.stream() //
				.collect(Collectors.summarizingInt(p -> p.getAge())) //
				.getMax();
	}
}
