package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewContactsPage extends WebDriverUtility {
	@FindBy(name = "lastname")
	private WebElement lastNameTxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement OrgLookUpImg;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement OrgSearchEdt;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement OrgSearchBtn;
	
	public  CreateNewContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameTxt() {
		return lastNameTxt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}

	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}

	public WebElement getOrgSearchBtn() {
		return OrgSearchBtn;
	}
	
	public void createNewContact(String LASTNAME) {
		lastNameTxt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	public void createNewContact(WebDriver driver,String LASTNAME, String ORGNAME) {
		lastNameTxt.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		OrgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
	
	
	
	
}
