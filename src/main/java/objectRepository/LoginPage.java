package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name="user_name")
	private WebElement usernameTxt;
	
	@FindBy(name="user_password")
	private WebElement pwdTxt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameTxt() {
		return usernameTxt;
	}

	public WebElement getPwdTxt() {
		return pwdTxt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
//	@FindBys({})
	
	/**
	 * This method will login to the application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApplication(String USERNAME, String PASSWORD) {
		usernameTxt.sendKeys(USERNAME);
		pwdTxt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
}
