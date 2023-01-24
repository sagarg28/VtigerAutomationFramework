package Vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.google.j2objc.annotations.Property;

public class PropertyFileUtility {

	/**
	 * this class consists of generic methods related to property files
	 * @throws IOException 
	 * @param key
	 * @ return
	 */
	
	public String readDataFromProprtyFile(String key) throws IOException
	{
		FileInputStream fis  = new FileInputStream(IConstantsUtility.PropertyFilePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		
		
		
		
		
	}
	
	
}
