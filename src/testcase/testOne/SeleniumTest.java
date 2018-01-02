/**
 * 
 */
package testcase.testOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author - rahul.rathore
 * @date - 05-Jul-2015
 * @project - Webdriver
 * @package - testcase.testOne
 * @file name - SeleniumTest.java
 */
public class SeleniumTest {
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void initWebdriver() {
		driver = new FirefoxDriver();
	}
	
	@AfterClass
	public static void tearDown() {
		if(driver != null){
			driver.close();
			driver.quit();
			driver = null;
		}
	}
	
	@Test
	public void seleniumTest() {
		driver.get("http://localhost:5001/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// ignore
		}
		System.out.println("Title : " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Bugzilla"));
	}

}
