package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  
	
	//rule 1 create POM class for every web page
	//rule 2 Class name should be title of the page
	//rule 3 identify the webElements using findBy,findAll,@Find
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;

	@FindBy(id = "submitButton")
	private WebElement SubmitBtn;
	
	

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	//Create a constructor 
	
		public LoginPage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
	
	
	//Bussiness Library-Generic Methods -for this application
	// this method will login to application
	
	public void loginToApp(String USERNAME,String PASSWORD) {
		
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		SubmitBtn.click();
	}
}
