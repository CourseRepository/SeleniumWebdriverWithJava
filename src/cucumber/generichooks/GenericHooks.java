/**
 * 
 */
package cucumber.generichooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.settings.TestSettings;

/**
 * @author - rahul.rathore
 * @date - 03-May-2015
 * @project - Webdriver
 * @package - cucumber.generichooks
 * @file name - GenericHooks.java
 */
public class GenericHooks {
	//private WebDriver driver;
	@Before(value="@firefox")
	public void setUp() {
		TestSettings.driver = new FirefoxDriver();
		TestSettings.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		TestSettings.driver.manage().window().maximize();
	    System.out.println("---Firefox Hook----");
	    TestSettings.title = "Bugzila";
	}
	
	@Before(value="@chrome")
	public void setUpChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rahul.rathore\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		TestSettings.driver = new ChromeDriver();
		TestSettings.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		TestSettings.driver.manage().window().maximize();
	    System.out.println("---Chrome Hook----");
	}
	
	@After(value={"@firefox,@chrome"})
	public void tearDown() {
		TestSettings.driver.quit();
		System.out.println("---After Hook----");
	}
}
