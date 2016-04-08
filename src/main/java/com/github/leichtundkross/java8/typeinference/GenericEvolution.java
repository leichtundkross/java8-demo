package com.github.leichtundkross.java8.typeinference;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class GenericEvolution {

	/**
	 * We didn't have any generics at all :-/
	 */
	public void java4Style() {
		Set minions = new TreeSet();
		minions.add("Bob");
		minions.add("Kevin");
		minions.add("Stuart");
		minions.addAll(Arrays.asList(new String[] { "Fred" }));
		minions.addAll(Arrays.asList(new String[] {}));
	}

	public void java5Style() {
		Set<String> minions = new TreeSet<String>();
		minions.add("Bob");
		minions.add("Kevin");
		minions.add("Stuart");
		minions.addAll(Arrays.asList("Fred"));
		minions.addAll(Arrays.<String> asList());
	}

	public void java7Style() {
		Set<String> minions = new TreeSet<>();
		minions.add("Bob");
		minions.add("Kevin");
		minions.add("Stuart");
		minions.addAll(Arrays.asList("Fred"));
		minions.addAll(Arrays.<String> asList());
	}

	public void java8Style() {
		Set<String> minions = new TreeSet<>();
		minions.add("Bob");
		minions.add("Kevin");
		minions.add("Stuart");
		minions.addAll(Arrays.asList("Fred"));
		minions.addAll(Arrays.asList());
	}
}
