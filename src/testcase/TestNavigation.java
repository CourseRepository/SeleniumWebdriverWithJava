package testcase;

import helper.LinkHelper;
import helper.StartWebDriver;
import helper.WindowHelper;

import org.testng.annotations.Test;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestNavigation.java
 */
public class TestNavigation extends StartWebDriver {
	
	@Test
	public void testNavigate() {
		WindowHelper.navigateToPage(file.getUrl());
		LinkHelper.clickLink("File a Bug");
		WindowHelper.windowMaximize();
		WindowHelper.back();
		WindowHelper.forward();
		WindowHelper.refresh();
		WindowHelper.navigateToPage("http://mail.google.com");
		
	}


}
