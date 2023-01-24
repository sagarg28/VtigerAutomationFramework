package Vtiger.practice1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Vtiger.ObjectRepository.LoginPage;

public class PomclassPractice1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		LoginPage lp = new LoginPage(driver);
	//	lp.getUserNameEdt().sendKeys("admin");
	//	lp.getPasswordEdt().sendKeys("admin");
	//	lp.getSubmitBtn().click();
		lp.loginToApp("admin", "admin");      // Optimized code
		
		
			
	}
}
