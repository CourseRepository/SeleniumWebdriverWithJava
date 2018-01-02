/**
 * 
 */
package testcase.keywordtest;

import java.io.IOException;

import org.testng.annotations.Test;

import Keyword.KeywordStepDfn;
import helper.StartWebDriver;
import helper.WindowHelper;

/**
 * @author - rahul.rathore
 * @date - 20-Jun-2015
 * @project - Webdriver
 * @package - testcase.keywordtest
 * @file name - TestKeywordDriven.java
 */
public class TestKeywordDriven extends StartWebDriver {
	
	@Test
	public void testBugzilla() throws IOException {
		KeywordStepDfn.performActionWithKeyword("C:\\Users\\rahul.rathore\\Desktop\\Keyword\\Data.xlsx", "Bugzilla");
		
	}
	
	@Test
	public void testCoadingBat() throws IOException {
		WindowHelper.navigateToPage("http://codingbat.com/");
		KeywordStepDfn.performActionWithKeyword("C:\\Users\\rahul.rathore\\Desktop\\Keyword\\Data.xlsx", "Codingbat");
	}

}
