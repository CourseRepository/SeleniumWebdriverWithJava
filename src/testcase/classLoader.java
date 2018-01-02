package testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author - rahul.rathore
 * @date - 16-Nov-2014
 */
public class classLoader {

	public static void main(String[] args) {
		String path = classLoader.class.getClassLoader().getResource("./").getPath();
		path = path.replaceAll("bin", "src");
	//	System.out.println(path);
		File f = new File(path + "../test-output/testng-results.xml");
		try {
			FileInputStream fin = new FileInputStream(f);
			byte buf[] = new byte[1024];
			fin.read(buf);
			String s = new String(buf);
			System.out.println(s);
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}
