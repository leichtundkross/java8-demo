package com.github.leichtundkross.java8.staticmethods;

import java.util.Collection;
import java.util.Collections;

public interface MyInterface {

	static MyInterface empty() {
		return new MyInterface() {

			@Override
			public Collection<String> someMethodToImplement() {
				return Collections.emptyList();
			}
		};
	}

	Collection<String> someMethodToImplement();
}
