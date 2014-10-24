package com.yongche.fomula;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;

import org.json.JSONObject;
import org.yongche.expression.ExpressionEvaluator;
import org.yongche.expression.datameta.Variable;
import org.yongche.expression.function.CommonFunctions;

import android.R.array;
import android.util.Log;

import com.yongche.formula.interfaces.ICalculate;

public class FormularCalculate implements ICalculate{
	private final int VER = 1;

	@Override
	public int getVersion() {
		return VER;
	}
	
	/**
	 * 计算所有公式,并返回所有变量的Json字符串
	 * @param expression	单价+公式字符串
	 * */
	@Override
	public String calculateFormulas(String expression) {
		try {
			String[] expressions = expression.split("\n");
			LinkedList<Variable> variableList = new LinkedList<Variable>();
			JSONObject jsonObject = new JSONObject();
			//循环计算所有变量
			for (int i = 0; i < expressions.length; i++) {
				Variable var = calculateSingleLineFormula(expressions[i].trim(), variableList);
				//变量表查找已有变量并替换
				if(var != null && !replaceExistedVarInList(var, variableList)) {
					//新增变量加入变量表
					variableList.add(var);
				}
			}
			//将所有变量以Json字符串形式返回
			for (int i = 0; i < variableList.size(); i++) {
				jsonObject.put(variableList.get(i).getVariableName(), variableList.get(i).getStringValue());
			}
			return jsonObject.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	
	/**
	 * 计算单行公式,参数:表达式,已有参数列表
	 * @param	expression	表达式语句
	 * @param	varList		变量表
	 * */
	private Variable calculateSingleLineFormula(String expression, LinkedList<Variable> varList) {
		if (!expression.contains("=")) {
			return null;
		}
		String var = expression.substring(0, expression.indexOf("="));
		expression = expression.substring(expression.indexOf("=") + 1);
		expression = preReplace(expression);
		Object result = ExpressionEvaluator.evaluate(expression, varList);
		return Variable.createVariable(var, result);
	}
	
	/**
	 * 将函数List中存在的函数名替换为$+函数名
	 * @param	data	表达式语句
	 * */
	private String preReplace(String data) {
		ArrayList<String> functionNameList = new ArrayList<String>();
		Method[] declaredMethods = CommonFunctions.class.getDeclaredMethods();
		for (int i = 0; declaredMethods != null && i < declaredMethods.length; i++) {
			functionNameList.add(declaredMethods[i].getName());
		}
		for (int i = 0; functionNameList != null && i < functionNameList.size(); i++) {
			data = data.replace(functionNameList.get(i), "$" + functionNameList.get(i));
		}
		return data;
	}
	
	/**
	 * 替换掉已有变量
	 * @param var	变量
	 * @param list	变量表
	 * @return true 表示有替换，false无替换
	 * */
	private boolean replaceExistedVarInList(Variable var, LinkedList<Variable> list) {
		for (int i = 0; i < list.size(); i++) {
			if (var.getVariableName().equals(list.get(i).getVariableName())) {
				list.remove(i);
				list.add(var);
				return true;
			}
		}
		
		return false;
	}
}
