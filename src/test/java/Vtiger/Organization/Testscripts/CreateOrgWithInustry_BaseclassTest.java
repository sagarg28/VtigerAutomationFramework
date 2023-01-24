package Vtiger.Organization.Testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Vtiger.GenericUtility.BaseClass;
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

@Listeners(Vtiger.GenericUtility.ListenerImplimentationClass.class)
public class CreateOrgWithInustry_BaseclassTest extends BaseClass {

	@Test
	public void CreateOrgWithInustryTest() throws IOException {
	
			String ORGNAME = eUtil.readDataFromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
			String industryName = eUtil.readDataFromExcel("Organization", 4, 3);
	
			//Step 5: Navigate to Organizations Link
			HomePage hp = new HomePage(driver);
			hp.clickOnOrgLink();
			Reporter.log("----Organization Link Clicked");
					
			//Step 6: Click on Organizations look up image
			OrganizationPage op = new OrganizationPage(driver);
			op.clickOnCreateOrgLookUpImg();
			Reporter.log("Organization LookupImage clicked");
						
			//Step 7: Create new organization and save
			CreateNewOrganizationPage newOrg =new CreateNewOrganizationPage(driver);
			newOrg.createNewOrgWithIndustryDD(ORGNAME, industryName);
			Reporter.log("---Organization created-with IndustryName---"+ORGNAME);
					
			//Step 8: Validate for Organization
			OrganizationInfoPage oInfo = new OrganizationInfoPage(driver);
			String OrgHeader = oInfo.orgHeaderText();
			
			/*if(OrgHeader.contains(ORGNAME)) {
				System.out.println(OrgHeader+"-->    PASS  ");
			}else {
				System.out.println(OrgHeader+"  FALI   <--");
			}*/
			
			Assert.assertTrue(OrgHeader.contains(ORGNAME));
			Assert.fail();
			
			
	}		
}
