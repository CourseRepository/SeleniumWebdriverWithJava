package helper;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GridHelper extends StartWebDriver {
	
	
	static String getTableXpath(String locator,int row,int col){
		return locator + "//tbody//tr[" + row + "]//td[" + col + "]";
	}
	
	
	private static WebElement getGridElement(String locator,int row,int col){
		
		if (GenericHelper.isElementPresent(By.xpath(getTableXpath(locator, row, col) + "//a"))) {
			return driver.findElement(By.xpath(getTableXpath(locator, row, col) + "//a"));			
		}
		else if (GenericHelper.isElementPresent(By.xpath(getTableXpath(locator, row, col) + "//input"))) {
			return driver.findElement(By.xpath(getTableXpath(locator, row, col) + "//a"));			
		}else {
			return driver.findElement(By.xpath(getTableXpath(locator, row, col)));
		}
	}
	
	
	public static String getColumnValue(String locator,int row,int col) {
		
		return getGridElement(locator, row, col).getText();
	}
	
	public static List<String> getAllValues(String locator) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		int row = 1;
		int col = 1;
		
		while(GenericHelper.isElementPresent(By.xpath(getTableXpath(locator, row, col)))){
			while(GenericHelper.isElementPresent(By.xpath(getTableXpath(locator, row, col)))){
				list.add((getColumnValue(locator, row, col)));
				col++;
			}
			row++;
			col = 1;
		}
		return list;
	}
	
	public static void clickButtonInGrid(String locator,int row,int col) {
		getGridElement(locator, row, col).click();
	}

}
