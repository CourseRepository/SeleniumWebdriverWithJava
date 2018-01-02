package testcase;

import helper.StartWebDriver;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestTimeUnit.java
 */
public class TestTimeUnit extends StartWebDriver{
	
	
	@Test
	public void testTime() {
		//LinkHelper.clickLink("File a Bug");
		//driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MILLISECONDS);
		driver.get("http://www.seventhsonmovie.com/");
		
		//1. for every 250 mili sceonds webdriver will check whether the element is present or not
		//2. Maximun it will wait for 20 sec before throwing no such element exception
		//ButtonHelper.clickButton("log_in");
		//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
	}

}
