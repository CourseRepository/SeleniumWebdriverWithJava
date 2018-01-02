package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import helper.AlertHelper;
import helper.ButtonHelper;
import helper.StartWebDriver;
import helper.WindowHelper;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class TestAlert extends StartWebDriver {
	
	@Test
	public void testCasealert() {
		WindowHelper.navigateToPage("http://www.w3schools.com/js/js_popup.asp");
		ButtonHelper.clickButton("//div[@id='main']/div[6]/a");
		WindowHelper.switchTo(1);
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		ButtonHelper.clickButton("//button[text()='Try it']");
		
		if(AlertHelper.isAlertPresent()){
			System.err.println("String : " + AlertHelper.getText());
			AlertHelper.clickCancel();
		}
		
		ButtonHelper.clickButton("//button[text()='Try it']");
		
		if(AlertHelper.isAlertPresent())
			AlertHelper.clickOk();	
		
		WindowHelper.switchToParentWithClose();
		ButtonHelper.clickButton("//div[@id='main']/div[4]/a");
		WindowHelper.switchTo(1);
		
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		ButtonHelper.clickButton("//button[text()='Try it']");
		if(AlertHelper.isAlertPresent()){
			System.err.println("String : " + AlertHelper.getText());
			AlertHelper.clickOk();
		}
		WindowHelper.switchToParentWithClose();
		WindowHelper.navigateToPage(file.getUrl());
	}

}
