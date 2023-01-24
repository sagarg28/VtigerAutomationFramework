package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement contactLookup;
	
	public CreateContactPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactLookup() {
		return contactLookup;
	}
	// Bussinesd
	public void clickOnNewContact() {
		contactLookup.click();
	}
}
