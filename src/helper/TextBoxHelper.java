package helper;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.WebElement;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class TextBoxHelper extends StartWebDriver {
	private static final Logger oLog = LoggerHelper.getLogger(TextBoxHelper.class);
	
	public static void typeInTextBox(String locator,String value) {
		WebElement ele = getElement(locator);
		ele.sendKeys(value);
		oLog.info(" typeInTextBox : " + locator + " Value : " + value);
		
	}
	
	public static void clear(String locator) {
		WebElement ele = getElement(locator);
		ele.clear();
		oLog.info(" Clear ");
	}
	
	public static void typeUsingKeyword(XSSFRow row) {
		
		switch (row.getCell(3).getCellType()) {
		
		case XSSFCell.CELL_TYPE_STRING:
			typeInTextBox(row.getCell(2).getStringCellValue(), row.getCell(3)
					.getStringCellValue());
			break;

		case XSSFCell.CELL_TYPE_NUMERIC:
			typeInTextBox(row.getCell(2).getStringCellValue(), row.getCell(3)
					.getNumericCellValue() + "");
			break;
		}
		
	}

	public static void typeUsingKeyWord(String stringCellValue,
			String stringCellValue2, String stringCellValue3) {
	}
	
}
