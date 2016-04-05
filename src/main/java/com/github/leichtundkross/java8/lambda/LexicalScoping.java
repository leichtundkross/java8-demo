package com.github.leichtundkross.java8.lambda;

import java.util.concurrent.atomic.AtomicReference;

import com.github.leichtundkross.java8.lambda.model.Greeter;

public class LexicalScoping {

	AtomicReference<String> stringValue = new AtomicReference<>();

	String sayHello() {
		Greeter g = new Greeter() {

			@Override
			public void sayHello() {
				stringValue.set(toString());
			}
		};

		g.sayHello();
		return stringValue.get();
	}

	String sayHelloLambda() {
		Greeter g = () -> stringValue.set(toString());

		g.sayHello();
		return stringValue.get();
	}

	public String toString() {
		return "LexicalScoping's toString()";
	}
}
