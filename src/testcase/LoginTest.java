package testcase;

import helper.ButtonHelper;
import helper.GenericHelper;
import helper.StartWebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class LoginTest extends StartWebDriver {
	
	@Test(priority=1)
	public void testLogin() {
		/*LinkHelper.clickLink("File");
		TextBoxHelper.typeInTextBox("Bugzilla_login", "rahul@bugzila.com");
		TextBoxHelper.typeInTextBox("Bugzilla_password", "rathore");
		ButtonHelper.clickButton("log_in");*/
		
		file_a_Bug.click();
		Bugzilla_login.sendKeys(file.getUsername());
		Bugzilla_password.sendKeys(file.getPassword());
		log_in.click();
		
		Assert.assertTrue(driver.getTitle().contains("Enter"));
		//ButtonHelper.clickButton("//div[@id='header']/ul[1]/li[11]/a");
		logout_button.click();
		GenericHelper.waitForElement("//h1[@id='welcome']");
	}
	
	@Test(priority=2)
	public void testPreferences() {
		/*LinkHelper.clickLink("File");
		TextBoxHelper.typeInTextBox("Bugzilla_login", "rahul@bugzila.com");
		TextBoxHelper.typeInTextBox("Bugzilla_password", "rathore");
		ButtonHelper.clickButton("log_in");*/

		file_a_Bug.click();
		Bugzilla_login.sendKeys(file.getUsername());
		Bugzilla_password.sendKeys(file.getPassword());
		log_in.click();
		
		Assert.assertTrue(driver.getTitle().contains("Enter"));
		ButtonHelper.clickButton("//div[@id='header']/ul[1]/li[8]/a");
		Assert.assertTrue(driver.getTitle().contains("Preferences"));
		//ButtonHelper.clickButton("//div[@id='header']/ul[1]/li[11]/a");
		logout_button.click();
		GenericHelper.waitForElement("//h1[@id='welcome']");
	}
	
	@Test(priority=3)
	public void testAdministration() {
		/*LinkHelper.clickLink("File");
		TextBoxHelper.typeInTextBox("Bugzilla_login", "rahul@bugzila.com");
		TextBoxHelper.typeInTextBox("Bugzilla_password", "rathore");
		ButtonHelper.clickButton("log_in");*/
		

		file_a_Bug.click();
		Bugzilla_login.sendKeys(file.getUsername());
		Bugzilla_password.sendKeys(file.getPassword());
		log_in.click();
		
		Assert.assertTrue(driver.getTitle().contains("Enter"));
		ButtonHelper.clickButton("//div[@id='header']/ul[1]/li[9]/a");
		Assert.assertTrue(driver.getTitle().contains("Administer"));
		//ButtonHelper.clickButton("//div[@id='header']/ul[1]/li[11]/a");
		
		logout_button.click();
		GenericHelper.waitForElement("//h1[@id='welcome']");
	}
	
	@Test(priority=4)
	public void testReport() {
		
		file_a_Bug.click();
		Bugzilla_login.sendKeys(file.getUsername());
		Bugzilla_password.sendKeys(file.getPassword());
		log_in.click();
		
		/*LinkHelper.clickLink("File");
		TextBoxHelper.typeInTextBox("Bugzilla_login", "rahul@bugzila.com");
		TextBoxHelper.typeInTextBox("Bugzilla_password", "rathore");
		ButtonHelper.clickButton("log_in");*/
		Assert.assertTrue(driver.getTitle().contains("Enter"));
		ButtonHelper.clickButton("//div[@id='header']/ul[1]/li[6]/a");
		Assert.assertTrue(driver.getTitle().contains("Reporting"));
		//ButtonHelper.clickButton("//div[@id='header']/ul[1]/li[11]/a");
		logout_button.click();
		GenericHelper.waitForElement("//h1[@id='welcome']");
	}

}
