/**
 * 
 */
package cucumber.stepdefination;

import helper.StartWebDriver;

import org.testng.annotations.Test;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.TestNGCucumberRunner;

/**
 * @author - rahul.rathore
 * @date - 05-May-2015
 * @project - Webdriver
 * @package - cucumber.stepdefination
 * @file name - TestNgStpDfn.java
 */
public class TestNgStpDfn extends StartWebDriver {
	 
	@When("^I click on the \"(.*?)\" link$")
	public void i_click_on_the_link(String arg1) throws Throwable {
	    driver.get("http://www.google.com");
	    Thread.sleep(5000);
	}

	@Then("^I should be redirected to the login page$")
	public void i_should_be_redirected_to_the_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I provide the username and password and click on login button$")
	public void i_provide_the_username_and_password_and_click_on_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I should be logged in$")
	public void i_should_be_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I click on log out$")
	public void i_click_on_log_out() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
