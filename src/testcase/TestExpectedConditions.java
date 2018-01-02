package testcase;

import java.util.concurrent.TimeUnit;

import helper.AlertHelper;
import helper.ButtonHelper;
import helper.LinkHelper;
import helper.StartWebDriver;
import helper.WindowHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestExpectedConditions.java
 */
public class TestExpectedConditions extends StartWebDriver {
	
	@Test
	public void testConditions() {
		/*WindowHelper.navigateToPage("http://www.w3schools.com/js/tryit.asp?filename=tryjs_timing1");
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		ButtonHelper.clickButton("//button[text()='Try it']");
		wait.until(ExpectedConditions.alertIsPresent());
		System.err.println("Text : " + AlertHelper.getText());
		AlertHelper.clickOk();
		*/
		WindowHelper.navigateToPage(file.getUrl());
		LinkHelper.clickLink("File a Bug");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.until(new ExpectedCondition<WebElement>() {

			@Override
			public WebElement apply(WebDriver arg0) {
				return driver.findElement(By.id("Bugzilla_password"));
			}
		});
		System.out.println("Login Page Displayed");
		
		
	}

}
