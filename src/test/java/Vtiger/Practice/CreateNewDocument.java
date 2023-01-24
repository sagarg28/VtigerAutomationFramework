package Vtiger.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Vtiger.GenericUtility.WebDriverUtility;

public class CreateNewDocument {
	
	public static void main(String[] args) {
		
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
		driver.findElement(By.linkText("Documents")).click();
		driver.findElement(By.xpath("//img[@alt='Create Document...' and @title='Create Document...']")).click();
		List<WebElement> size=driver.findElements(By.tagName("//iframe"));
		for(WebElement f : size) {
			
			System.out.println(f);
		}
	}
}
