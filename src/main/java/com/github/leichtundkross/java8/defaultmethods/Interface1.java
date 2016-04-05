package com.github.leichtundkross.java8.defaultmethods;

public interface Interface1 {

	/**
	 * Default method needs keyword default
	 */
	default String sayHello() {
		return "Interface1: Hello";
	}
}
