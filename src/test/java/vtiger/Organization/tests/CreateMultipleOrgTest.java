package vtiger.Organization.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)

public class CreateMultipleOrgTest extends BaseClass
{
	

	@Test(dataProvider = "Org with Industry")
	public void CreateOrgTest(String ORG,String Industry) throws Exception
	{
				
		String ORGNAME = ORG+jUtil.getRandomNumber();
		
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOrgLookupImg();
		
		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createNewOrganization(ORGNAME, Industry);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String ORGHEADER = oip.getOrganizationText();
		Assert.assertTrue(ORGHEADER.contains(ORGNAME));
					
	}
	
	@DataProvider(name="Org with Industry")
	public Object[][]getData() throws Exception
	{
		Object[][] data = eUtil.readDataFromExcelToDataProvider("dataProviderOrg");
		return data;
		
	}

}
