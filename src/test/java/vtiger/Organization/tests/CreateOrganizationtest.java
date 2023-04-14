package vtiger.Organization.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)

public class CreateOrganizationtest extends BaseClass
{

	@Test(groups = {"Smokesuite","Regressionsuite"})
	public void CreateOrgTest() throws Exception
	{
		String ORGNAME = eUtil.ReadDataFromExcelFile("Organization", 1, 2)+jUtil.getRandomNumber();
		HomePage hp =new HomePage(driver);
		hp.clickOnOrganizationLink();
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOrgLookupImg();
		CreateNewOrganizationPage nop = new CreateNewOrganizationPage(driver);
		nop.createNewOrganization(ORGNAME);
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String ORGHEADER = oip.getOrganizationText();
		Assert.assertTrue(ORGHEADER.contains(ORGNAME));

}
	@Test
	public void Demo()
	{
		System.out.println("demo");
	}
	
}
