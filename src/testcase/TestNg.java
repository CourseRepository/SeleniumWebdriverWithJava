package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestNg.java
 */
public class TestNg {
	
	private static WebDriver driver = null;
	
	@BeforeClass
	public static void startWebdriver() {
		ProfilesIni prof = new ProfilesIni();
		FirefoxProfile profile = prof.getProfile("default");
		profile.setPreference("browser.startup.homepage", "mail.google.com");
		profile.setPreference("browser.download.defaultFolder", "C:\\");
		profile.setPreference("browser.download.panel.shown", true);
		profile.setPreference("javascript.enabled", true);
		
		//driver = new FirefoxDriver(profile);
		driver = new HtmlUnitDriver();
		
	//	ChromeOptions opt = new ChromeOptions();
		//driver = new ChromeDriver(opt);
		/*System.setProperty("webdriver.chrome.driver", "C:\\Junit\\selenium-2.41.0\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();*/
		
	}
	
	@Test
	public void testCase() {
		driver.get("http://www.google.com");
		System.out.println("Title : " + driver.getTitle());
		System.out.println("Url : " + driver.getCurrentUrl());
		Assert.assertEquals(driver.getTitle(), "Google1");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {	}
		driver.get("https://in.yahoo.com/");
		System.out.println("Title : " + driver.getTitle());
		System.out.println("Url : " + driver.getCurrentUrl());
		Assert.assertEquals(driver.getTitle(), "Yahoo India");
		
		
	}
	

	@AfterClass(alwaysRun=true)
	public static void stopWebdriver() {
		 // this will close all the browser and stop the wbedriver gracefully
		if(driver != null){
			driver.close(); //this will close the browser which is currently in focus
			driver.quit();
			driver = null;
		}
			
		
	}



}
