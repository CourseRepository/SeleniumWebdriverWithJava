package testcase;

import helper.ButtonHelper;
import helper.StartWebDriver;
import helper.WindowHelper;

import org.testng.annotations.Test;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestMultiWindow.java
 */
public class TestMultiWindow extends StartWebDriver {
	
	@Test
	public void testWin() {
		WindowHelper.navigateToPage("http://www.w3schools.com/js/js_popup.asp");
		ButtonHelper.clickButton("//div[@id='main']/div[6]/a");
		if(WindowHelper.isBrowserPopupPresent())
			WindowHelper.switchTo(1);
		driver.get("http://www.w3schools.com/js/js_popup.asp");
		ButtonHelper.clickButton("//div[@id='main']/div[6]/a");
		if(WindowHelper.isBrowserPopupPresent())
			WindowHelper.switchTo(2);
		driver.get("http://www.w3schools.com/js/js_popup.asp");
		ButtonHelper.clickButton("//div[@id='main']/div[6]/a");
		if(WindowHelper.isBrowserPopupPresent())
			WindowHelper.switchTo(3);
		/*TextBoxHelper.clear("//textarea[@id='textareaCode']");
		TextBoxHelper.typeInTextBox("//textarea[@id='textareaCode']", "Webdriver");*/
		WindowHelper.switchToParentWithClose();
		if(WindowHelper.isBrowserPopupPresent())
			System.out.println("Multiple Window");
		WindowHelper.navigateToPage(file.getUrl());
	}

}
