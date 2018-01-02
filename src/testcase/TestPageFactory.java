package testcase;

import helper.ButtonHelper;
import helper.StartWebDriver;
import helper.WindowHelper;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestPageFactory.java
 */
public class TestPageFactory extends StartWebDriver {
	
	@Test(priority=1)
	public void testLogin() throws Exception {
		WindowHelper.navigateToPage(file.getUrl());
		file_a_Bug.click();
		/*username_text_box.sendKeys("rahul@bugzila.com");
		password_textbox.sendKeys("welcome");
		login_button.click();*/
		Bugzilla_login.sendKeys(file.getUsername());
		Bugzilla_password.sendKeys(file.getPassword());
		log_in.click();
		/*LinkHelper.clickLink("File");
		TextBoxHelper.typeInTextBox("Bugzilla_login", "rahul@bugzila.com");
		TextBoxHelper.typeInTextBox("Bugzilla_password", "welcome");
		ButtonHelper.clickButton("log_in");*/
		Assert.assertTrue(driver.getTitle().contains("Enter Bug"));
		//ButtonHelper.clickButton("//div[@id='header']/ul[1]/li[11]/a");
		logout_button.click();
		
	}
	
	@Test(priority=2)
	public void testPreferences() throws Exception {
		/*LinkHelper.clickLink("File");
		TextBoxHelper.typeInTextBox("Bugzilla_login", "rahul@bugzila.com");
		TextBoxHelper.typeInTextBox("Bugzilla_password", "welcome");
		ButtonHelper.clickButton("log_in");*/
		WindowHelper.navigateToPage(file.getUrl());
		file_a_Bug.click();
		/*username_text_box.sendKeys("rahul@bugzila.com");
		password_textbox.sendKeys("welcome");
		login_button.click();*/
		Bugzilla_login.sendKeys(file.getUsername());
		Bugzilla_password.sendKeys(file.getPassword());
		log_in.click();
		Assert.assertTrue(driver.getTitle().contains("Enter Bug"));
		ButtonHelper.clickButton("//div[@id='header']/ul[1]/li[8]/a");
		Assert.assertTrue(driver.getTitle().contains("Preferences"));
		//ButtonHelper.clickButton("//div[@id='header']/ul[1]/li[11]/a");
		logout_button.click();
		
	}
	
	@Test(priority=3)
	public void testAdministration() throws Exception {
		/*LinkHelper.clickLink("File");
		TextBoxHelper.typeInTextBox("Bugzilla_login", "rahul@bugzila.com");
		TextBoxHelper.typeInTextBox("Bugzilla_password", "welcome");
		ButtonHelper.clickButton("log_in");*/
		WindowHelper.navigateToPage(file.getUrl());
		file_a_Bug.click();
		/*username_text_box.sendKeys("rahul@bugzila.com");
		password_textbox.sendKeys("welcome");
		login_button.click();*/
		Bugzilla_login.sendKeys(file.getUsername());
		Bugzilla_password.sendKeys(file.getPassword());
		log_in.click();
		Assert.assertTrue(driver.getTitle().contains("Enter Bug"));
		ButtonHelper.clickButton("//div[@id='header']/ul[1]/li[9]/a");
		Assert.assertTrue(driver.getTitle().contains("Administer"));
		//ButtonHelper.clickButton("//div[@id='header']/ul[1]/li[11]/a");
		logout_button.click();
	}

}
