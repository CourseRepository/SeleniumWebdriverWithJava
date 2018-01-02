package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class ReadExcelFile {

	/**
	 * @param fileName
	 * @param sheetName
	 * @return Map<String,Object>
	 * @throws IOException
	 * Return a Map<String,Object>
	 */
	public static Object[][] getExcelData(String fileName,String sheetName) throws IOException {
		String path = ReadExcelFile.class.getClassLoader().getResource("resource/" ).getPath();
		path = path.replaceAll("bin", "src");
		FileInputStream fin = new FileInputStream(path + fileName);
		XSSFWorkbook book = new XSSFWorkbook(fin);
		XSSFSheet sheet = book.getSheet(sheetName);
		XSSFRow row = null;
		XSSFCell cel = null;
		Map<String, Object> map = null;
	
		
		row = sheet.getRow(0);
		String[] header = new String[row.getLastCellNum()];
		Object[][] data = new Object[sheet.getLastRowNum()][1];
		for(int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++){
			cel = row.getCell(j);
			header[j] = cel.getStringCellValue();
		}
		
		for(int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++){
			row = sheet.getRow(i);
			map = new LinkedHashMap<String, Object>();
			for(int j = row.getFirstCellNum(); j < 3; j++){
				cel = row.getCell(j);
				
				switch (cel.getCellType()) {
				case XSSFCell.CELL_TYPE_STRING:
					map.put(header[j], cel.getStringCellValue());
					break;

				case XSSFCell.CELL_TYPE_NUMERIC:
					map.put(header[j], cel.getNumericCellValue());
					break;
				}
			}
			data[i-1][0] = map;

		}
		fin.close();
		System.out.println("Data Provider");
		return data;
	}
	
	public static void UpdateToExcel(int colIndex,String srcFile,String destFile,String sheetName,ArrayList<String> status) throws IOException {
		String path = ReadExcelFile.class.getClassLoader().getResource("resource/").getPath();
		path = path.replaceAll("bin", "src");
		
		XSSFWorkbook book = new XSSFWorkbook(ReadExcelFile.class.getClassLoader().getResourceAsStream("resource/" + srcFile));
		XSSFSheet sheet = book.getSheet(sheetName);
		
		for(int i = 1; i <= sheet.getLastRowNum(); i++){
			XSSFRow row = sheet.getRow(i);
			XSSFCell cel = row.createCell(colIndex);
			cel.setCellValue(status.get(i - 1));
		}
		
		FileOutputStream fout = new FileOutputStream(new File(path + destFile));
		book.write(fout);
		fout.close();
	}
	
	public static void UpdateToExcel(int colIndex,int rowIndex,String srcFileName,String sheetName,String status) throws IOException {
		String path = ReadExcelFile.class.getClassLoader().getResource("resource/").getPath();
		path = path.replaceAll("bin", "src");
		
		FileInputStream fin = new FileInputStream(new File(path + srcFileName));
		
		XSSFWorkbook book = new XSSFWorkbook(fin);
		XSSFSheet sheet = book.getSheet(sheetName);
		
		XSSFRow row = sheet.getRow(rowIndex);
		XSSFCell cel = row.createCell(colIndex);
		cel.setCellValue(status);
		
		fin.close();
		
		FileOutputStream fout = new FileOutputStream(new File(path + srcFileName));
		book.write(fout);
		fout.close();
		
	}
	
}
