package Vtiger.GenericUtility;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.PropertyFileUtility;
import Vtiger.GenericUtility.WebDriverUtility;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver;  // This is for taking screenshot
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("==== Database Connection successful ====");
	}
	
	@BeforeClass
	public void bcConfig() throws IOException
	{
		String BROWSER = pUtil.readDataFromProprtyFile("browserC");
		String URL = pUtil.readDataFromProprtyFile("url");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {

			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("===="+BROWSER+" Launch successful=====");
			sdriver = driver;

		} else if (BROWSER.equalsIgnoreCase("Firefox")) {

			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("===="+BROWSER+" Launch successful=====");
			sdriver = driver;

		} else {
			System.out.println("invalid browser name");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waiteForPageLoad(driver);
		driver.get(URL);
		
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromProprtyFile("username");
		String PASSWORD = pUtil.readDataFromProprtyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("==== login successful =====");
	}
	
	@AfterMethod
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.logOutApp(driver);
		System.out.println("==== logout successful ====");
	}
	
	@AfterClass
	public void acConfig()
	{
		driver.quit();
		System.out.println("==== browswer Closed =====");
	}
	
	
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("==== Database Connection closed ====");
	}
}
