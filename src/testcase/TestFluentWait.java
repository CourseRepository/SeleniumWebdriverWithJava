package testcase;

import java.util.concurrent.TimeUnit;

import helper.LinkHelper;
import helper.StartWebDriver;
import helper.TextBoxHelper;
import helper.WindowHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestFluentWait.java
 */
public class TestFluentWait extends StartWebDriver {
	
	@Test
	public void testWait(){
		
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//1 driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		/*LinkHelper.clickLink("File");
		//step- 1
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		//step - 2
		
		wait.withTimeout(30, TimeUnit.SECONDS);
		//step - 3
		
		wait.pollingEvery(5, TimeUnit.MILLISECONDS);
		
		//step - 4
		
		wait.ignoring(NoSuchElementException.class);
		
		Function<WebDriver, WebElement> fun = new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver arg0) {
				System.out.println("Not Found");
				return arg0.findElement(By.id("log_in"));
			}
		};
		
		wait.until(fun).click();
		System.out.println("Element Found");*/
		
		WindowHelper.navigateToPage("http://www.w3schools.com/ajax/tryit.asp?filename=tryajax_suggest");
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		
		FluentWait<WebElement> wait = new FluentWait<WebElement>(driver.findElement(By.id("txtHint")));
		wait.withTimeout(30, TimeUnit.SECONDS);
		wait.pollingEvery(1, TimeUnit.MILLISECONDS);
		
		Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>() {

			@Override
			public Boolean apply(WebElement arg0) {
				if(!arg0.getText().equalsIgnoreCase("")){
					System.out.println("Text : " + arg0.getText());
					return true;
				}
				else{
					System.err.println("Not Found");
					return false;
				}
			}
		};
		
		/*Predicate<WebElement> p = new Predicate<WebElement>() {

			@Override
			public boolean apply(WebElement arg0) {
				if(!arg0.getText().equalsIgnoreCase("")){
					System.out.println("Text : " + arg0.getText());
					return true;
				}
				else{
					System.err.println("Not Found");
					return false;
				}
			}
		};*/
		
		TextBoxHelper.typeInTextBox("txt1", "j");
		wait.until(fun);

	}

}
