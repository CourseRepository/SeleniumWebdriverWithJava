package helper;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.support.ui.Select;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class ComboBoxHelper extends StartWebDriver {
	
	private static Select sel = null;
	private static final Logger oLog = LoggerHelper.getLogger(ComboBoxHelper.class);
	
	public static void select(String locator,int index) {
		sel = new Select(getElement(locator));
		sel.selectByIndex(index);
		oLog.info(" Select By Index : " + locator + " : Index Value : " + index);
	}
	
	public static void select(String locator,String value) {
		sel = new Select(getElement(locator));
		sel.selectByValue(value);
		oLog.info(" Select By Value : " + locator + " : Value : " + value);
	}
	
	public static void selectByVisibleText(String locator,String text) {
		sel = new Select(getElement(locator));
		sel.selectByVisibleText(text);
		oLog.info(" Select By Text : " + locator + " : Text : " + text);
	}
	
	public static void selectUsingKeyword(XSSFRow row) {
		selectByVisibleText(row.getCell(2).getStringCellValue(), row.getCell(3).getStringCellValue());
		
	}

	public static void selectByKeyWord(String stringCellValue,
			String stringCellValue2, String stringCellValue3) {
	}

}
