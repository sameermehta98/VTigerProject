package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsbtn;
	
	@FindBy(linkText = "Organizations")
	private WebElement OrgBtn;
	
	@FindBy(xpath  = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText   = "Sign Out")
	private WebElement signOutBtn;
	
	@FindBy(linkText   = "Products")
	private WebElement productsBtn;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactsbtn() {
		return contactsbtn;
	}

	public WebElement getOrgBtn() {
		return OrgBtn;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}

	
	public WebElement getProductsBtn() {
		return productsBtn;
	}
	
	/**
	 * 
	 * This method will click on Contacts button
	 */
	public void clickOnContacts() {
		contactsbtn.click();
	}
	
	/**
	 * 
	 * This method will click on Organization button
	 */
	public void clickOnOrganization() {
		OrgBtn.click();
	}
	
	/**
	 * 
	 * This method will click on Products button
	 */
	public void clickOnProducts() {
		productsBtn.click();
	}
	
	/**
	 * 
	 * This method will logOut of the application
	 * @param driver
	 * @throws Throwable
	 */
	public void logOut(WebDriver driver) throws Throwable {
		mouseHoverAction(driver,adminImg );
		Thread.sleep(1000);
		signOutBtn.click();	
	}
}
