package helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.csvreader.CsvReader;

public class ReadCSVProperties implements ReadConfiguration {
	
	private Map<String, String> configMap = null;
	private CsvReader read = null;
	private static final Logger oLog = LoggerHelper.getLogger(ReadCSVProperties.class);
	
	private String getPath() {
		String path = ReadCSVProperties.class.getClassLoader().getResource("resource/config").getPath();
		path = path.replaceAll("bin", "src");
		return path;
	}
	
	public ReadCSVProperties(){
		String filePath = getPath() + System.getProperty("file.separator") + "config.csv";
		try {
				read = new CsvReader(filePath);
				read.setSkipEmptyRecords(true);
				read.setComment('#');
				read.setUseComments(true);
				configMap = getCSVData(read);
				read.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				oLog.fatal(" FileNotFoundException : ", e);
			} catch (IOException e) {
				e.printStackTrace();
				oLog.fatal(" IOException : ", e);
		}
		
	}

	private Map<String, String> getCSVData(CsvReader read2) throws IOException {
		Map<String, String> data = new LinkedHashMap<String, String>();
		
		while(read2.readRecord())
			data.put(read2.get(0),read2.get(1));

		return data;
	}

	@Override
	public String getUrl() {
		if(configMap.get("url") == null)
			return "";
		return configMap.get("url");
	}

	@Override
	public String getBrowser() {
		if(configMap.get("browser") == null)
			return "";
		return configMap.get("browser");
	}

	@Override
	public String getUsername() {
		if(configMap.get("Username") == null)
			return "";
		return configMap.get("Username");
	}

	@Override
	public String getPassword() {
		if(configMap.get("Password") == null)
			return "";
		return configMap.get("Password");
	}

	@Override
	public int getElementWait() {
		if(configMap.get("ElementWait") == null)
			return 0;;
		return Integer.parseInt(configMap.get("ElementWait"));
	}

	@Override
	public int getPageWait() {
		if(configMap.get("PageLoadWait") == null)
			return 0;;
		return Integer.parseInt(configMap.get("PageLoadWait"));
	}

	@Override
	public String getDbName() {
		if(configMap.get("DbName") == null)
			return "";
		return configMap.get("DbName");
	}

	@Override
	public String getDbUserName() {
		if(configMap.get("DbUserName") == null)
			return "";
		return configMap.get("DbUserName");
	}

	@Override
	public String getDbPassword() {
		if(configMap.get("DbPassword") == null)
			return "";
		return configMap.get("DbPassword");
	}

	@Override
	public String getHost() {
		if(configMap.get("DbHost") == null)
			return "";
		return configMap.get("DbHost");
	}

	
	@Override
	public boolean isGridPresent() {
		if(configMap.get("Grid") == null)
			return false;
		return Boolean.valueOf(configMap.get("Grid"));
	}

	
	@Override
	public String getGridUrl() {
		if(configMap.get("Grid") == null)
			return "";
		return configMap.get("Grid");
	}
	
}
