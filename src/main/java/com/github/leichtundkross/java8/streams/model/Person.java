package com.github.leichtundkross.java8.streams.model;

import java.util.Collections;
import java.util.List;

public class Person {

	private final String name;

	private final int age;

	private final List<Person> children;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		this.children = Collections.emptyList();
	}

	public Person(String name, int age, List<Person> children) {
		this.name = name;
		this.age = age;
		this.children = children;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public List<Person> getChildren() {
		return children;
	}
}
