package seleniumgrid;

import helper.ElementRepositry;
import helper.ReadConfigProperty;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class FirefoxTest extends ElementRepositry {
	
	private static WebDriver driver;
	private static DesiredCapabilities cap;
	private static WebDriverWait wait;
	private static ReadConfigProperty file = new ReadConfigProperty();
	
	@BeforeClass
	public static void startSelenium() throws MalformedURLException {
		cap = DesiredCapabilities.firefox();
		driver = new RemoteWebDriver(new URL("http://10.150.113.50:4444/wd/hub"), cap);
		PageFactory.initElements(driver, ElementRepositry.class);
		wait = new WebDriverWait(driver, 40);
		driver.manage().timeouts().implicitlyWait(file.getPageWait(), TimeUnit.SECONDS);
		driver.get(file.getUrl());
	}
	
	@Test(priority=1)
	public void testPreferences() {
		file_a_Bug.click();
		Bugzilla_login.sendKeys(file.getUsername());
		Bugzilla_password.sendKeys(file.getPassword());
		log_in.click();
		
		Assert.assertTrue(driver.getTitle().contains("Enter"));
		driver.findElement(By.xpath("//div[@id='header']/ul[1]/li[8]/a")).click();
		Assert.assertTrue(driver.getTitle().contains("Preferences"));
		logout_button.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@id='welcome']")));
	}
	
	@Test(priority=2)
	public void testAdministration() {
		file_a_Bug.click();
		Bugzilla_login.sendKeys(file.getUsername());
		Bugzilla_password.sendKeys(file.getPassword());
		log_in.click();
		
		Assert.assertTrue(driver.getTitle().contains("Enter"));
		driver.findElement(By.xpath("//div[@id='header']/ul[1]/li[9]/a")).click();
		Assert.assertTrue(driver.getTitle().contains("Administer"));
		logout_button.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@id='welcome']")));
	}
	
	@AfterClass(alwaysRun=true)
	public static void stopSelenium() {
		
		if(driver != null){
			driver.close();
			driver.quit();
			driver = null;
		}
		
	}

}
