package Vtiger.CreateProduct;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Vtiger.GenericUtility.BaseClass;
import Vtiger.GenericUtility.DatabaseUtility;
import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.PropertyFileUtility;
import Vtiger.GenericUtility.WebDriverUtility;

public class CreateProduct1 extends BaseClass{
	public static void main(String[] args) throws IOException {
		
		DatabaseUtility d_Util = new DatabaseUtility();
		ExcelFileUtility e_Util = new ExcelFileUtility();
		JavaUtility j_Util = new JavaUtility();
		PropertyFileUtility p_Util = new PropertyFileUtility();
		WebDriverUtility w_Util = new WebDriverUtility();
		String br = p_Util.readDataFromProprtyFile("browserF");
		String url = p_Util.readDataFromProprtyFile("url");
		String un = p_Util.readDataFromProprtyFile("username");
		String pw = p_Util.readDataFromProprtyFile("password");
		String product_name = e_Util.readDataFromExcel("product", 1,2);
		String gl_Account = e_Util.readDataFromExcel("product", 4,3);
		WebDriver driver  = null;
		if(br.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(br.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(br.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
			
		}else {
			System.out.println("enter valid Browser");
		}
		w_Util.maximizeWindow(driver);
		w_Util.waiteForPageLoad(driver);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(product_name);
		driver.findElement(By.name("sales_start_date")).sendKeys("2021-05-25");
	//	driver.findElement(By.xpath("//img[@title='Select' and @alt='Select']")).click();
	//	w_Util.switchToWindow(driver, "Vendors&action");
		
		
	}
}
