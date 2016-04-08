package com.github.leichtundkross.java8.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.github.leichtundkross.java8.streams.model.Person;

public class Collector {

	public List<Person> getPersonsOlderThan18(List<Person> allPersons) {
		return allPersons //
				.stream() //
				.filter(person -> person.getAge() >= 18) //
				.collect(Collectors.toList());
	}

	public Map<Integer, List<Person>> groupPersonsByAge(List<Person> allPersons) {
		return allPersons //
				.stream() //
				.collect(Collectors.groupingBy(person -> person.getAge()));
	}

	public Map<String, Person> toMapByName(List<Person> allPersons) {
		return allPersons //
				.stream() //
				.collect(Collectors.toMap( //
						person -> person.getName(), // key
						person -> person) // value
		);
	}

	public double getPersonsAverageAge(List<Person> allPersons) {
		return allPersons //
				.stream() //
				.collect(Collectors.averagingInt(person -> person.getAge()));
	}

	public int getPersonsMaxAge(List<Person> allPersons) {
		return allPersons //
				.stream() //
				.collect(Collectors.summarizingInt(person -> person.getAge())) //
				.getMax();
	}

	/**
	 * This is another approach to solve problem from method {@link #getPersonsMaxAge}: We collect the oldest person using a comparator and
	 * return the person's age. This approach might be useful if we need the reference to the oldest person (and not only the age).
	 */
	public int getPersonsMaxAge_ComparingPersons(List<Person> allPersons) {
		return allPersons //
				.stream() //
				.collect(Collectors.maxBy((person1, person2) -> person1.getAge() > person2.getAge() ? person1.getAge() : person2.getAge())) //
				.get().getAge();
	}
}
