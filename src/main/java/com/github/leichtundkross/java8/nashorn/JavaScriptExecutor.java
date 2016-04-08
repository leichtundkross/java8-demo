package com.github.leichtundkross.java8.nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptExecutor {

	private static final String JAVASCRIPT_ENGINE = "nashorn";

	Object executeFunction(String script, String functionName) throws ScriptException, NoSuchMethodException {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName(JAVASCRIPT_ENGINE);
		engine.eval(script);

		Invocable invocable = (Invocable) engine;
		Object result = invocable.invokeFunction(functionName);
		return result;
	}

	Object executeFunction(String language, String script, String functionName) throws ScriptException, NoSuchMethodException {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName(language);
		engine.eval(script);

		Invocable invocable = (Invocable) engine;
		Object result = invocable.invokeFunction(functionName);
		return result;
	}
}
