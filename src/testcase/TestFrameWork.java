package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import helper.StartWebDriver;
import helper.WindowHelper;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestFrameWork.java
 */
public class TestFrameWork extends StartWebDriver {
	
	@Test
	public void testCaseFrame() {
		WindowHelper.navigateToPage(file.getUrl());
		System.out.println("Title : " + driver.getTitle());
		System.out.println("Url : " + driver.getCurrentUrl());
		Assert.assertEquals(driver.getTitle(), "Welcome to Bugzilla");
	}
	
}
