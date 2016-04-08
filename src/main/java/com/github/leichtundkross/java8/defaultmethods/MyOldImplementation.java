package com.github.leichtundkross.java8.defaultmethods;

public class MyOldImplementation implements MyOldInterface {

	@Override
	public void doSomething() {
		// eixsting code since v1.0
		System.out.println("works since version 1.0");

		// we can now call new methods from interface
		doSomethingMore();
	}
}
