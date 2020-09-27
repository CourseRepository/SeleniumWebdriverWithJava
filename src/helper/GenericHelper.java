package helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class GenericHelper extends StartWebDriver {
	
	private static DateFormat date = null;
	private static File folder = null; 
	private static Calendar cal = null;
	private static final Logger oLog = LoggerHelper.getLogger(GenericHelper.class);
	
	/*private static String getPath() {
		String path = GenericHelper.class.getClassLoader().getResource("./").getPath();
		path = path.replaceAll("bin", "src");
		return path + "screenshot";
	}
	*/
	
	public static byte[] takeScreenShot() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	public static void takeScreenShot(String fileName) {
		
		date = new SimpleDateFormat("dd-MM-yyyy");
		cal = Calendar.getInstance();
		
		String folderName = "" + date.format(cal.getTime());
		String path = getRootPath() + "screenshot" + System.getProperty("file.separator") + folderName;
		
		folder = new File(path);
		
		if(!folder.exists())
			folder.mkdir();
		
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(path + System.getProperty("file.separator") + fileName + ".jpg"));
			oLog.info(" ScreenShot File : " + fileName + ".jpg");
		} catch (IOException e) {
			e.printStackTrace();
			oLog.fatal(" IOException : ", e);
		}
		
	}
	
	public static void takeMultipleScreeShot(String fileName) {
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("window.scrollTo(0,0)");
		Boolean a = (Boolean) exe.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight");
		Long clientH = (Long)exe.executeScript("return document.documentElement.clientHeight");
		Long scrollH = (Long)exe.executeScript("return document.documentElement.scrollHeight");
		int index = 1;
		if(a.booleanValue() && !"firefox".equalsIgnoreCase(file.getBrowser())){
			while(scrollH.intValue() > 0){
				GenericHelper.takeScreenShot(fileName + "-" + index);
				GenericHelper.executeScript("window.scrollTo(0," + clientH * index + ")");
				scrollH = scrollH - clientH;
				oLog.info(" Screen Shot Taken : " + index);
				index++;
			}
		}else
			GenericHelper.takeScreenShot(fileName);
	}
	
	public static boolean isElementPresent(String locator) {
		boolean status = false;
		
		boolean flag = false;
		if(locator.contains("/"))
			flag = true;
		if(driver.findElements(By.id(locator)).size() >= 1){
			status = true;
		}else if(driver.findElements(By.name(locator)).size() >= 1 ){
			status = true;
		}else if(!flag && driver.findElements(By.cssSelector(locator)).size() >= 1){
			status = true;
		}else if(driver.findElements(By.xpath(locator)).size() >= 1){
			status = true;
		}else
			status = false;
		return status;
	}
	
	public static Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return (exe.executeScript(script));
		
	}
	
	public static Object executeScript(String script,Object ...element) {
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return (exe.executeScript(script,element));
		
	}
	
	public static void waitForElement(String locator,int...delay) {
		
		WebDriverWait wait = null;
		
		if(delay.length >= 1)
			wait = new WebDriverWait(driver, delay[0]);
		else
			wait = new WebDriverWait(driver, 30);
		
		boolean flag = false;
		if(locator.contains("/"))
			flag = true;
		if(driver.findElements(By.id(locator)).size() >= 1){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
			return;
		}else if(driver.findElements(By.name(locator)).size() >= 1 ){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
			return;
		}else if(!flag && driver.findElements(By.cssSelector(locator)).size() >= 1){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
			return;
		}else if(driver.findElements(By.xpath(locator)).size() >= 1){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
			return;
		}else{
			oLog.error(" Element Not Found : " + locator);
			throw new NoSuchElementException("Element Not Found : " + locator);
		}
	}
	
	public static void waitUsingKeyword(XSSFRow row) {
		waitForElement(row.getCell(2).getStringCellValue(), (int)row.getCell(3).getNumericCellValue());
		
	}
	
	public static void UploadFile(String []aImages,String aLocWithFileName) throws FindFailed {
		String browserName = "";
		
		switch (file.getBrowser()) {
		case "firefox":
			browserName = "firefox";
			break;
		case "chrome":
			browserName = "chrome";
			break;
		case "explorer":
			browserName = "explorer";
			break;
		}
		
		String path = getRootPath() + "Images" + System.getProperty("file.separator") + browserName + System.getProperty("file.separator");
		Pattern []imgPatter = new Pattern[aImages.length];
		
		for(int i = 0; i < aImages.length; i++)
			imgPatter[i] = new Pattern(path + aImages[i]);
		
		Screen src = new Screen();
		src.setAutoWaitTimeout(30);
		src.click(imgPatter[0]);
		src.type(imgPatter[1], aLocWithFileName);
		src.click(imgPatter[2]);
	}

	public static boolean isElementPresent(By xpath) {
		return driver.findElements(xpath).size() >= 1;
	}

}
