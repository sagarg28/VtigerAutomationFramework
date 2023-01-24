package Vtiger.Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllInOne {

	
	public static void main(String[] args) throws InterruptedException, AWTException {
		  System.setProperty("webdriver.chrome.driver","C:\\A\\web driver\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://www.irctc.co.in/nget/train-search");
		  driver.manage().window().maximize();
		  Dimension d=new Dimension(1000,1000);
		  driver.manage().window().setSize(d);
		  driver.manage().window().maximize();
		  Point p=new Point(1000,100);
		  driver.manage().window().setPosition(p);
		  Navigation nav=driver.navigate();
		  driver.manage().window().maximize();
		  driver.get("https://chromedriver.chromium.org/");
		  nav.back();
		  nav.refresh();
		  driver.findElement(By.xpath("(//input[@aria-autocomplete='list'])[1]")).click();
		  //driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).sendKeys("Hyderabad");
		  Robot r= new Robot();
		  r.keyPress(KeyEvent.VK_PAGE_DOWN);
		  r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		  r.keyPress(KeyEvent.VK_ENTER);
		  r.keyRelease(KeyEvent.VK_ENTER);
		  driver.findElement(By.xpath("(//input[@type='text'])[3]")).click();
		  driver.findElement(By.xpath("//a[@draggable='false']")).click();
		  String s=driver.findElement(By.xpath("//div[@class='ng-trigger ng-trigger-overlayAnimation ng-tns-c57-8 ui-autocomplete-panel ui-widget ui-widget-content ui-corner-all ui-shadow ng-star-inserted']")).getText();
		  
		  
		  
		  
		  
		  Thread.sleep(3000);
		  //driver.close();
}
}
