package organisationTests;

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
import objectRepository.CreateNewOrgPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganisationInfoPage;
import objectRepository.OrganisationPage;

public class CreateOrganisationTest extends BaseClass {
@Test(groups = "RegressionSuite")
public void test1() throws Throwable {
	
	String ORGNAME = eUtil.readExcelData("Organization", 1, 2)+jUtil.getRandomNum();
	HomePage hp=new HomePage(driver);
	hp.clickOnOrganization();

	OrganisationPage op=new OrganisationPage(driver);
	op.clickOnCreateOrgLookUpImg();

	CreateNewOrgPage cno=new CreateNewOrgPage(driver);
	cno.createNewOrganisation(ORGNAME);

	OrganisationInfoPage oip=new OrganisationInfoPage(driver);
	
	Assert.assertTrue(oip.getHeaderText().contains(ORGNAME));
	System.out.println("Headername match:PASS");
//	driver.quit();
}
}
