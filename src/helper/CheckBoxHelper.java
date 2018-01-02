package helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class CheckBoxHelper extends StartWebDriver {
	
	private final static Logger oLog = LoggerHelper.getLogger(CheckBoxHelper.class);
	public static void clickCheckBox(String locator) {
		WebElement ele = getElement(locator);
		ele.click();
		oLog.info(" Clicked on Checkbox : " + locator);
	}
	
	public static boolean isChecked(String locator) {
		WebElement ele = getElement(locator);
		oLog.info(" isChecked : " + locator);
		return ele.isSelected();
		
	}

}
