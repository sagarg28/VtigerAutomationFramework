package Vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		
		//step 1 Read the file in java reagable format using fileinputstream
		FileInputStream fis = new FileInputStream("\\src\\test\\resources\\CommonData.properties");
		//step 2 Create object of properties class from java.util package
		Properties pobj = new Properties();
		// step-3 load the file input stream
		pobj.load(fis);
		// step 4 provide the key and read the value
		String URL = pobj.getProperty("url");
		System.out.println(URL);
		
		String BROWSER = pobj.getProperty("browser");
		System.out.println(BROWSER);
	}
}
