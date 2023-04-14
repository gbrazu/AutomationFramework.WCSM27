package vtiger.Organization.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)

public class CreateAnOrganizationWithIndustryTest extends BaseClass
{

	@Test
	public void CreateAnOrgWithIndustryTest() throws IOException
	{
		
		String ORGNAME = eUtil.ReadDataFromExcelFile("Organization", 1, 2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.ReadDataFromExcelFile("Organization", 4, 3);
		HomePage hp =new HomePage(driver);
		hp.clickOnOrganizationLink();
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOrgLookupImg();
		CreateNewOrganizationPage nop = new CreateNewOrganizationPage(driver);
		nop.createNewOrganization(ORGNAME, INDUSTRY);
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String ORGHEADER = oip.getOrganizationText();
		Assert.assertTrue(ORGHEADER.contains(ORGNAME));
		
	}

}
