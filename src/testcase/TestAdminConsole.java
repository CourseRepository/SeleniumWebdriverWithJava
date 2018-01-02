package testcase;

import helper.ButtonHelper;
import helper.LinkHelper;
import helper.StartWebDriver;
import helper.TextBoxHelper;
import helper.WindowHelper;

import java.io.IOException;

import org.testng.annotations.Test;


/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class TestAdminConsole extends StartWebDriver {
	
	@Test
	public void testAdmin() throws IOException, InterruptedException {
		/*
		WindowHelper.windowMaximize();
		Process p = Runtime.getRuntime().exec("F:\\AutoIT Script\\Test.exe");
		ButtonHelper.clickButton("//span[text()='Manager App']");
		p.waitFor();*/
		
		String path = TestAdminConsole.class.getClassLoader().getResource("resource/").getPath();
		path = path.replaceAll("bin", "src");
		
		WindowHelper.navigateToPage(file.getUrl());
		LinkHelper.clickLink("File a Bug");
		TextBoxHelper.typeInTextBox("Bugzilla_login", file.getUsername());
		TextBoxHelper.typeInTextBox("Bugzilla_password", file.getPassword());
		ButtonHelper.clickButton("log_in");
		LinkHelper.clickLink("Testng");
		ButtonHelper.clickButton("//input[@value='Add an attachment']");
		Process p = Runtime.getRuntime().exec(path + "FileUpload.exe " + "G:\\Book_Link.txt");
		ButtonHelper.clickButton("data");
		Thread.sleep(1000);
		p.waitFor();
		ButtonHelper.clickLogout();

	}

}
