package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage extends WebDriverUtility {

	@FindBy(linkText = "Contacts")
	private WebElement contactClick;
	
	@FindBy(linkText = "Organizations")
	private WebElement OrgLink;
	
	@FindBy(linkText = "Documents")
	private WebElement DocumentLink;
	
	
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administraitorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	// initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	// utilization

	public WebElement getContactClick() {
		return contactClick;
	}

	public WebElement getOrgLink() {
		return OrgLink;
	}

/*	public WebElement getOrgLookup() {
		return orgLookup;
	}*/

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getAdministraitorImg() {
		return administraitorImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	// Bussiness Library
	/*
	 * this method click on Organization Link
	 */
	
	public void clickOnOrgLink() {
		
		OrgLink.click();
	}
	/*
	 * This method click on contacts link
	 */
	public void clickOnContactLink() {
		
		contactClick.click();
	}
	public void logOutApp(WebDriver driver) {
		mouseHoverAction(driver, administraitorImg);
		signoutLink.click();
	}
	
	
}
