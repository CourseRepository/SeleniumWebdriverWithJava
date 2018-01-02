package testcase;

import org.testng.annotations.Test;

import pom.BugDetail;
import pom.EnterBug;
import pom.HomePage;
import pom.LoginPage;
import helper.StartWebDriver;
import helper.WindowHelper;

public class TestPageObjectModel extends StartWebDriver {
	
	@Test
	public void testCase() {
		WindowHelper.navigateToPage("http://localhost:5001/");
		HomePage hPage = new HomePage(driver);
		LoginPage lPage = hPage.ClickFileABug();
		EnterBug ePage = lPage.Login(file.getUsername(), file.getPassword());
		BugDetail bPage = ePage.ClickTestNg();
		bPage.SelectSeverity("critical");
	}

}
