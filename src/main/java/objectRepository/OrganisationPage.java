package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {

	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;
	
	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgImg() {
		return CreateOrgLookUpImg;
	}
	
	/**
	 * 
	 * This method will click on Create Organization Image
	 * 
	 */
	public void clickOnCreateOrgLookUpImg() {
		CreateOrgLookUpImg.click();
	}
	
	
	
}
