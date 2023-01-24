package Vtiger.ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.PropertyFileUtility;
import Vtiger.GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndustryPom {

	public static void main(String[] args) throws IOException {
		// Step 1: Create Object Of all the required libraries
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();

		// step to extract data from excel
		String BROWSER = pUtil.readDataFromProprtyFile("browserC");
		String URL = pUtil.readDataFromProprtyFile("url");
		String USERNAME = pUtil.readDataFromProprtyFile("username");
		String PASSWORD = pUtil.readDataFromProprtyFile("password");
		
	//	String LASTNAME = eUtil.readDataFromExcel("contacts", 7, 2);
		String ORGNAME = eUtil.readDataFromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
		String industryName = eUtil.readDataFromExcel("Organization", 4, 3);
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
		if(OrgHeader.contains(ORGNAME)) {
			System.out.println(OrgHeader+"-->    PASS  ");
		}else {
			System.out.println(OrgHeader+"  FALI   <--");
		}
		// LogOut 
		hp.logOutApp(driver);
		
	}
}
