package com.github.leichtundkross.java8.typeannotations;

import org.junit.Test;

public class AnnotateNonNullTest {

	@Test
	public void acceptAnyButNotNull() {
		new AnnotateNonNull().acceptAnyButNotNull("hello");
	}

	@Test(expected = NullPointerException.class)
	public void acceptAnyButNotNull_NPE() {
		// this issue should be found using findbugs
		new AnnotateNonNull().acceptAnyButNotNull(null);
	}
}
