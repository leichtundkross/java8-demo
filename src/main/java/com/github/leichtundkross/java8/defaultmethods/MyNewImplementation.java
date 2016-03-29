package com.github.leichtundkross.java8.defaultmethods;

public class MyNewImplementation implements MyOldInterface {

	@Override
	public void doSomething() {
		System.out.println("works since version 1.0");
	}

	@Override
	public void doSomethingMore() {
		System.out.println("works since version 2.0");
	}
}
