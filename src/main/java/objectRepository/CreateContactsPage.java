package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactsPage {
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement CreateContactsLookUpImg;
	
	public  CreateContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactsLookUpImg() {
		return CreateContactsLookUpImg;
	}
	
	/**
	 * This method will click on Create Contacts Look Up Image
	 * 
	 */
	public void clickOnCreateContactsLookUpImage() {
		CreateContactsLookUpImg.click();
	}
	
	
}
