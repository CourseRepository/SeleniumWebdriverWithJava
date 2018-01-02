package testcase;

import helper.ButtonHelper;
import helper.StartWebDriver;
import helper.WindowHelper;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestMouseAction.java
 */
public class TestMouseAction extends StartWebDriver {
	
	/*
	 * Step 1 : compose your action
	 * Step 2 : call the build()
	 * Step 3 : call the perform()
	 * 
	 * */
	
	@Test
	public void testAction() {
	//	Actions act = new Actions(driver);
		/*act.clickAndHold(driver.findElement(By.xpath("//div[@id='draggable']")))
			.moveToElement(driver.findElement(By.xpath("//div[@id='example']/div[1]")))
			.release()
			.build()
			.perform();*/
		
		/*act.contextClick(driver.findElement(By.xpath("//div[@id='draggable']")))
		.build()
		.perform();*/
		
		/*act.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")), driver.findElement(By.xpath("//div[@id='example']/div[1]")))
		.build()
		.perform();
		
		
		act.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")), driver.findElement(By.xpath("//div[@id='droptarget']")))
		.build()
		.perform();*/
		
		//LinkHelper.clickLink("File");
		WindowHelper.navigateToPage(file.getUrl());
		ButtonHelper.clickLogout();
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("document.getElementById('log_in').click()");
	
	}

}
