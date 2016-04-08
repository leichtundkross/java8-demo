package com.github.leichtundkross.java8.typeannotations;

import org.junit.Test;

public class AnnotateNonNullTest {

	@Test
	public void acceptAnyButNotNull() {
		new AnnotateNonNull().acceptAnyButNotNull("hello");
	}

	@Test(expected = NullPointerException.class)
	public void acceptAnyButNotNull_NPE() {
		passNullInMethodCall();
	}

	private void passNullInMethodCall() {
		// this issue should be found using findbugs:
		// Null passed for non-null parameter of AnnotateNonNull.acceptAnyButNotNull(String)
		String s = null;
		new AnnotateNonNull().acceptAnyButNotNull(s);
	}
}
