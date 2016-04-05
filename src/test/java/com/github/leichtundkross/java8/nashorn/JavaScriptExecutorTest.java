package com.github.leichtundkross.java8.nashorn;

import static org.junit.Assert.assertEquals;

import javax.script.ScriptException;

import org.junit.Test;

public class JavaScriptExecutorTest {

	public static String helloj() {
		return "greetings from java";
	}

	@Test
	public void executeFunction() throws ScriptException, NoSuchMethodException {
		String script = //
				"var hellojs = function() {" //
						+ "return 'greetings from javascript';" //
					+ "}";

		Object result = new JavaScriptExecutor().executeFunction(script, "hellojs");

		assertEquals("greetings from javascript", result);
	}

	@Test
	public void executeFunctionWithJavaCode() throws ScriptException, NoSuchMethodException {
		String script = //
				"var helloj = function() {" + //
						"var JavaClass = Java.type('com.github.leichtundkross.java8.nashorn.JavaScriptExecutorTest');" //
						+ "return JavaClass.helloj();" //
					+ "}";

		Object result = new JavaScriptExecutor().executeFunction(script, "helloj");

		assertEquals("greetings from java", result);
	}
}
