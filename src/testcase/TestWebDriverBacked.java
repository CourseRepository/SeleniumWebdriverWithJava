package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.WrapsDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestWebDriverBacked.java
 */
public class TestWebDriverBacked {
	
	@Test
	public void testBackedSelenium() throws Exception {
		/*SeleniumServer server = new SeleniumServer();
		server.boot();
		server.start();*/
		
		/*Selenium browser = new DefaultSelenium("127.0.0.1", 4444, "*firefox", "http://localhost:5001/");
		browser.start();*/
		/*WebDriver driver = new FirefoxDriver();
		
		Selenium browser = new WebDriverBackedSelenium(driver, "http://10.150.113.50:5001/");
		driver = ((WrapsDriver)browser).getWrappedDriver();
		
		
		browser.open("/");
		browser.waitForPageToLoad("30000");
		//browser.windowMaximize();
		driver.manage().window().maximize();
		
		browser.click("//span[text()='File a Bug']");
		browser.waitForPageToLoad("30000");
		browser.click("//input[@id='Bugzilla_restrictlogin']");
		browser.click("//input[@id='log_in']");
		browser.waitForPageToLoad("30000");
		
		Assert.assertTrue(browser.isTextPresent("The username or password you entered is not valid"));
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(3000);
		browser.close();
		browser.stop();*/
		//server.stop();
		
		
		
		
	}

}
