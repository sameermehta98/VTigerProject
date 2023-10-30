package contactsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtilities;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtilities;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.CreateContactsPage;
import objectRepository.CreateNewContactsPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
@Listeners(genericUtilities.ListenersImplementationClass.class)
public class CreateContactsTest extends BaseClass{
	
	/*@Test(priority = 1)
	public void Demo1() {
		Assert.fail();
		System.out.println("hi from Demo1");
	}*/
	
@Test(groups = "SmokeSuite", /*dependsOnMethods = "Demo1",*/ priority = 2)
public void test1() throws Throwable {
	
	String ORGNAME = eUtil.readExcelData("Organization", 1, 2)+jUtil.getRandomNum();
	String LASTNAME = eUtil.readExcelData("Contact", 1, 2)+jUtil.getRandomNum();
	
	HomePage hp=new HomePage(driver);
	
	hp.clickOnContacts();
	Reporter.log("Contacts clicked");
	
	CreateContactsPage cc=new CreateContactsPage(driver);
	cc.clickOnCreateContactsLookUpImage();
	Reporter.log("Contacts lookup image clicked");
	
	CreateNewContactsPage cnp=new CreateNewContactsPage(driver);
	cnp.createNewContact(LASTNAME);
	Reporter.log("Lastname created");
	System.out.println(wUtil.captureScreenshot(driver, LASTNAME));
	
//	Assert.fail();
	ContactInfoPage cip=new ContactInfoPage(driver);
	Assert.assertTrue(cip.getHeaderText().contains(LASTNAME));
	System.out.println("------CONTACTS HEADER MATCH PASS------");
	Reporter.log("Contacts clicked");
}
//	@Test(priority = 3)
//	public void demoTest() {
//		System.out.println("hi");
//	}

}
