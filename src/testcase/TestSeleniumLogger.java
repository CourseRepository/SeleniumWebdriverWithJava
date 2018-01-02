/**
 * 
 */
package testcase;

import helper.ButtonHelper;
import helper.LinkHelper;
import helper.LoggerHelper;
import helper.StartWebDriver;
import helper.TextBoxHelper;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * @author - rahul.rathore
 * @date - 10-Feb-2015
 * @project - Webdriver
 * @package - testcase
 * @file name - TestSeleniumLogger.java
 */
public class TestSeleniumLogger extends StartWebDriver {
	private static final Logger logger = LoggerHelper.getLogger(TestSeleniumLogger.class);
	
	@Test
	public void openWebpage() {
		LinkHelper.clickLink("File a Bug");
		logger.info("Clicked on Link [File a Bug]");
		TextBoxHelper.typeInTextBox("Bugzilla_login", file.getUsername());
		logger.info("Type the UserName ");
		TextBoxHelper.typeInTextBox("Bugzilla_password", file.getPassword());
		logger.info("Type the Password ");
		try {
			ButtonHelper.clickButton("as");
		} catch (Exception e) {
			logger.error("Not able to Click on the Button : ", e);
		}
	}

}
