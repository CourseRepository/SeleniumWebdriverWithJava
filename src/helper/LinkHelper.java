package helper;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class LinkHelper extends StartWebDriver {
	private static final Logger oLog = LoggerHelper.getLogger(LinkHelper.class);
	public static void clickLink(String linkText) {
		
		if(driver.findElements(By.linkText(linkText)).size() == 1){
			driver.findElement(By.linkText(linkText)).click();
			oLog.info(" clickLink : " + linkText);
		}else if(driver.findElements(By.partialLinkText(linkText)).size() == 1){
			driver.findElement(By.partialLinkText(linkText)).click();
			oLog.info(" clickLink : " + linkText);
		}else{
			oLog.error(" Link Text Not Found : " + linkText);
			throw new NoSuchElementException("Link Text Not Found : " + linkText);
		}
	}
	
	public static void clickUsingKeyword(XSSFRow row) {
		clickLink(row.getCell(2).getStringCellValue());
	}

}
