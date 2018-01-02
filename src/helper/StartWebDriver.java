package helper;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public abstract class StartWebDriver extends ElementRepositry {
	
	private static DesiredCapabilities cap = null;
	public static WebDriver driver = null;
	protected static ReadConfigProperty file = null;
	private static final Logger oLog = Logger.getLogger(StartWebDriver.class); 
	
	private WebDriver getFireFoxDriver() throws MalformedURLException {
		WebDriver drWebDriver = null;
		String firefoxPath = StartWebDriver.class.getClassLoader().getResource("resource/").getPath();
		firefoxPath = firefoxPath.replaceAll("bin", "src");
		System.setProperty("webdriver.gecko.driver", firefoxPath + "geckodriver.exe");
		cap = DesiredCapabilities.firefox();
		if(file.isGridPresent())
			drWebDriver = new RemoteWebDriver(new URL(file.getGridUrl()), cap);
		else
			drWebDriver = new FirefoxDriver();
		oLog.info(" Using Firefox Driver ");
		return drWebDriver;
	}
	
	private WebDriver getChromeDriver() throws MalformedURLException {
		WebDriver drWebDriver = null;
		String chromePath = StartWebDriver.class.getClassLoader().getResource("resource/").getPath();
		chromePath = chromePath.replaceAll("bin", "src");
		System.setProperty("webdriver.chrome.driver", chromePath + "chromedriver.exe");
		cap = DesiredCapabilities.chrome();
		if(file.isGridPresent())
			drWebDriver = new RemoteWebDriver(new URL(file.getGridUrl()), cap);
		else
			drWebDriver = new ChromeDriver();
		oLog.info(" Using Chrome Driver ");
		return drWebDriver;
	}
	
	private WebDriver getIEDriver() throws MalformedURLException{
		WebDriver drWebDriver = null;
		String explorerPath = StartWebDriver.class.getClassLoader().getResource("resource/").getPath();
		explorerPath = explorerPath.replaceAll("bin", "src");
		System.setProperty("webdriver.ie.driver", explorerPath + "IEDriverServer.exe");
		cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		if(file.isGridPresent())
			drWebDriver = new RemoteWebDriver(new URL(file.getGridUrl()), cap);
		else
			drWebDriver = new InternetExplorerDriver();
		oLog.info(" Using IE Driver ");
		return drWebDriver;
	}
	
	private WebDriver getHTMLUnitDriver() throws MalformedURLException{
		WebDriver drWebDriver = null;
		cap = DesiredCapabilities.htmlUnit();
		if(file.isGridPresent())
			drWebDriver = new RemoteWebDriver(new URL(file.getGridUrl()), cap);
		else
			drWebDriver = new HtmlUnitDriver();
		oLog.info(" Using HTMLUnit Driver ");
		return drWebDriver;
	}
	
	public StartWebDriver(){
		file = new ReadConfigProperty("config.properties");
	}
	
	public StartWebDriver(ReadConfigProperty file){
		StartWebDriver.file = file;
	}
	
	
	@BeforeTest
	public void setUp(){
		try {
			switch (file.getBrowser()) {
			case "firefox":
				driver = getFireFoxDriver();
				break;
			case "chrome":
				driver = getChromeDriver();
				break;
			case "explorer":
				driver = getIEDriver();
				break;
			default:
				driver = getHTMLUnitDriver();
				break;
			}
			
			driver.manage().timeouts().pageLoadTimeout(file.getPageWait(), TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(file.getElementWait(), TimeUnit.SECONDS);
			driver.get(file.getUrl());	
			WindowHelper.windowMaximize();
			PageFactory.initElements(driver, ElementRepositry.class);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected static WebElement getElement(String locator) {
		boolean flag = false;
		if(locator.contains("/"))
			flag = true;
		if(driver.findElements(By.id(locator)).size() == 1){
			return driver.findElement(By.id(locator));
		}else if(driver.findElements(By.name(locator)).size() == 1 ){
			return driver.findElement(By.name(locator));
		}else if(!flag && driver.findElements(By.cssSelector(locator)).size() == 1){
			return driver.findElement(By.cssSelector(locator));
		}else if(driver.findElements(By.xpath(locator)).size() == 1){
			return driver.findElement(By.xpath(locator));
		}else{
			oLog.error(" No Such Element : " + locator);
			throw new NoSuchElementException("No Such Element : " + locator);
		}
	}
	
	@AfterTest(alwaysRun=true)
	public void tearDown() {
		try {
			if(driver != null){
				driver.close();
				driver.quit();
				driver = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			oLog.fatal(" Exception : ", e);
		}
		
	}
	
	protected static String getRootPath() {
		String path = GenericHelper.class.getClassLoader().getResource("./").getPath();
		path = path.replaceAll("bin", "src");
		return path;
	}

}

