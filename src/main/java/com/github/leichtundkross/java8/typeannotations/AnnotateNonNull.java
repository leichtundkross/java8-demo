package com.github.leichtundkross.java8.typeannotations;

import javax.annotation.Nonnull;

public class AnnotateNonNull {

	public void acceptAnyButNotNull(@Nonnull String var) {
		System.out.println(var.length());
	}
}
