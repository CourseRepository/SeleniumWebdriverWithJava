/**
 * 
 */
package testcase.testOne;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

import helper.ButtonHelper;
import helper.LinkHelper;
import helper.StartWebDriver;
import helper.WindowHelper;


public class TestLoading extends StartWebDriver{
	
	@Test(priority = 1)
	public static void XYZ(WebDriver driver, String data) {
		List<WebElement> dropdw = driver.findElements(By.tagName("select"));
		for (WebElement webElement : dropdw) {
			Select mySelect = new Select(webElement);
			List<WebElement> options = mySelect.getOptions();
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase(data)) {
					option.click();
				}
			}
		}
	}
			
		
	@Test(priority = 2)
	public void Loading() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30000); 
		wait.ignoring(NoSuchElementException.class);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		
		WindowHelper.navigateToPage("https://www.udemy.com/test-automation-with-selenium-webdriver/");
		ButtonHelper.clickButton("//a[contains(text(),'Login')]");
		// Waiting for loading mask to disappear

		wait.until(waitforLoadingMask(By.xpath("//div[@id='fancybox-loading']"))); 
		System.out.println("Wait is Over");
	}

	/**
	 * Should be used for Loading mask
	 * @param driver
	 * @param string
	 * @param By Locator of Loading mask
	 * @return	true/false
	 */
	private Function<WebDriver, Boolean> waitforLoadingMask(final By by){
		return new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver arg0) {
				System.err.println("waiting");
				return !(driver.findElements(by).size() >= 1);
			}
		};
		
	}
	
	/**
	 * Should be used for Element
	 * @param By Locator of the element 
	 * @return true/false
	 */
	private Function<WebDriver, Boolean> waitforElement(final By by){
		return new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver arg0) {
				System.err.println("waiting");
				return driver.findElements(by).size() >= 1;
			}
		};
		
	}
	
}
