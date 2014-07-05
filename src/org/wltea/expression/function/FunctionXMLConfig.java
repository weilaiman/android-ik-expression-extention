package org.wltea.expression.function;

import java.io.InputStream;

import android.content.Context;
/**
 * 修改外部加载配置文件方法，将配置文件流在此输入，
 * 
 * @author Larry.Wei(weilaiman@gmail.com)
 * July 6, 2014
 */
public class FunctionXMLConfig {
	static InputStream is = null;
	/**
	 * @description 加载保存在Asserts文件夹中的IKExpression.cfg.xml文件
	 * @param	context		上下文
	 * @param	fileName	xml文件名
	 * */
	public static void setXmlInputStreamInAsserts(Context context, String fileName) {
		try {
			is = context.getResources().getAssets().open(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * InputStream 关闭
	 * */
	public static void closeInputStream() {
		try {
			is.close();
			is = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
