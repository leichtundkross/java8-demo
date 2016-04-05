package com.github.leichtundkross.java8.lambda;

import com.github.leichtundkross.java8.lambda.model.Greeter;

public class GettingStartedWIthLambdas {

	public String callInnerClass() {
		StringBuilder returnValue = new StringBuilder();
		// anonymous inner class
		Greeter g = new Greeter() {

			public void sayHello() {
				returnValue.append("Hello Java7!");
			}
		};
		g.sayHello();

		return returnValue.toString();
	}

	public String callLambda() {
		StringBuilder returnValue = new StringBuilder();
		// 1: needs a @FunctionalInterface
		// 2: ([parameters]*) -> method body
		Greeter g = () -> returnValue.append("Hello Java8!");
		g.sayHello();

		return returnValue.toString();
	}
}
