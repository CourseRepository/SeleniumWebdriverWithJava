package testcase;

import helper.ButtonHelper;
import helper.CheckBoxHelper;
import helper.LinkHelper;
import helper.StartWebDriver;
import helper.TextBoxHelper;
import helper.WindowHelper;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestRadioButton.java
 */
public class TestRadioButton extends StartWebDriver {
	
	@Test
	public void testRadioButton() {
		WindowHelper.navigateToPage(file.getUrl());
		LinkHelper.clickLink("File a Bug");
		TextBoxHelper.typeInTextBox("Bugzilla_login", file.getUsername());
		TextBoxHelper.typeInTextBox("Bugzilla_password", file.getPassword());
		CheckBoxHelper.clickCheckBox("Bugzilla_restrictlogin");
		ButtonHelper.clickButton("log_in");
		Assert.assertTrue(driver.getTitle().contains("Enter"));
		//LinkHelper.clickLink("Administration");
		ButtonHelper.clickButton("div#header ul.links li:nth-of-type(9)>a");
		//driver.findElement(By.cssSelector("div#header ul.links li:nth-of-type(9)>a")).click();
		LinkHelper.clickLink("Parameters");
		Assert.assertTrue(driver.getTitle().contains("Configuration"));
		CheckBoxHelper.clickCheckBox("ssl_redirect-on");
		System.out.println("Selected : " + CheckBoxHelper.isChecked("ssl_redirect-off"));
		ButtonHelper.clickLogout();
		
	}

}
