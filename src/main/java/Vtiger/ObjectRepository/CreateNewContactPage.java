package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {

	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement nameDropDown;
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firsNameEdt;
	@FindBy(xpath="//input[@name = 'lastname']")
	private WebElement lastNameEdt;
	@FindBy(xpath="//select[@name='leadsource']")
	private WebElement leadSourceDropDown;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getNameDropDown() {
		return nameDropDown;
	}

	public WebElement getFirsNameEdt() {
		return firsNameEdt;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//Bussiness
	public void createNewContact(String lastName,String leadSource) {
		
		lastNameEdt.sendKeys(lastName);
		handleDropDown(leadSource, leadSourceDropDown);
		saveBtn.click();
		
	}
	
}
