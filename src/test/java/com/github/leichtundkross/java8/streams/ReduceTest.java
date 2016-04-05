package com.github.leichtundkross.java8.streams;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.github.leichtundkross.java8.streams.model.Person;

public class ReduceTest {

	@Test
	public void getPersonsMaxAge() {
		Person kevin = new Person("Kevin", 18);
		Person bob = new Person("Bob", 22);
		Person stuart = new Person("Stuart", 20);
		List<Person> allPersons = Arrays.asList(kevin, bob, stuart);

		int maxAge = new Reduce().getPersonsMaxAge(allPersons);

		assertEquals(22, maxAge);
	}

	@Test
	public void getCharliesChildren() {
		Person sue = new Person("Sue", 25, Arrays.asList(new Person("Kevin", 5)));
		Person anne = new Person("Anne", 30, Arrays.asList(new Person("Stuart", 5), new Person("Bob", 8)));
		List<Person> mothers = Arrays.asList(sue, anne);

		List<Person> charliesChildren = new Reduce().getCharliesChildren(mothers);

		assertEquals(3, charliesChildren.size());
		assertEquals("Kevin", charliesChildren.get(0).getName());
		assertEquals("Stuart", charliesChildren.get(1).getName());
		assertEquals("Bob", charliesChildren.get(2).getName());
	}
}
