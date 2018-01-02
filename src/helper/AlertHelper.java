package helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;


/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class AlertHelper extends StartWebDriver {
	
	private static Alert alert = null;
	private static final Logger oLog = LoggerHelper.getLogger(AlertHelper.class);
	
	public static void clickOk() {
		alert = driver.switchTo().alert();
		alert.accept();
		oLog.info(" Click on Accept/Ok Button ");
		
	}
	
	public static void clickCancel() {
		alert = driver.switchTo().alert();
		alert.dismiss();
		oLog.info(" Click on Dismiss/Cancel Button ");
		
	}
	
	public static String getText() {
		alert = driver.switchTo().alert();
		oLog.info(" Get the text of Alert ");
		return alert.getText();
		
	}
	
	public static void sendKeys(String value) {
		alert = driver.switchTo().alert();
		alert.sendKeys(value);
		oLog.info(" Enter the " + value + " to the Alert ");
	}
	
	public static boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			oLog.info(" Checking for AlertPresent ");
			return true;
		} catch (Exception e) {
			oLog.warn(" Alert is Not Present ");
			return false;
		}
		
	}

}
