/**
 * 
 */
package com.larrywei.expression.format.reader;

import java.io.IOException;

import com.larrywei.expression.format.Element;
import com.larrywei.expression.format.ExpressionReader;
import com.larrywei.expression.format.FormatException;

/**
 * @author 林良益，卓诗垚
 * @version 2.0 
 * Oct 9, 2008
 */
public interface ElementReader {
	Element read(ExpressionReader sr) throws FormatException, IOException;
}
