package Vtiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromcmdLineTest {

	@Test
	public void readData() {
		
		String BROWSER = System.getProperty("browser");		// it will accept running
		System.out.println(BROWSER);
		
		String URL = System.getProperty("url");
		System.out.println(URL);
		
		String USERNAME = System.getProperty("username");
		System.out.println(USERNAME);
		
		String PASSWORD = System.getProperty("password");
		System.out.println(PASSWORD);
	}
}
