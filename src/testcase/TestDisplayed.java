package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import helper.GenericHelper;
import helper.StartWebDriver;
import helper.WindowHelper;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestDisplayed.java
 */
public class TestDisplayed extends StartWebDriver {
	
	@Test
	public void testCheckElement() {
		WindowHelper.navigateToPage(file.getUrl());
		System.out.println("Displayed : " + driver.findElement(By.linkText("Home")).isDisplayed());
		
		System.out.println("isElement Presetn : " + GenericHelper.isElementPresent("quicksearch_top"));
		System.out.println("isElement Presetn : " + GenericHelper.isElementPresent("quicksearch_to_p"));
		
	}
}
