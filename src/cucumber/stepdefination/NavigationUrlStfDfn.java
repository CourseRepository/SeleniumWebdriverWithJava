/**
 * 
 */
package cucumber.stepdefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author - rahul.rathore
 * @date - 02-May-2015
 * @project - Webdriver
 * @package - cucumber.stepdefination
 * @file name - NavigationUrlStfDfn.java
 */

class dataTableClass {
	String linkName;
	String title;
	/**
	 * @return the linkName
	 */
	public String getLinkName() {
		return linkName;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
}

public class NavigationUrlStfDfn {
	
	// 1. using row and colu app
	// 2. using class mapping
	
	private WebDriver driver;
	
	@Given("^User should be at the home page \"(.*?)\"$")
	public void user_should_be_at_the_home_page(String url) throws Throwable {
		driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get(url);
	    System.out.println("---Background Step-----------");
	}
	
	@When("^I click on the link \"(.*?)\"$")
	public void i_click_on_the_link(String link) throws Throwable {
		driver.findElement(By.linkText(link)).click();
	}

	@Then("^I assert for the title \"(.*?)\"$")
	public void i_assert_for_the_title(String title) throws Throwable {
		Assert.assertEquals(driver.getTitle(), title);
	}

	@Then("^I close the browser \"(.*?)\"$")
	public void i_close_the_browser(String browserName) throws Throwable {
		System.out.println("Browser Name : " + browserName);
		 driver.quit();
	}


}
