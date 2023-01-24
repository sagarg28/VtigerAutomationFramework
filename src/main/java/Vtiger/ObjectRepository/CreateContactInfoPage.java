package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactInfoPage {

	@FindBy(className="dvHeaderText")
	private WebElement headerText;
	public CreateContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getHeaderText() {
		return headerText;
	}
	//Bussiness
	public String HeaderText() {
		
		return headerText.getText();
	}
	
}
