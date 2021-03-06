package com.visog.pasupukumkuma.utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class AppUtils {
	
	public static String replaceLast(String str, String oldValue, String newValue) {
		int pos = str.lastIndexOf(oldValue);
	    if (pos > -1) {
	        return str.substring(0, pos)
	             + newValue
	             + str.substring(pos + oldValue.length(), str.length());
	    } else {
	        return str;
	    }
	}
	
	public static void main(String[] args) throws ScriptException {
		
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    String expressionStr = "2+2";
	    System.out.println(engine.eval(expressionStr));
		
	}
}
