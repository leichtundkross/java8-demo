package com.github.leichtundkross.java8.typeinference;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class GenericyEvolution {

	public void java5Style() {
		Set<String> minions = new TreeSet<String>();
		minions.add("Bob");
		minions.add("Kevin");
		minions.add("Stuart");
		minions.addAll(Arrays.<String> asList());
	}

	public void java7Style() {
		Set<String> minions = new TreeSet<>();
		minions.add("Bob");
		minions.add("Kevin");
		minions.add("Stuart");
		minions.addAll(Arrays.<String> asList());
	}

	public void java8Style() {
		Set<String> minions = new TreeSet<>();
		minions.add("Bob");
		minions.add("Kevin");
		minions.add("Stuart");
		minions.addAll(Arrays.asList());
	}
}
