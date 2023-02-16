package Vtiger.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/*
	 * This method will maximize the window
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void minmizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	public void waiteForPageLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void waiteForElementToBEVisible(WebDriver driver,WebElement element) {
		
		WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(10));
		waite.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void handleDropDown(WebElement element,int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public void handleDropDown(WebElement element,String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public void handleDropDown(String visibleText,WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}
	
	public void mouseHoverAction(WebDriver driver,WebElement element) {
		
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	//perform double click on anyware on page
	//parameter driver
	public void doubleClickAction(WebDriver driver) {
		
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	// This is to click on specific element
	public void doubleClickAction(WebDriver driver,WebElement element) {
		
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
		
	}
	// right click on anyware on page
	public void rightClickAction(WebDriver driver) {
		
		Actions act = new Actions(driver);
		act.contextClick().perform();

	}
	
	// right click on particular element on page
		public void rightClickAction(WebDriver driver,WebElement element) {
			
			Actions act = new Actions(driver);
			act.contextClick(element).perform();

		}
		
		//	This method will perform drag and drop action from source to destination
		public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement dstnElement)
		{
			Actions act = new Actions(driver);
			act.dragAndDrop(srcElement, dstnElement).perform();
		}
		
	//This method will switch to frame based on the index
	public void swithchToFrame(WebDriver driver,int frameIndex) {
		
		driver.switchTo().frame(frameIndex);
		
	}
	
	public void swithchToFrame(WebDriver driver,String frameIDorName) {
		
		driver.switchTo().frame(frameIDorName);
	}
	
	public void swithchToFrame(WebDriver driver,WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	// This method will switch back to immediate parent frame
	public void swithchToParentFrame(WebDriver driver) {
		
		driver.switchTo().parentFrame();
	}
	
	// This method will switch back to default frame
	public void swithchToDefaultContent(WebDriver driver) {
		
		driver.switchTo().defaultContent();
	}
	
	public void acceptAlert(WebDriver driver) {
		
		driver.switchTo().alert().accept();
	}
	
	public void dismisAlert(WebDriver driver) {
		
		driver.switchTo().alert().dismiss();
	}
	
	public void getAlertText(WebDriver driver) {
		
		driver.switchTo().alert().getText();
	}
	
	public void switchToWindow(WebDriver driver,String partialWinTitle ) {
		
		//Step 1: capture all the window IDs
		Set<String> winIds = driver.getWindowHandles();
		
		//Step 2: extract indivifual window ID
		for(String winID:winIds) {
			
			//Step 3: capture the currentwindow Title
			String currentTitle = 	driver.switchTo().window(winID).getTitle();
			
			
			//Step 4:compare the current window title with required title
			if(currentTitle.contains(partialWinTitle));
			System.out.println(currentTitle);
			//break;
		}
		}
		
		//This method will take screenshot and store it in a folder
		public String takeScreenShot(WebDriver driver,String ScreenShotsName) throws IOException {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src  = ts.getScreenshotAs(OutputType.FILE);
		//	File dst = new File(".\\ScreenShots\\"+ScreenShotsName+".png");
			File dst = new File("/job/WPAM-4smokesuite/ws/ScreenShots/CreateOrgWithInustryTest-11%20Jan%202023%2008-25-55.png");
			FileUtils.copyFile(src, dst); // from commons io dependency
			
			return dst.getAbsolutePath(); // for extent reports
		
		}
		
		// This method will scroll downwards randomly
		public void scrollAction(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("Window.scrollBy(0,500)");
			
		}
		
		// This method will scroll downwards until the specific element
		public void scrollAction(WebDriver driver,WebElement element) {
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			int y = element.getLocation().getY();
			js.executeScript("window.scrollBy(0,"+y+")",element);
			
		}
		
	
}



