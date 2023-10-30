package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewOrgPage extends WebDriverUtility {

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement OrgNameEdt;
	
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement OrgTypeDD;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement IndustryDD;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public  CreateNewOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getOrgTypeDD() {
		return OrgTypeDD;
	}

	public WebElement getIndustryDD() {
		return IndustryDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	/**
	 * This method will Create Organisation using Organisation Name
	 * @param ORGNAME
	 */
	public void createNewOrganisation(String ORGNAME) {
		OrgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create organisation using OrgName, Industry
	 * @param ORGNAME
	 * @param Value
	 */
	public void createNewOrganisation(String ORGNAME, String Value) {
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDD, Value);
		saveBtn.click();

	}
	
	/**
	 * 
	 * This method will create organisation using OrgName, Industry, Type
	 * @param ORGNAME
	 * @param Value
	 * @param TypeValue
	 */
	public void createNewOrganisation(String ORGNAME, String Value, String TypeValue) {
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDD, Value);
		handleDropDown(OrgTypeDD, TypeValue);
		saveBtn.click();

	}
}
