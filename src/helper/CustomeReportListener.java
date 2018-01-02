package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class CustomeReportListener implements ISuiteListener, ITestListener {

	private FileOutputStream fout = null;
	private FileInputStream fin = null;
	private XSSFWorkbook book = null;
	private XSSFSheet sheet = null;
	private IResultMap pass = null;
	private IResultMap fail = null;
	private Collection<ITestNGMethod> pass_method_name = null;
	private Set<ITestResult> pass_method_status = null;
	private Collection<ITestNGMethod> fail_method_name = null;
	private Set<ITestResult> fail_method_status = null;
	private Iterator<ITestNGMethod> method_iterator = null;
	private Iterator<ITestResult> status_iterator = null;
	private String time = "";
	private XSSFCellStyle pass_style = null;
	private XSSFCellStyle fail_style = null;
	private static final Logger oLog = LoggerHelper.getLogger(CustomeReportListener.class);

	private String getPath() {
		String path = CustomeReportListener.class.getClassLoader()
				.getResource("./").getPath();
		path = path.replaceAll("bin", "src");
		return path;
	}

	@Override
	public void onFinish(ITestContext arg0) {
		
		String path = getPath() + "reports" + System.getProperty("file.separator") + time + arg0.getSuite().getName() + ".xlsx";
		File xl_file = new File(path);
		
		String imagePath = "file:" + getPath() + "screenshot" + System.getProperty("file.separator");
		imagePath = imagePath.replaceAll("/", "///");
		imagePath = imagePath.substring(0, (imagePath.length() -1));
		
		//System.out.println("Image Path : " + imagePath);
		
		pass = arg0.getPassedTests();
		fail = arg0.getFailedTests();
		
		pass_method_name = pass.getAllMethods();
		pass_method_status = pass.getAllResults();
		
		fail_method_name = fail.getAllMethods();
		fail_method_status = fail.getAllResults();

		try {
			if (xl_file.exists()) {
				fin = new FileInputStream(xl_file);
				book = new XSSFWorkbook(fin);
				fout = new FileOutputStream(path);
			} else {
				fout = new FileOutputStream(path);
				book = new XSSFWorkbook();
			}
			
			pass_style = book.createCellStyle();
			fail_style = book.createCellStyle();
			
			pass_style.setFillForegroundColor(HSSFColor.BRIGHT_GREEN.index);
			pass_style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			
			fail_style.setFillForegroundColor(HSSFColor.RED.index);
			fail_style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			
			
			sheet = book.createSheet(arg0.getName());
			
			method_iterator = pass_method_name.iterator();
			status_iterator = pass_method_status.iterator();
			
			int index = 0;

			while (method_iterator.hasNext() && status_iterator.hasNext()) {
				ITestNGMethod iTestNGMethod = (ITestNGMethod) method_iterator.next();
				
				XSSFRow row = sheet.createRow(index++);
				XSSFCell name_cel = row.createCell(0);
				name_cel.setCellValue(iTestNGMethod.getTestClass().getName() + "." + iTestNGMethod.getMethodName());
				
				XSSFCell status_cell = row.createCell(1);
				status_cell.setCellValue("Pass");
				status_cell.setCellStyle(pass_style);
			}
			
			method_iterator = fail_method_name.iterator();
			status_iterator = fail_method_status.iterator();
			
			while (method_iterator.hasNext() && status_iterator.hasNext()) {
				ITestNGMethod iTestNGMethod = (ITestNGMethod) method_iterator.next();
				ITestResult iTestResult = (ITestResult) status_iterator.next();
				
				XSSFRow row = sheet.createRow(index++);
				XSSFCell name_cel = row.createCell(0);
				name_cel.setCellValue(iTestNGMethod.getTestClass().getName() + "." + iTestNGMethod.getMethodName());
				
				XSSFCell status_cell = row.createCell(1);
				status_cell.setCellValue("Fail");
				status_cell.setCellStyle(fail_style);
				
				XSSFCell exp_cel = row.createCell(2);
				exp_cel.setCellValue(iTestResult.getThrowable().getMessage());
				
				CreationHelper createHelper = book.getCreationHelper();
				Hyperlink link = createHelper.createHyperlink(Hyperlink.LINK_FILE);
				XSSFCell pic_cell = row.createCell(3);
				pic_cell.setCellValue("Click Here for ScreenShot");
				
				link.setAddress(imagePath + "///" + iTestNGMethod.getTestClass().getName() + "." + iTestNGMethod.getMethodName() + ".jpg");
				pic_cell.setHyperlink((org.apache.poi.ss.usermodel.Hyperlink) link);
				
			}
			
			book.write(fout);


		} catch (Exception e) { 
			e.printStackTrace(); 
			oLog.fatal(" Exception : ", e);
		}finally{
			try {
				if(fin != null)
					fin.close();
				if(fout != null)
					fout.close();
				if(book != null)
					book = null;
			} catch (Exception e2) {
				e2.printStackTrace();
				oLog.fatal(" Exception : ", e2);
			}
		}
	}

	@Override
	public void onStart(ITestContext arg0) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		GenericHelper.takeMultipleScreeShot(arg0.getTestClass().getName() + "." + arg0.getMethod().getMethodName());
		ButtonHelper.clickLogout();
		oLog.error(" Test Failed : ", arg0.getThrowable());

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		oLog.warn(arg0.getName() + " Skipped ");

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		oLog.info(arg0.getName() + " Started ");

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		oLog.info(arg0.getName() + " Success ");

	}

	@Override
	public void onFinish(ISuite arg0) {
		oLog.info(arg0.getName() + " Finish ");
	}

	@Override
	public void onStart(ISuite arg0) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_");
		Calendar cal = Calendar.getInstance();
		time = "" + dateFormat.format(cal.getTime());
		
	}

}
