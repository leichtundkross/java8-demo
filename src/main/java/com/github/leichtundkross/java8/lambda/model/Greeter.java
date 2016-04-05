package com.github.leichtundkross.java8.lambda.model;

/**
 * Annotation {@link @FunctionalInterface} is just a documentation hint, the compiler does not require this. It determines functional
 * interfaces from the structure of the interface: such types must have exactly one method.
 */
@FunctionalInterface
public interface Greeter {

	void sayHello();
}
