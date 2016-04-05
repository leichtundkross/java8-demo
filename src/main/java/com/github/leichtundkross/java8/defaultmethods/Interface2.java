package com.github.leichtundkross.java8.defaultmethods;

public interface Interface2 {

	/**
	 * Default method needs keyword default
	 */
	default String sayHello() {
		return "Interface2: Hello";
	}
}
