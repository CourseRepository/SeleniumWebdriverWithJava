package testcase.testOne;

import helper.ButtonHelper;
import helper.StartWebDriver;
import helper.WindowHelper;

import org.testng.annotations.Test;

public class TestClickButton extends StartWebDriver {
	@Test
	public void testButtonClick() throws InterruptedException {
		WindowHelper.navigateToPage("https://jhu.test.technolutions.net/account/login");
		ButtonHelper.clickButton(".//button[text()='Login']");
		Thread.sleep(5000);
	}
}
