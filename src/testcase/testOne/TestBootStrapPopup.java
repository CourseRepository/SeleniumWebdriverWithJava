package testcase.testOne;

import org.testng.annotations.Test;

import helper.ButtonHelper;
import helper.GenericHelper;
import helper.StartWebDriver;
import helper.WindowHelper;

public class TestBootStrapPopup extends StartWebDriver {
	
	private final String buttonXpath = "//button[text()='Click To Open Modal']";
	private final String closeButtonXpath = "//button[text()='Close']";
	private final String modaltitleId = "myModalLabel";
	
	@Test
	public void testBootStrapPopup(){
		WindowHelper.navigateToPage("https://www.w3schools.com/bootstrap/bootstrap_modal.asp");
		GenericHelper.waitForElement(buttonXpath, 60);
		ButtonHelper.clickButton(buttonXpath);
		GenericHelper.waitForElement(closeButtonXpath, 60);
		String title = GenericHelper.getElement(modaltitleId).getText();
		System.out.println(title);

	}

}
