/**
 * 
 */
package cucumber.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author - rahul.rathore
 * @date - 26-Apr-2015
 * @project - Webdriver
 * @package - cucumber.stepdefination
 * @file name - Firstfeature.java
 */
public class Firstfeature {
	
	private WebDriver driver = null;
	
	@Given("^I should be at the login page$")
	public void i_should_be_at_the_login_page() throws Throwable {
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get("http://localhost:5001/");
	}

	@And("^I provide valid userid and password$")
	public void i_provide_valid_userid_and_password() throws Throwable {
		driver.findElement(By.xpath("//a[@id='enter_bug']/span")).click();
		driver.findElement(By.id("Bugzilla_login")).sendKeys("rahul@bugzila.com");
		driver.findElement(By.id("Bugzilla_password")).sendKeys("rathore");
	}

	@When("^I click on login button$")
	public void i_click_on_login_button() throws Throwable {
		driver.findElement(By.id("log_in")).click();
	}

	@Then("^I should be able to login inside the bugzila$")
	public void i_should_be_able_to_login_inside_the_bugzila() throws Throwable {
		
	}

	@And("^The title of web page should be Bugzila Main page$")
	public void the_title_of_web_page_should_be_Bugzila_Main_page() throws Throwable {
		Assert.assertTrue(driver.getTitle().contains("Enter Bug"));
		driver.quit();
	}
	

}
