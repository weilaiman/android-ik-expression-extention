package com.larrywei.expression.function;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class CommonFunctions {
//	public static ArrayList<String> getCommonFunctionList() {
//		ArrayList<String> list = new ArrayList<String>();
//		Method[] methods = CommonFunctions.class.getDeclaredMethods();
//		for (int i = 0; methods != null && i < methods.length; i++) {
//			String name = methods[i].getName();
//			if (!name.equals("getCommonFunctionList")) {
//				list.add(name);
//			}
//		}
//		return list;
//	}
	
	public double round(double data) {
		return Math.round(data);
	}
	
	public double ceil(double data) {
		return Math.ceil(data);
	}
	
	public double floor(double data) {
		return Math.floor(data);
	}
	
	public double max(double d1, double d2) {
		return Math.max(d1, d2);
	}
	
	public double min(double d1, double d2) {
		return Math.min(d1, d2);
	}
}
