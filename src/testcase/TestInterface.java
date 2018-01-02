package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


/*interface interfaceOne{
	public abstract void display();
	String getMsg(String str);
}

interface interfaceTwo{
	void showInt();
}

class baseClass implements interfaceOne,interfaceTwo {

	@Override
	public void display() {
		System.err.println("Interface One Menthod");
		
	}

	@Override
	public String getMsg(String str) {
		return str;
	}

	@Override
	public void showInt() {
		System.err.println("Inter Face two : 10");
		
	}
	
}*/

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 * @project - Webdriver
 * @package - testcase
 * @file name - TestInterface.java
 */
public class TestInterface {
	
	public static WebDriver driver = null;

	
	public static void main(String[] args) {
		driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Junit\\selenium-2.41.0\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.setProperty("webdriver.ie.driver", "C:\\Junit\\selenium-2.41.0\\IEDriverServer_x64_2.30.2\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
		/*baseClass obj = new baseClass();
		obj.display();
		System.err.println("Value : " + obj.getMsg("Method"));
		obj.showInt();*/
		
		/*interfaceOne obj = new baseClass();
		obj.display();
		System.err.println("Value : " + obj.getMsg("Method"));*/
		
	/*	interfaceTwo obj = new baseClass();
		obj.showInt();
		*/
		

	}

	

}
