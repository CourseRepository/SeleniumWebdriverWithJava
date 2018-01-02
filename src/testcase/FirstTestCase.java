package testcase;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class FirstTestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//FirefoxDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.ie.driver", "C:\\Junit\\selenium-2.41.0\\IEDriverServer_x64_2.30.2\\IEDriverServer.exe");
		//InternetExplorerDriver driver = new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Junit\\selenium-2.41.0\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

	}

}
