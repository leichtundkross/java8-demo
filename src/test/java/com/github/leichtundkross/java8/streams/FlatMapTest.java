package com.github.leichtundkross.java8.streams;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.github.leichtundkross.java8.streams.model.Person;

public class FlatMapTest {

	@Test
	public void toMapByName() {
		Person kevin = new Person("Kevin", 25, Arrays.asList(new Person("Peter", 5)));
		Person bob = new Person("Bob", 10);
		Person stuart = new Person("Stuart", 30, Arrays.asList(new Person("Thomas", 5), new Person("Sue", 8)));
		List<Person> parents = Arrays.asList(kevin, bob, stuart);

		List<Person> children = new FlatMap().getAllChildren(parents);

		assertEquals(3, children.size());
		assertEquals("Peter", children.get(0).getName());
		assertEquals("Thomas", children.get(1).getName());
		assertEquals("Sue", children.get(2).getName());
	}
}
