/**
 * 
 */
package testcase.testOne;

import java.util.Map;

import helper.DataProviderClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import customeannotation.XlsxFilePath;

/**
 * @author - rahul.rathore
 * @date - 27-Sep-2015
 * @project - Webdriver
 * @package - testcase.testOne
 * @file name - TestCustomeAnnotation.java
 */
public class TestCustomeAnnotation {
	
	@Test(dataProvider="getData",dataProviderClass=DataProviderClass.class)
	@XlsxFilePath(filePath = "Login.xlsx", sheetName = "LoginDetails")
	public void TestCaseLogin(Map<String, String> data){
		
	}
	
	@Test(dataProvider="getData",dataProviderClass=DataProviderClass.class)
	@XlsxFilePath(filePath = "Login_one.xlsx", sheetName = "LoginDetails")
	public void TestCaseLogin_one(Map<String, String> data){
		
	}

}
