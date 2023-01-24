package Vtiger.Organization.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.PropertyFileUtility;
import Vtiger.GenericUtility.WebDriverUtility;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateMultipleOrg {
	
	// Step 1: Create Object Of all the required libraries
				JavaUtility jUtil = new JavaUtility();
				WebDriverUtility wUtil = new WebDriverUtility();
				PropertyFileUtility pUtil = new PropertyFileUtility();
				ExcelFileUtility eUtil = new ExcelFileUtility();

		@Test(dataProvider = "OrgName")		
		public void createMultiOrgTest(String ORG,String industryName) throws IOException {
			
			String ORGNAME = ORG+jUtil.getRandomNumber();
			// step to extract data from excel
			String BROWSER = pUtil.readDataFromProprtyFile("browserC");
			String URL = pUtil.readDataFromProprtyFile("url");
			String USERNAME = pUtil.readDataFromProprtyFile("username");
			String PASSWORD = pUtil.readDataFromProprtyFile("password");
			
	    	
			WebDriver driver = null;

			if (BROWSER.equalsIgnoreCase("chrome")) {
				//WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (BROWSER.equalsIgnoreCase("Firefox")) {
				//WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(); 
			} else {
				System.out.println("invalid browser name");
			}

			wUtil.maximizeWindow(driver);
			wUtil.waiteForPageLoad(driver);
			driver.get(URL);
			
			// Step 4: Login to App
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
					
			//Step 5: Navigate to Organizations Link
			HomePage hp = new HomePage(driver);
			hp.clickOnOrgLink();
					
			//Step 6: Click on Organizations look up image
			OrganizationPage op = new OrganizationPage(driver);
			op.clickOnCreateOrgLookUpImg();
						
			//Step 7: Create new organization and save
			CreateNewOrganizationPage newOrg =new CreateNewOrganizationPage(driver);
			newOrg.createNewOrgWithIndustryDD(ORGNAME, industryName);
					
			//Step 8: Validate for Organization
			OrganizationInfoPage oInfo = new OrganizationInfoPage(driver);
			String OrgHeader = oInfo.orgHeaderText();
			Assert.assertTrue(OrgHeader.contains(ORGNAME));
			// LogOut 
			hp.logOutApp(driver);
			driver.close();
			
		}
		
		
		@DataProvider(name = "OrgName")
		public Object[][] getData() throws EncryptedDocumentException, IOException{
			Object[][] data = eUtil.readMultipleData("MultipleOrg");
			return data;
		}
	
}
