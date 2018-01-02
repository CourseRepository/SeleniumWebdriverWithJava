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
 * @date - 20-Jun-2015
 * @project - Webdriver
 * @package - Keyword
 * @file name - KeywordStepDfn.java
 */
public class KeywordStepDfn {
	
	private static XSSFWorkbook book;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static FileInputStream _readExcel;
	
	public static void performActionWithKeyword(String aFilePath,String bSheetName) throws IOException {
		try {
			_readExcel = new FileInputStream(new File(aFilePath));
			book = new XSSFWorkbook(_readExcel);
			sheet = book.getSheet(bSheetName);
			
			for(int i = 2; i <= sheet.getLastRowNum(); i++){
				row = sheet.getRow(i);
				
				switch (row.getCell(0).getStringCellValue()) {
				
				case "Click":
					LinkHelper.clickUsingKeyword(row);
					break;
					
				case "TextBox":
					TextBoxHelper.typeUsingKeyword(row);
					break;
					
				case "Radio Button":
					ButtonHelper.clickUsingKeyword(row);
					break;
				
				case "Button click":
					ButtonHelper.clickUsingKeyword(row);
					break;
					
				case "Select":
					ComboBoxHelper.selectUsingKeyword(row);
					break;
					
				case "WaitForEle":
					GenericHelper.waitUsingKeyword(row);
					break;

				default:
					throw new KeyWordNotFoundException(row.getCell(0).getStringCellValue() + " was not found");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(book != null)
				book = null;
			if (_readExcel != null) {
				_readExcel.close();
				_readExcel = null;
			}
		}
	}

}
