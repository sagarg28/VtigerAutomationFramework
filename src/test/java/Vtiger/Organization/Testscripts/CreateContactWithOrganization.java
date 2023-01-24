package Vtiger.Organization.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.PropertyFileUtility;
import Vtiger.GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganization {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
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
		
		String LASTNAME = eUtil.readDataFromExcel("contacts", 7, 2);
		String ORGNAME = eUtil.readDataFromExcel("contacts", 7, 3)+jUtil.getRandomNumber();

		// Step 3: Launch the browser
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
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 5: Navigate to Organizations Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 6: Click on Organizations look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 7: Create new organization and save
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8: Validate for Organization
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader);
			System.out.println("Organization successfully created");
		}
		else
		{
			System.out.println("Organization not created");
		}
		
		//Step 9: Navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 10: Click on create contact look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step 11: Create new Contact
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//Step 12: Choose the Organization 
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		wUtil.switchToWindow(driver,"Accounts");
		                                                     //wipro227
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		                              // dynamic xpath //a[text()='wipro227']
		
		wUtil.switchToWindow(driver, "Contacts");
		
		//Step 13: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 14: Validate
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ContactHeader.contains(LASTNAME))
		{
			System.out.println(ContactHeader);
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Step 15: logout of App
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
}
