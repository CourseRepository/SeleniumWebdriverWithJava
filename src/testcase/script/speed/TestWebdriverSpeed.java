package testcase.script.speed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestWebdriverSpeed {
	
	private WebDriver wDriver = null;
	private EventFiringWebDriver driver = null;
	
	@BeforeClass
	public void setUp() throws Exception {
		wDriver = new FirefoxDriver();
		WebdriverSpeed setSpeed = new WebdriverSpeed(2000);
		driver = new EventFiringWebDriver(wDriver);
		driver.register(setSpeed);
	}
	
	@Test
	public void testCaseOne(){
		driver.get("http://localhost:5001/");
		driver.findElement(By.id("login_link_top")).click();
	}
	
	@AfterClass
	public void tearDown() {
		
		if(driver != null){
			driver.quit();
			driver = null;
		}
	}

}
