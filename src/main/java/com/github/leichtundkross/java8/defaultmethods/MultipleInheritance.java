package com.github.leichtundkross.java8.defaultmethods;

public class MultipleInheritance implements Interface1, Interface2 {

	@Override
	public String sayHello() {
		// we need to override method sayHello to resolve method ambiguity
		// if we do not override this method, this class cannot be compiled
		return Interface1.super.sayHello();
	}
}
