package helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class ReadConfigProperty implements ReadConfiguration {

	
	protected InputStream input = null;
	protected Properties prop = null;
	private static final Logger oLog = LoggerHelper.getLogger(ReadConfigProperty.class);
	
	public ReadConfigProperty() {
		try {
			String path = ReadConfigProperty.class.getClassLoader().getResource("./").getPath();
			path = path.replaceAll("bin", "src") + "resource" + System.getProperty("file.separator") +  "config" + System.getProperty("file.separator");
			//System.out.println("Path : " + path);
			input = new FileInputStream(path  + "config.properties");
			//input = ReadConfigProperty.class.getClassLoader().getResourceAsStream("resource/config.properties");
			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
			oLog.fatal(" IOException : ", e);
		}
	}
	
	public ReadConfigProperty(String fileName) {
		try {
			String path = ReadConfigProperty.class.getClassLoader().getResource("./").getPath();
			path = path.replaceAll("bin", "src") + "resource" + System.getProperty("file.separator") +  "config" + System.getProperty("file.separator");
			//System.out.println("Path : " + path);
			input = new FileInputStream(path + fileName);
			//input = ReadConfigProperty.class.getClassLoader().getResourceAsStream("resource/config.properties");
			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
			oLog.fatal(" IOException : ", e);
		}
	}
	
	@Override
	public String getUrl() {
		if(prop.getProperty("url") == null)
			return "";
		return prop.getProperty("url");
	}
	
	@Override
	public String getBrowser() {
		if(prop.getProperty("browser") == null)
			return "";
		return prop.getProperty("browser");
	}
	
	@Override
	public String getUsername() {
		if(prop.getProperty("Username") == null)
			return "";
		return prop.getProperty("Username");
	}
	
	@Override
	public String getPassword() {
		if(prop.getProperty("Password") == null)
			return "";
		return prop.getProperty("Password");
	}
	
	@Override
	public int getElementWait() {
		if(prop.getProperty("ElementWait") == null)
			return 0;
		return Integer.parseInt(prop.getProperty("ElementWait"));
	}
	
	@Override
	public int getPageWait() {
		if(prop.getProperty("PageLoadWait") == null)
			return 30;
		return Integer.parseInt(prop.getProperty("PageLoadWait"));
	}
	
	@Override
	public String getDbName() {
		if(prop.getProperty("DbName") == null)
			return "";
		return prop.getProperty("DbName");
	}
	
	@Override
	public String getDbUserName() {
		if(prop.getProperty("DbUserName") == null)
			return "";
		return prop.getProperty("DbUserName");
	}
	
	@Override
	public String getDbPassword() {
		if(prop.getProperty("DbPassword") == null)
			return "";
		return prop.getProperty("DbPassword");
	}
	
	@Override
	public String getHost() {
		if(prop.getProperty("DbHost") == null)
			return "";
		return prop.getProperty("DbHost");
	}
	
	public String getMethodName() {
		if(prop.getProperty("Mname") == null)
			return "";
		return prop.getProperty("Mname");
	}
	
	@Override
	public boolean isGridPresent() {
		if(prop.getProperty("Grid") == null)
			return false;
		return "true".equalsIgnoreCase(prop.getProperty("Grid"));
	}
	
	@Override
	public String getGridUrl() {
		if(prop.getProperty("GridUrl") == null)
			return "";
		return prop.getProperty("GridUrl");
	}

}
