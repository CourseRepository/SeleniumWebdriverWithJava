/**
 * 
 */
package Keyword;

import helper.ButtonHelper;
import helper.ComboBoxHelper;
import helper.GenericHelper;
import helper.LinkHelper;
import helper.TextBoxHelper;
import helper.customexceptions.KeyWordNotFoundException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author - rahul.rathore
 * @date - 13-Jun-2015
 * @project - Webdriver
 * @package - keyword
 * @file name - keywordsteps.java
 */
public class KeywordSteps{
	
	private static FileInputStream xlStream;
	private static XSSFWorkbook book;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	
	public static void readExcelPerformAction(String aFilePath,String bSheetName) {
		try {
			
				xlStream = new FileInputStream(new File(aFilePath));
				book = new XSSFWorkbook(xlStream);
				sheet = book.getSheet(bSheetName);
				
				for(int i = 2; i <= sheet.getLastRowNum(); i++){
					row = sheet.getRow(i);
					
					switch (row.getCell(0).getStringCellValue()) {
					
					case "Click":
						LinkHelper.clickLink(row.getCell(2).getStringCellValue());
						break;
						
					case "TextBox":
						TextBoxHelper.typeUsingKeyWord(row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue(), row.getCell(3).getStringCellValue());
						break;
						
					case "Button click":
						ButtonHelper.clickUsingKeyWord(row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue());
						break;
						
					case "Select":
						ComboBoxHelper.selectByKeyWord(row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue(), row.getCell(3).getStringCellValue());	
						break;
					
					case "Radio Button":
						ButtonHelper.clickUsingKeyWord(row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue());
						break;
						
					case "WaitForEle":
						GenericHelper.waitForElement(row.getCell(2).getStringCellValue(), (int)row.getCell(3).getNumericCellValue());
						break;
						
					case "Assert":
						break;
						
					default:
						throw new KeyWordNotFoundException(row.getCell(0).getStringCellValue());
					}
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(book != null)
				book = null;
			if(xlStream != null){
				try {
					xlStream.close();
				} catch (IOException e) {
				}finally{
					xlStream = null;
				}
				
			}
				
		}
	}
}
