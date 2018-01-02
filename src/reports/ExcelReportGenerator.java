package reports;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class ExcelReportGenerator {
		
	public void generateReport(String folderName,String fileName) throws ParserConfigurationException, IOException, SAXException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_");
		Calendar cal = Calendar.getInstance();

		String time = "" + dateFormat.format(cal.getTime());
		
		String path = ExcelReportGenerator.class.getClassLoader().getResource("./").getPath();
		path = path.replaceAll("bin", "src");

		File xmlFile = new File(path + "../" + folderName + "/testng-results.xml");
		
		FileOutputStream report_file = new FileOutputStream(new File(path + "reports/" + time + fileName));
		XSSFWorkbook book = new XSSFWorkbook();
		
		
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		DocumentBuilder build = fact.newDocumentBuilder();
		Document doc = build.parse(xmlFile);
		doc.getDocumentElement().normalize();
		NodeList list = doc.getElementsByTagName("test"); //for getting test node
		
		XSSFCellStyle s1 = book.createCellStyle();
		XSSFCellStyle s2 = book.createCellStyle();
		for(int s = 0; s < list.getLength(); s++){
			
			Node test_suite = list.item(s);
			String test_suite_name = ((Element)test_suite).getAttribute("name");
			NodeList class_node_list = ((Element)test_suite).getElementsByTagName("class");
			//for getting the class node
			XSSFSheet sheet = book.createSheet(test_suite_name);
			int i = 0;
			for(int j = 0; j < class_node_list.getLength(); j++){
				
				Node class_node = class_node_list.item(j);
				String class_name = ((Element)class_node).getAttribute("name");
				NodeList test_method_list = ((Element)class_node).getElementsByTagName("test-method");
				//for getting the list of test method
				
				for(int k = 0; k < test_method_list.getLength(); k++){
					Node test_method_node = test_method_list.item(k);
					String test_method_name = ((Element)test_method_node).getAttribute("name");
					String test_method_status = ((Element)test_method_node).getAttribute("status");
					//System.out.println("Test Suite : " + test_suite_name + " -- Class Name : " + class_name + " -- Method Name : " + test_method_name);
					s1.setFillForegroundColor(HSSFColor.BRIGHT_GREEN.index);
					s2.setFillForegroundColor(HSSFColor.RED.index);
					s1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
					s2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
					
					XSSFRow row = sheet.createRow(i++);
					XSSFCell name = row.createCell(0);
					name.setCellValue(class_name + "." + test_method_name);
					XSSFCell stat = row.createCell(1);
					
					if("fail".equalsIgnoreCase(test_method_status)){
						stat.setCellStyle(s2);
					}else{
						stat.setCellStyle(s1);
					}
		
					stat.setCellValue(test_method_status);
					
					String exp_message = "";
					XSSFCell exp_cel;
					
					
					if("fail".equalsIgnoreCase(test_method_status)){
						NodeList exp_node_list = ((Element)test_method_node).getElementsByTagName("exception");
						Node exp_node = exp_node_list.item(0);
						exp_message = ((Element)exp_node).getAttribute("class");
						exp_cel = row.createCell(2);
						exp_cel.setCellValue(exp_message);
					}
				}
				
			}
		}
		book.write(report_file);
		report_file.close();
		//System.out.println("Report Generated : " + path + "reports/" + time + fileName);
	}

	public static void main(String[] args) {
		ExcelReportGenerator xls = new ExcelReportGenerator();
		String name[] = args[0].split(",");
		try {
			for(int i = 0; i < name.length; i++)
				xls.generateReport(name[i],"Excel_Report.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
