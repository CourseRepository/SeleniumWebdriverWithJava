package testcase;

import helper.StartWebDriver;
import helper.WindowHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestKeyBoard.java
 */
public class TestKeyBoard extends StartWebDriver {
	
	@Test
	public void testKey() {
		WindowHelper.navigateToPage(file.getUrl());
		Actions act = new Actions(driver);
		act.keyDown(driver.findElement(By.id("quicksearch_top")),Keys.SHIFT)
		.sendKeys(driver.findElement(By.id("quicksearch_top")),"f")
		.sendKeys(driver.findElement(By.id("quicksearch_top")),"x")
		.keyUp(driver.findElement(By.id("quicksearch_top")),Keys.SHIFT)
		.build()
		.perform();
		
	}

}
