package testcase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class TestJavaPropertiesFile {
	
	@SuppressWarnings("serial")
	public static void main(String[] args) throws IOException {
		String fileName = "C:\\Data\\New folder\\config.properties";
		File propFile = null;
		Properties aConfig = null;
		FileOutputStream outPutStream = null;
		
		try {
			propFile = getPropertyFile(fileName);
			HashMap<String, String> data = new HashMap<String,String>(){
			{
				put("KeyOne", "Value One");
				put("KeyTwo", "Value Two");
				put("KeyThree", "Value Three");
				put("KeyFour", "Value Four");
			}};
			
			aConfig = insertProperty(data);
			if(null != propFile){
				outPutStream = new FileOutputStream(propFile);
				aConfig.store(outPutStream, "Log4j Property File via code");
			}
				
		} finally {
			if(outPutStream != null)
				outPutStream.close();
		}
	}
	
	private static Properties insertProperty(HashMap<String, String> data){
		Properties aConfig = new Properties();
		if(!(null == data || data.isEmpty())){
			for (String key : data.keySet()) {
				aConfig.setProperty(key, data.get(key));
			}
		}
		return aConfig;
	}
	
	private static File getPropertyFile(String fileName) throws IOException{
		File propFile = new File(fileName);
		if(!propFile.exists())
			propFile.createNewFile();
		else{
			propFile.delete();
			propFile.createNewFile();
		}
		return propFile;
	}

}
