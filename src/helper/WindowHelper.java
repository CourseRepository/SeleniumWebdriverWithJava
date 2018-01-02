package helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class WindowHelper extends StartWebDriver {
	private static final Logger oLog = LoggerHelper.getLogger(WindowHelper.class);
	public static void switchTo(int index) {
		try {
			List<String> win = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(win.get(index));
			oLog.info(" Switching to Window index : " + index);
		} catch (IndexOutOfBoundsException e) {
			oLog.fatal(" Invalid Window Index : " + index, e);
			throw new IndexOutOfBoundsException("Invalid Window Index : " + index);
		}
		
	}
	
	public static void switchToParentWithClose() {
		List<String> win = new ArrayList<String>(driver.getWindowHandles());
		
		for(int i = 1; i < win.size(); i++){
			driver.switchTo().window(win.get(i));
			driver.close();
		}
		driver.switchTo().window(win.get(0));
		oLog.info(" Switching to Parent Window ");
		
	}
	
	public static boolean isBrowserPopupPresent() {
		List<String> win = new ArrayList<String>(driver.getWindowHandles());
		if(win.size() >= 2){
			oLog.info(" Browser Popup Present ");
			return true;
		}
		oLog.warn(" No Browser Popup Present ");
		return false;
	}
	
	public static void back() {
		driver.navigate().back();
		oLog.info(" back ");
		
	}
	
	public static  void forward() {
		driver.navigate().forward();
		oLog.info(" forward ");
		
	}
	
	public static void refresh() {
		driver.navigate().refresh();
		oLog.info(" refresh ");
		
	}
	
	public static void navigateToPage(String url) {
		driver.navigate().to(url);
		oLog.info(" navigateToPage : " + url);
	}
	
	public static void windowMaximize() {
		driver.manage().window().maximize();
		oLog.info(" windowMaximize  ");
	}

}
