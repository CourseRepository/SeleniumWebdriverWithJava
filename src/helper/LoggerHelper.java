/**
 * 
 */
package helper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.testng.ISuite;

/**
 * @author - rahul.rathore
 * @date - 10-Feb-2015
 * @project - Webdriver
 * @package - helper
 * @file name - LoggerHelper.java
 */
public class LoggerHelper {
	
	private static PatternLayout layout = null;
	private static ConsoleAppender console = null;
	//private static RollingFileAppender rolling = null;
	private static DailyRollingFileAppender daily = null;
	private static Logger rootLogger = null;
	private static Logger logger = null;
	private static final String pattern = "%d{yyyy-MM-dd HH:mm:ss} %-5p [%c{1}] - [%M] %m%n"; 
	private static boolean flag = false;
	private static final String datePattern = ".yyyy-MM-dd-HH";
	
	private static String getFolderName() {
		String path = LoggerHelper.class.getClassLoader().getResource("./" ).getPath();
		path = path.replaceAll("bin", "src");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		return path + "log" + System.getProperty("file.separator") + dateFormat.format(cal.getTime());
		
	}
	
	private static void initLogger() {
		 layout = new PatternLayout(pattern);
		 
		 /*Console Appender*/
		 console = new ConsoleAppender(layout);
		 console.setName("STDOUT");
		 console.setTarget("System.out");
		 console.setThreshold(Level.INFO);
		 console.activateOptions();
		 
		 /* Daily Rolling File Appender */
		 
		 try {
			 
			 daily = new DailyRollingFileAppender(layout, getFolderName() + System.getProperty("file.separator") + "info.log", datePattern);
			 daily.setName("DFILE");
			 daily.setThreshold(Level.INFO);
			 daily.setAppend(true);
			 daily.activateOptions();
			 
			/*rolling = new RollingFileAppender(layout, "log/Selenium_logFile.log");
			rolling.setName("RFILE");
			rolling.setThreshold(Level.INFO);
			rolling.setMaxFileSize("25MB");
			rolling.setMaxBackupIndex(100);
			rolling.activateOptions();*/
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* Root Logger */
		 rootLogger = Logger.getRootLogger();
		 rootLogger.addAppender(console);
		 //rootLogger.addAppender(rolling);
		 rootLogger.addAppender(daily);
	}
	
	public static Logger getLogger(Class aClass) {
		if(!flag){
			initLogger();
			flag = true;
			LoggerHelper.logger = Logger.getLogger(aClass);
			return LoggerHelper.logger;
		}else{
			LoggerHelper.logger = Logger.getLogger(aClass);
			return LoggerHelper.logger;
		}
		
	}
}
