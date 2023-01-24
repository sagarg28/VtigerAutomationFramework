package Vtiger.CreateContact.Testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.PropertyFileUtility;
import Vtiger.GenericUtility.WebDriverUtility;
import Vtiger.ObjectRepository.CreateContactInfoPage;
import Vtiger.ObjectRepository.CreateContactPage;
import Vtiger.ObjectRepository.CreateNewContactPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateContactWithPOM {

	@Test
	
	public void CreateContactTest() throws IOException {
		
		// Step 1: Create Object Of all the required libraries
				JavaUtility jUtil = new JavaUtility();
				WebDriverUtility wUtil = new WebDriverUtility();
				PropertyFileUtility pUtil = new PropertyFileUtility();
				ExcelFileUtility eUtil = new ExcelFileUtility();

				// step to extract data from prop and excel
				String BROWSER = pUtil.readDataFromProprtyFile("browserF");
				String URL = pUtil.readDataFromProprtyFile("url");
				String USERNAME = pUtil.readDataFromProprtyFile("username");
				String PASSWORD = pUtil.readDataFromProprtyFile("password");
				
			//	String LASTNAME = eUtil.readDataFromExcel("contacts", 7, 2);
				String lastName = eUtil.readDataFromExcel("contacts", 4, 2)+jUtil.getRandomNumber();
				String leadSourceName = eUtil.readDataFromExcel("contacts", 4, 3);
				//Launch Browser
				WebDriver driver = null;

				if (BROWSER.equalsIgnoreCase("chrome")) {
					//WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				} else if (BROWSER.equalsIgnoreCase("Firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				} else {
					System.out.println("invalid browser name");
				}
				wUtil.maximizeWindow(driver);
				wUtil.waiteForPageLoad(driver);
				driver.get(URL);
				
			//Login to App
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			
			// click on contacts in home page
			HomePage hp = new HomePage(driver);
			hp.clickOnContactLink();
			
			//click on lookup image
			CreateContactPage cp = new CreateContactPage(driver);
			cp.clickOnNewContact();
			
			// Enter new contact contact info
			CreateNewContactPage cnp = new CreateNewContactPage(driver);
			cnp.createNewContact(lastName, leadSourceName);
			
			// validation
			CreateContactInfoPage cinf = new CreateContactInfoPage(driver);
			String headerText = cinf.HeaderText();
			Assert.assertTrue(headerText.contains(lastName));
			
			//LogOut App
			hp.logOutApp(driver);
				
	}
}
