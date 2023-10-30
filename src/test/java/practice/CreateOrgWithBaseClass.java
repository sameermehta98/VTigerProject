package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CreateNewOrgPage;
import objectRepository.HomePage;
import objectRepository.OrganisationInfoPage;
import objectRepository.OrganisationPage;

public class CreateOrgWithBaseClass extends BaseClass {
	@Test(groups = "SmokeSuite")
	public void createOrg() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganization();
		
		String ORGNAME = eUtil.readExcelData("Organization", 1, 2)+jUtil.getRandomNum();

		// Step 7: Click on Create Organization look Up Image
		OrganisationPage op = new OrganisationPage(driver);
		op.clickOnCreateOrgLookUpImg();

		Thread.sleep(1000);
		// Step 8: Create new Organization with Mandatory fields
		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		cnop.createNewOrganisation(ORGNAME);
		wUtil.captureScreenshot(driver, ORGNAME);
		
		OrganisationInfoPage oip = new OrganisationInfoPage(driver);
		String orgHeader = oip.getHeaderText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
		System.out.println("Organization Created");
		
//		if (orgHeader.contains(ORGNAME)) {
//			System.out.println(orgHeader);
//			System.out.println("Organization Created");
//		} else {
//			System.out.println("FAIL");
//		}
	}
}
