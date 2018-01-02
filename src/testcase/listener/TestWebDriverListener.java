package testcase.listener;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import helper.StartWebDriver;

public class TestWebDriverListener extends StartWebDriver {
	
	@Test
	public void testCaseOne() throws InterruptedException{
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		CustomeWebDriverListener listener = new CustomeWebDriverListener();
		edriver.register(listener);
		edriver.navigate().to("http://localhost:5001/");
		edriver.findElement(By.xpath("//a[@id='enter_bug']/span")).click();
		edriver.unregister(listener);
		edriver.navigate().to("http://www.google.com");
		Thread.sleep(1000);
	}
	
}
