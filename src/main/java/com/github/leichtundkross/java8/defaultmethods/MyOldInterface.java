package com.github.leichtundkross.java8.defaultmethods;

public interface MyOldInterface {

	/**
	 * @since 1.0
	 */
	void doSomething();

	/**
	 * @since 2.0
	 */
	default void doSomethingMore() {
		System.out.println("add a cool new feature without breaking existing implementations");
	}
}
