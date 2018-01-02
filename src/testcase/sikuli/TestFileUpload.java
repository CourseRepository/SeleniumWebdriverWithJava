/**
 * 
 */
package testcase.sikuli;

import helper.ButtonHelper;
import helper.GenericHelper;
import helper.LinkHelper;
import helper.StartWebDriver;
import helper.TextBoxHelper;

import org.testng.annotations.Test;
/*
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;
*/
/**
 * @author - rahul.rathore
 * @date - 14-Mar-2015
 * @project - Webdriver
 * @package - testcase.sikuli
 * @file name - TestFileUpload.java
 */
public class TestFileUpload extends StartWebDriver {

	@Test
	public void testUpload() throws Exception {
		LinkHelper.clickLink("File a Bug");
		TextBoxHelper.typeInTextBox("Bugzilla_login", file.getUsername());
		TextBoxHelper.typeInTextBox("Bugzilla_password", file.getPassword());
		ButtonHelper.clickButton("log_in");
		LinkHelper.clickLink("Testng");
		ButtonHelper.clickButton("//input[@value='Add an attachment']");
		/*Thread.sleep(2000);
		ButtonHelper.clickButton("data");
		HWND hwnd = User32.INSTANCE.FindWindow(null,
				"Enter Bug: Testng - Mozilla Firefox"); // window title
		if (hwnd == null) {
			System.out.println("Excel is not running");
		} else {
			User32.INSTANCE.ShowWindow(hwnd, WinUser.SC_MAXIMIZE); // SW_RESTORE
			User32.INSTANCE.SetForegroundWindow(hwnd); // bring to front
		}*/
		String images[] = {"browse.png","fileName.png","open.png"};
		GenericHelper.UploadFile(images, "G:\\Java-Doc\\Close Up Card Magic.pdf");

	}
}
