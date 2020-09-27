package testcase.testOne;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import helper.StartWebDriver;
import helper.WindowHelper;

public class TestShadowDom extends StartWebDriver{

	@Test
	public void testCaseShadowDom() {
		WindowHelper.navigateToPage("https://configurator.scania.com/index.aspx?etel_market=5134&etel_language=5509");
		WebElement test = driver.findElement(By.id("app"));
		WebElement element = expandRootElement(test,"app");
		element.click();
		System.out.println(element);
	}
	
	public WebElement expandRootElement(WebElement element,String id) {
		Object abc =  ((JavascriptExecutor)driver)
				.executeScript("return document.querySelector('#app').shadowRoot.querySelector('#goWizard').shadowRoot.getElementById('questions')");
	//.executeScript("return document.getElementById(\"" + id + "\").shadowRoot", element);
		WebElement ele = (WebElement) abc;
		return ele;
	}
}
