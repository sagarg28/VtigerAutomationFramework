package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Choice.Factory;

import Vtiger.GenericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{

	@FindBy(name="accountname")
	private WebElement acName;
	@FindBy(xpath="//select[@name='industry' and @class='small']")
	private WebElement industryDD;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getAcName() {
		return acName;
	}
	public WebElement getIndustryDD() {
		return industryDD;
	}
	public void createNewOrg(String OrgName) {
		acName.sendKeys(OrgName);
		saveBtn.click();
	}
	public void createNewOrgWithIndustryDD(String OrgName,String industry) {
		acName.sendKeys(OrgName);
		handleDropDown(industry, industryDD);
		saveBtn.click();
	}
	
}
