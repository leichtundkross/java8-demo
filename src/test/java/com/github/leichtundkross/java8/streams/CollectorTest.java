package com.github.leichtundkross.java8.streams;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.github.leichtundkross.java8.streams.model.Person;

public class CollectorTest {

	@Test
	public void getPersonsOlderThan18() {
		Person kevin = new Person("Kevin", 20);
		Person stuart = new Person("Stuart", 40);
		List<Person> allPersons = Arrays.asList(kevin, new Person("Bob", 10), stuart);

		List<Person> personsOlderThan18 = new Collector().getPersonsOlderThan18(allPersons);

		assertEquals(2, personsOlderThan18.size());
		assertEquals(kevin, personsOlderThan18.get(0));
		assertEquals(stuart, personsOlderThan18.get(1));
	}

	@Test
	public void toMapByName() {
		Person kevin = new Person("Kevin", 20);
		Person bob = new Person("Bob", 10);
		Person stuart = new Person("Stuart", 20);
		List<Person> allPersons = Arrays.asList(kevin, bob, stuart);

		Map<String, Person> personsByName = new Collector().toMapByName(allPersons);

		assertEquals(3, personsByName.size());
		assertEquals(kevin, personsByName.get("Kevin"));
		assertEquals(bob, personsByName.get("Bob"));
		assertEquals(stuart, personsByName.get("Stuart"));
	}

	@Test
	public void groupPersonsByAge() {
		Person kevin = new Person("Kevin", 20);
		Person bob = new Person("Bob", 10);
		Person stuart = new Person("Stuart", 20);
		List<Person> allPersons = Arrays.asList(kevin, bob, stuart);

		Map<Integer, List<Person>> personsByAge = new Collector().groupPersonsByAge(allPersons);

		assertEquals(2, personsByAge.size());
		assertEquals(Arrays.asList(kevin, stuart), personsByAge.get(20));
		assertEquals(Arrays.asList(bob), personsByAge.get(10));
	}

	@Test
	public void getPersonsAverageAge() {
		Person kevin = new Person("Kevin", 18);
		Person bob = new Person("Bob", 22);
		Person stuart = new Person("Stuart", 20);
		List<Person> allPersons = Arrays.asList(kevin, bob, stuart);

		double averageAge = new Collector().getPersonsAverageAge(allPersons);

		assertEquals(20d, averageAge, 0d);
	}

	@Test
	public void getPersonsMaxAge() {
		Person kevin = new Person("Kevin", 18);
		Person bob = new Person("Bob", 22);
		Person stuart = new Person("Stuart", 20);
		List<Person> allPersons = Arrays.asList(kevin, bob, stuart);

		int maxAge = new Collector().getPersonsMaxAge(allPersons);

		assertEquals(22, maxAge);
	}
}
