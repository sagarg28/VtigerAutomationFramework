package Vtiger.Organization.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Vtiger.GenericUtility.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganizationTest extends BaseClass{

	@Test
	public void CreatContactWithOrgTest() throws EncryptedDocumentException, IOException {
		
		String LASTNAME = eUtil.readDataFromExcel("contacts", 7, 2);
		String ORGNAME = eUtil.readDataFromExcel("contacts", 7, 3)+jUtil.getRandomNumber();

	
		
		//Step 5: Navigate to Organizations Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 6: Click on Organizations look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 7: Create new organization and save
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8: Validate for Organization
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		
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
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		
		
	}
	}
	

