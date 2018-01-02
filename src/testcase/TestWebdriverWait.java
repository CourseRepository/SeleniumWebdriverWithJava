package testcase;

import helper.FluentWaitHelper;
import helper.StartWebDriver;
import helper.WindowHelper;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestWebdriverWait.java
 */
public class TestWebdriverWait extends StartWebDriver {
	
	@Test
	public void testWait() {
		WindowHelper.navigateToPage("http://www.w3schools.com/js/tryit.asp?filename=tryjs_timing_clock");
		driver.switchTo().frame((driver.findElement(By.id("iframeResult"))));
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		
		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver arg0) {
				if(arg0.findElement(By.id("txt")).getText().contains("40")){
					System.out.println("Counter : " + arg0.findElement(By.id("txt")).getText());
					return true;
				}
				else {
					System.out.println("Number  : " + arg0.findElement(By.id("txt")).getText());
					return false;
				}
			}
		};
		
		wait.until(function);
		System.out.println("40 Number Found");
		
		
		
	}
	
	@Test
	public void TestluentWaitHelper() {
		List<Class> exception = new LinkedList<Class>();
		exception.add(NoSuchElementException.class);
		exception.add(ElementNotVisibleException.class);
		
		FluentWaitHelper helper = new FluentWaitHelper();
		helper.setDriver(driver)
		.setPollingInterval(500)
		.setTimeOut(60)
		.setIgnoreExceptionList(exception)
		.build();
		
		helper.waitFor(waitForElement(By.id("123")));
		helper.waitFor(ExpectedConditions.alertIsPresent());
	}
	
	public static Function<WebDriver, WebElement> waitForElement(final By locator) {
		Function<WebDriver, WebElement> waitFunction = new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				return t.findElement(locator);
			}
		};
		return waitFunction;
	}

}
