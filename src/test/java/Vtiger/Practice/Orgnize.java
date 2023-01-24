package Vtiger.Practice;

import java.time.Duration;
import java.util.Random;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Orgnize {

	public static void main(String[] args) {
		// creating random user
		Random r = new Random();
		int num = r.nextInt(1000);
		String orgname = "SnsOrg";
		orgname = orgname+num;
		
		
		// To launching browser
		System.setProperty("webdriver.chrome.driver","C:\\A\\web driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Login
		driver.get("http://localhost:8888");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		// clicking on add org
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		// Adding org details
		driver.findElement(By.xpath("//input[@name='accountname' and @type='text']")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox' and @name='website']")).sendKeys("www.sns.com");
		driver.findElement(By.xpath("//input[@name='tickersymbol' and @id='tickersymbol']")).sendKeys("&");
		driver.findElement(By.xpath("//input[@name='employees' and @id='employees']")).sendKeys("1000");
		driver.findElement(By.xpath("//input[@name='phone' and @id='phone']")).sendKeys("56314796");
		driver.findElement(By.xpath("//input[@name='fax' and @id='fax']")).sendKeys("321-654");
		driver.findElement(By.xpath("//input[@name='otherphone' and @id='otherphone']")).sendKeys("32178546");
		driver.findElement(By.xpath("//input[@name='email1' and @id='email1']")).sendKeys("jda@gamil.com");
		driver.findElement(By.xpath("//input[@name='email2' and @id='email2']")).sendKeys("oli@gamil.com");
		driver.findElement(By.xpath("//input[@name='ownership' and @id='ownership']")).sendKeys("jiu546");
		// Industry dropdown Handling
		WebElement dd1 = driver.findElement(By.xpath("//select[@name='industry' and @class='small']"));
		Select s1 = new Select(dd1);
		//s1.selectByValue("Electronics");
		//s1.selectByValue("Chemicals"); 
		s1.selectByValue("Energy");
		WebElement dd2 = driver.findElement(By.xpath("//select[@name='accounttype' and @class='small']"));
		Select s2 = new Select(dd2);
		s2.selectByValue("Integrator");
		WebElement dd3 = driver.findElement(By.xpath("//select[@name='rating' and @class='small']"));
		Select s3 = new Select(dd3);
		s3.selectByValue("Active");
		driver.findElement(By.xpath("//input[@name='emailoptout' and @type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@name='siccode' and @id='siccode']")).sendKeys("3647");
		WebElement we1 = driver.findElement(By.xpath("//input[@name='annual_revenue' and @type='text']"));
		we1.clear();
		we1.sendKeys("264006");
		driver.findElement(By.xpath("//input[@name='assigntype' and @value='T']")).click();
		WebElement dd4 = driver.findElement(By.xpath("//select[@name='assigned_group_id' and @class='small']"));
		Select s4 = new Select(dd4);
		s4.selectByValue("4");
		driver.findElement(By.xpath("//input[@name='notify_owner' and @type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@name='cpy' and @type='radio']")).click();
		driver.findElement(By.xpath("//textarea[@name='bill_street' and @rows='2']")).sendKeys("jdjsl ksk ksks");
		driver.findElement(By.xpath("//textarea[@name='ship_street' and @rows='2']")).sendKeys("kuun ajguy ufka");
		driver.findElement(By.xpath("//input[@name='bill_pobox' and @id='bill_pobox']")).sendKeys("kuun ajguy ufka");
		driver.findElement(By.xpath("//input[@name='ship_pobox' and @id='ship_pobox']")).sendKeys("jksjksj uiuq fds");
		driver.findElement(By.xpath("//input[@name='bill_city' and @id='bill_city']")).sendKeys("banglore");
		driver.findElement(By.xpath("//input[@name='ship_city' and @id='ship_city']")).sendKeys("mysore");
		driver.findElement(By.xpath("//input[@name='bill_state' and @id='bill_state']")).sendKeys("karnataka");
		driver.findElement(By.xpath("//input[@name='ship_state' and @id='ship_state']")).sendKeys("UP");
		driver.findElement(By.xpath("//input[@name='bill_code' and @id='bill_code']")).sendKeys("4625");
		driver.findElement(By.xpath("//input[@name='ship_code' and @id='ship_code']")).sendKeys("97613");
		driver.findElement(By.xpath("//input[@name='bill_country' and @id='bill_country']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@name='ship_country' and @id='ship_country']")).sendKeys("china");
		driver.findElement(By.xpath("//textarea[@name='description' and @cols='90']")).sendKeys("hi there");
		driver.findElement(By.xpath("//input[@name='button' and @name='button']")).click();
		
		// To validate
		String	header = driver.findElement(By.className("dvHeaderText")).getText();
		if(header.contains(orgname)) {
			System.out.println("passed");
		}else
			System.out.println("failed");

		//Step 8: Logout of Application
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		








		






		

		




		
		
		






		
	}
}
