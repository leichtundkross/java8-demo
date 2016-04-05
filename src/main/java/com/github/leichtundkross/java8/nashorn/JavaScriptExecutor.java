package com.github.leichtundkross.java8.nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptExecutor {

	Object executeFunction(String script, String functionName) throws ScriptException, NoSuchMethodException {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(script);

		Invocable invocable = (Invocable) engine;
		Object result = invocable.invokeFunction(functionName);
		return result;
	}
}
