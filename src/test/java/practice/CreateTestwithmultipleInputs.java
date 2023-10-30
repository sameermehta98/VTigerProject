package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

public class CreateTestwithmultipleInputs {
	ExcelFileUtilities eUtil=new ExcelFileUtilities();
		@Test(dataProvider = "getData")
		public void createOrg(String ORG, String INDUSTRYNAME) throws Throwable {
			JavaUtility jUtil=new JavaUtility();
			ExcelFileUtilities eUtil= new ExcelFileUtilities();
			PropertyFileUtilities pUtil=new PropertyFileUtilities();
			WebDriverUtility wUtil=new WebDriverUtility();
			
			//read the required data
			String URL = pUtil.readPropertyData("url");
			String BROWSER = pUtil.readPropertyData("browser");
			String USERNAME = pUtil.readPropertyData("username");
			String PASSWORD = pUtil.readPropertyData("password");
			
//			String ORGNAME = eUtil.readExcelData("Organization", 1, 2)+jUtil.getRandomNum();
//			String LASTNAME = eUtil.readExcelData("Contact", 1, 2);
			
			String ORGNAME = ORG+jUtil.getRandomNum();

			WebDriver driver=null;
			if(BROWSER.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				 driver=new ChromeDriver();
			}else if(BROWSER.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				 driver=new FirefoxDriver();
			}else if(BROWSER.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				 driver=new EdgeDriver();
			}else  {
				System.out.println("Invalid browser");
			}
			
			
			wUtil.maximizeWindow(driver);
			wUtil.waitforPageLoad(driver);
			
			driver.get(URL);
			
			LoginPage lp=new LoginPage(driver);
			lp.loginToApplication(USERNAME, PASSWORD);
			
			HomePage hp=new HomePage(driver);
			hp.clickOnOrganization();
			

			// Step 7: Click on Create Organization look Up Image
			OrganisationPage op = new OrganisationPage(driver);
			op.clickOnCreateOrgLookUpImg();

			// Step 8: Create new Organization with Mandatory fields
			CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
			cnop.createNewOrganisation(ORGNAME, INDUSTRYNAME);
			wUtil.captureScreenshot(driver, ORGNAME);

			// Step 9: Validate for Organization
			OrganisationInfoPage oip = new OrganisationInfoPage(driver);
			String orgHeader = oip.getHeaderText();
			if (orgHeader.contains(ORGNAME)) {
				System.out.println(orgHeader);
				System.out.println("Organization Created");
			} else {
				System.out.println("FAIL");
			}
			
			//Step 10: Logout
			hp.logOut(driver);
			driver.close();
		}

		@DataProvider
		public Object[][] getData() throws Throwable {
			return eUtil.readMultipleData("multipleData");
		
		}
}
