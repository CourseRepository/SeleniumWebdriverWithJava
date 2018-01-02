package helper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import net.sourceforge.htmlunit.corejs.javascript.ObjArray;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
@SuppressWarnings("unchecked")
public class DataProviderClass {
	
	/*@DataProvider(name="getLoginData")
	public static Object[][] getLoginData() throws IOException {
		return ReadExcelFile.getExcelData("Login.xlsx", "LoginDetails");
		
	}*/
	
	@DataProvider(name="getLoginData")
	public static Object[][] getLoginData() throws IOException {
		return ReadExcelFile.getExcelData("test.xlsx", "Logindetails");
		
	}
	
	@DataProvider(name="testValidLogin")
	public static Object[][] testValidLogin() throws IOException {
		return ReadExcelFile.getExcelData("TestLogin.xlsx", "LoginDetails");
		
	}
	
	@DataProvider(name="getExcelAndDbData")
	public static Object[][] getExcelAndDbData() throws IOException, SQLException {
		Object excel_data[][] = ReadExcelFile.getExcelData("TestLogin.xlsx", "LoginDetails"); //getting object array from excel file
		String colName[] = {"pyNodeName","pySystemName","pyRunState"};
		Object db_data[][] = DatabaseHelper.getDataBaseData("pr_sys_statusnodes", colName, ""); //getting object array from database file
		Object data[][] = new Object[excel_data.length][1]; 
		
		int j = 0;
		
		for(int i = 0; i < excel_data.length; i++){
			Map<String, String> excel_map = (Map<String, String>)excel_data[i][0]; 
			Map<String, String> db_map = (Map<String, String>)db_data[i][0];
			excel_map.putAll(db_map); // merging the map object to from a single map object
			data[j++][0] = excel_map; //storing merged map object back to Object array
		}
		
		return data;
	}
	
	@DataProvider(name="getUploadFileList")
	public static Object[][] getUploadFileList() {
		Object[][] name = new Object[4][1];
		name[0][0] = "G:\\Book_Link.txt";
		name[1][0] = "G:\\currencycodes.xml";
		name[2][0] = "G:\\testng-results.xml";
		name[3][0] = "G:\\HelloWorld.java";
		
		return name;
		
	}
	
	@Test(dataProvider="getExcelAndDbData")
	public void testCase(Map<String, String> h) {
		System.out.println(h.get("UserName") + " : " + h.get("Password") + " : " + h.get("Valid") + " : " + h.get("pyNodeName") + " : " + h.get("pySystemName") + " : " + h.get("pyRunState"));
	}
	
}
