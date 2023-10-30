package contactsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
import objectRepository.CreateNewOrgPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganisationInfoPage;
import objectRepository.OrganisationPage;
import practice.CreateOrganisation;

public class CreateContactWithOrganisationTest extends BaseClass{
	@Test
	public  void createContactwOTest() throws Throwable {
		
		
		String ORGNAME = eUtil.readExcelData("Organization", 1, 2)+jUtil.getRandomNum();
		String LASTNAME = eUtil.readExcelData("Contact", 1, 2)+jUtil.getRandomNum();
		
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganization();
	
		OrganisationPage op=new OrganisationPage(driver);
		op.clickOnCreateOrgLookUpImg();
	
		CreateNewOrgPage cno=new CreateNewOrgPage(driver);
		cno.createNewOrganisation(ORGNAME);
	
		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		
		Assert.assertTrue(oip.getHeaderText().contains(ORGNAME));
		System.out.println("------ORG HEADER MATCH PASS------");
		
//		if(oip.getHeaderText().contains(ORGNAME)) {
//			System.out.println("PASS");
//		}else {
//			System.out.println("FAIL");
//		}
		
		hp.clickOnContacts();
		CreateContactsPage cc=new CreateContactsPage(driver);
		cc.clickOnCreateContactsLookUpImage();
	
		CreateNewContactsPage cnp=new CreateNewContactsPage(driver);
		cnp.createNewContact(driver, LASTNAME, ORGNAME);
		wUtil.captureScreenshot(driver, LASTNAME);
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		
		Assert.assertTrue(cip.getHeaderText().contains(LASTNAME));
		System.out.println("------CONTACTS HEADER MATCH PASS------");

//		if(cip.getHeaderText().contains(LASTNAME)) {
//			System.out.println("PASS");
//		}else {
//			System.out.println("FAIL");
//		}
		

	}
}
