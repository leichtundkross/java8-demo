package com.github.leichtundkross.java8.lambda;

import java.util.Comparator;

public class EasyComparison {

	public int compareStrings(String val1, String val2) {
		// pre-java8 way: anonymous comparator
		Comparator<String> c = new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				return val1.compareTo(val2);
			}
		};

		return c.compare(val1, val2);
	}

	public int compareStringsWithJava8(String val1, String val2) {
		// parenthesized set of parameters --> 'method' body
		Comparator<String> c = (String s1, String s2) -> {
			return s1.compareTo(s2);
		};

		return c.compare(val1, val2);
	}

	public int compareStringsWithJava8Shorter(String val1, String val2) {
		// parenthesizes for body are optional
		// last computed value is used as return value
		Comparator<String> c = (String s1, String s2) -> s1.compareTo(s2);
		return c.compare(val1, val2);
	}

	public int compareStringsWithJava8EvenShorter(String val1, String val2) {
		// type inference: parameter types are determined by compiler
		Comparator<String> c = (s1, s2) -> s1.compareTo(s2);
		return c.compare(val1, val2);
	}
}
