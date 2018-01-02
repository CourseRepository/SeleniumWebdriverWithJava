/**
 * 
 */
package customeannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author - rahul.rathore
 * @date - 27-Sep-2015
 * @project - Webdriver
 * @package - customeannotation
 * @file name - XlsxFilePath.java
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface XlsxFilePath {
	public String filePath();
	public String sheetName();
}
