package com.github.leichtundkross.java8.defaultmethods;

public class MultipleInheritance implements Interface1, Interface2 {

	/**
	 * We need to override {@link #sayHello()} since method is inherited twice (from {@link Interface1} and {@link Interface2}). This
	 * concrete implementation solves multiple inheritance.
	 */
	@Override
	public String sayHello() {
		return "MultipleInheritance: Hello";
	}

	@Override
	public String toString() {
		// if we want wo call inherited method sayHello(), we need to add prefix Interface1. or Interface2. when calling super:
		return Interface1.super.sayHello();
	}
}
