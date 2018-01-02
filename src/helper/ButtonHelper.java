package helper;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class ButtonHelper extends StartWebDriver {
	
	private final static Logger oLog = LoggerHelper.getLogger(ButtonHelper.class);
	
	public static void clickButton(String locator) {
		WebElement ele = getElement(locator);
		ele.click();
		oLog.info(" Clicked on Button : " + locator);
		
	}
	
	public static void clickLogout() {
		if(GenericHelper.isElementPresent("//div[@id='header']/ul[1]/li[11]/a")){
			driver.findElement(By.xpath("//div[@id='header']/ul[1]/li[11]/a")).click();
			GenericHelper.waitForElement("//h1[@id='welcome']");
		}else if(GenericHelper.isElementPresent("//div[@id='header']/ul[1]/li[10]/a") && driver.findElement(By.xpath("//div[@id='header']/ul[1]/li[10]/a")).getText().equalsIgnoreCase("Log out")){
			driver.findElement(By.xpath("//div[@id='header']/ul[1]/li[10]/a")).click();
			GenericHelper.waitForElement("//h1[@id='welcome']");
		}
		oLog.info(" Clicked on Logout Button ");
	}
	
	public static void clickUsingKeyword(XSSFRow row) {
		clickButton(row.getCell(2).getStringCellValue());
		
	}
	public static void clickUsingKeyword(String locator) {
		clickButton(locator);
		
	}

	public static void clickUsingKeyWord(String stringCellValue,
			String stringCellValue2) {
	}

}
