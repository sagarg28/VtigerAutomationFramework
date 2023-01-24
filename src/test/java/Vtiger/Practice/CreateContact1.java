package Vtiger.Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Vtiger.GenericUtility.WebDriverUtility;

public class CreateContact1 {

	//Tc-contacts-01
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		//Step 1: Launch the browser
		WebDriverUtility wd = new WebDriverUtility();
		System.setProperty("webdriver.chrome.driver","C:\\A\\web driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		wd.maximizeWindow(driver);
		wd.waiteForPageLoad(driver);
		// login to application
		driver.get("http://localhost:8888");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		// //Step 5: create Contact with mandatory fields
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		Select s = new Select(dropdown);
		s.selectByValue("Mr.");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Jhon");
		driver.findElement(By.xpath("//input[@name = 'lastname']")).sendKeys("Dolton");
		
		WebElement dd2 = driver.findElement(By.xpath("//select[@name='leadsource']"));
		wd.handleDropDown(dd2, "Employee");
		
		driver.findElement(By.xpath("//input[@name='title' and @id='title']")).sendKeys("sns");
		driver.findElement(By.xpath("//input[@name='department' and @id='department']")).sendKeys("sales");
		driver.findElement(By.xpath("//input[@name='email' and @id='email']")).sendKeys("xyz@gmail.com");
		driver.findElement(By.xpath("//input[@name='assistant' and @id='assistant']")).sendKeys("yes");
		driver.findElement(By.xpath("//input[@name='assistantphone' and @id='assistantphone']")).sendKeys("46325789");
		driver.findElement(By.xpath("//input[@name='emailoptout' and @type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@name='reference' and @type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@name='notify_owner' and @type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@name='phone' and @id='phone']")).sendKeys("02046578");
		driver.findElement(By.xpath("//input[@name='mobile' and @id='mobile']")).sendKeys("98745632");
		driver.findElement(By.xpath("//input[@name='homephone' and @id='homephone']")).sendKeys("83647531");
		driver.findElement(By.xpath("//input[@name='otherphone' and @id='otherphone']")).sendKeys("02046578");
		driver.findElement(By.xpath("//input[@name='fax' and @id='fax']")).sendKeys("324-658-554");
		driver.findElement(By.xpath("//input[@name='birthday' and @type='text']")).sendKeys("1995-06-21");
		driver.findElement(By.xpath("//input[@name='secondaryemail' and @id='secondaryemail']")).sendKeys("adf@email.com");
		driver.findElement(By.xpath("//input[@name='donotcall' and @type='checkbox']")).sendKeys("02046578");
		driver.findElement(By.xpath("//input[@name='assigntype' and @value='T']")).click();
		WebElement dd3 = driver.findElement(By.name("assigned_group_id"));
		Select s2 = new Select(dd3);
		s2.selectByValue("2");
		driver.findElement(By.xpath("//input[@name='portal' and @type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@name='support_start_date' and @type='text']")).clear();
		driver.findElement(By.xpath("//input[@name='support_start_date' and @type='text']")).sendKeys("2014-03-26");
		driver.findElement(By.xpath("//input[@name='support_end_date' and @type='text']")).clear();
		driver.findElement(By.xpath("//input[@name='support_end_date' and @type='text']")).sendKeys("2022-05-27");
		driver.findElement(By.xpath("//input[@name='cpy' and @type='radio']")).click();
		
		driver.findElement(By.xpath("//textarea[@name='mailingstreet' and @class='detailedViewTextBox']")).sendKeys("mjs-545");
		driver.findElement(By.xpath("//textarea[@name='otherstreet' and @rows='2']")).sendKeys("laokf9484-ghg0henjh h dh kflh");
		driver.findElement(By.xpath("//input[@name='mailingpobox' and @id='mailingpobox']")).sendKeys("1234-446");
		driver.findElement(By.xpath("//input[@name='otherpobox' and @id='otherpobox']")).sendKeys("954-865");
		driver.findElement(By.xpath("//input[@name='mailingcity' and @id='mailingcity']")).sendKeys("Nevada");
		driver.findElement(By.xpath("//input[@name='othercity' and @id='othercity']")).sendKeys("Seattle");
		driver.findElement(By.xpath("//input[@name='mailingstate' and @id='mailingstate']")).sendKeys("Deteroit");
		driver.findElement(By.xpath("//input[@name='otherstate' and @id='otherstate']")).sendKeys("Honalulu");
		driver.findElement(By.xpath("//input[@name='mailingzip' and @id='mailingzip']")).sendKeys("56476");
		driver.findElement(By.xpath("//input[@name='otherzip' and @id='otherzip']")).sendKeys("931495");
		driver.findElement(By.xpath("//input[@name='mailingcountry' and @id='mailingcountry']")).sendKeys("USA");
		driver.findElement(By.xpath("//input[@name='othercountry' and @id='othercountry']")).sendKeys("India");
		driver.findElement(By.xpath("//textarea[@name='description' and @cols='90']")).sendKeys("hsdjhjsahdsadh");
		
		driver.findElement(By.xpath("//input[@name='imagename' and @type='file']")).sendKeys("C:\\Qspider docs 072022\\projest paint.png");
		driver.findElement(By.xpath("//input[@name='button' and @type='submit']")).click();
	//	driver.findElement(By.xpath("//img[@border='0' and @style='padding: 0px;padding-left:5px']")).click();
	//	driver.findElement(By.linkText("Sign Out")).click();


		//Step 7: Validate
				String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(contactHeader.contains("Dolton Jhon"))
				{
					System.out.println(contactHeader);
					System.out.println("PASS");
				}
				else
				{
					System.out.println("FAIL");
				}
				
				//Step 8: Logout of Application
				WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act = new Actions(driver);
				act.moveToElement(element).perform();
				driver.findElement(By.linkText("Sign Out")).click();





		




		

		


		
		


		
		
		
		




		
	}
}
