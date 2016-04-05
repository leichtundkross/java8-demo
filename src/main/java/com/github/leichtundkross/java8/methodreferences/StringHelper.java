package com.github.leichtundkross.java8.methodreferences;

import java.util.function.Function;
import java.util.function.Supplier;

public class StringHelper {

	public int getLength(Function<StringBuilder, String> function, StringBuilder s) {
		return function.apply(s).length();
	}

	public int getLength(Supplier<String> supplier) {
		return supplier.get().length();
	}
}
