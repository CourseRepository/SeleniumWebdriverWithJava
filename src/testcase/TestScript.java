package testcase;

import helper.ButtonHelper;
import helper.GenericHelper;
import helper.LinkHelper;
import helper.StartWebDriver;
import helper.WindowHelper;

import org.testng.annotations.Test;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestScript.java
 */
public class TestScript extends StartWebDriver {
	
	@Test
	public void testCaseScript() {
		WindowHelper.navigateToPage(file.getUrl());
		LinkHelper.clickLink("File a Bug");
		
		GenericHelper.executeScript("document.getElementById('Bugzilla_login').value='rahul@bugzila.com'");
		GenericHelper.executeScript("document.getElementById('Bugzilla_password').value='rathore'");
		GenericHelper.executeScript("document.getElementById('Bugzilla_restrictlogin').click()");
		GenericHelper.executeScript("document.getElementById('log_in').click()");
		GenericHelper.executeScript("window.scrollTo(100,1000)");
		GenericHelper.takeMultipleScreeShot("Screen");
		ButtonHelper.clickLogout();
	}

}
