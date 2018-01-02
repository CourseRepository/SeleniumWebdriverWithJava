package testcase;

import helper.ButtonHelper;
import helper.CheckBoxHelper;
import helper.LinkHelper;
import helper.StartWebDriver;
import helper.WindowHelper;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestWebElement.java
 */
public class TestWebElement extends StartWebDriver {
	
	@Test
	public void testFindElemet() {
		WindowHelper.navigateToPage(file.getUrl());
		try {
				LinkHelper.clickLink("File a Bug");
				/*System.out.println("Selected : " + driver.findElement(By.id("Bugzilla_restrictlogin")).isSelected());
				driver.findElement(By.id("Bugzilla_restrictlogin")).click();
				System.out.println("Selected : " + driver.findElement(By.id("Bugzilla_restrictlogin")).isSelected());*/
				
				System.out.println("Selected : " + CheckBoxHelper.isChecked("Bugzilla_restrictlogin"));
				CheckBoxHelper.clickCheckBox("Bugzilla_restrictlogin");
				System.out.println("Selected : " + CheckBoxHelper.isChecked("Bugzilla_restrictlogin"));
				
				//driver.findElement(By.id("log_in")).click();
				ButtonHelper.clickButton("log_in");
				//ButtonHelper.clickLogout();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		
	}

}
