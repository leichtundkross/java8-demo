package com.github.leichtundkross.java8.staticmethods;

import java.util.Collection;
import java.util.Collections;

@FunctionalInterface
public interface MyInterface {

	static MyInterface empty() {
		return () -> Collections.emptyList();
	}

	Collection<String> someMethodToImplement();
}
