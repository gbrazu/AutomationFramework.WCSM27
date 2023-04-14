package vtiger.Contact.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)

public class CreateContactUsingAvailableOrgTest extends BaseClass
{

	@Test(groups = {"Smokesuite","Regressionsuite"})
	public void CreateContactWithOrgTest() throws InterruptedException, Exception
	{
		String LASTNAME = eUtil.ReadDataFromExcelFile("Contact", 4, 2)+jUtil.getRandomNumber();
		String ORGNAME = eUtil.ReadDataFromExcelFile("Organization", 1, 2)+jUtil.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOrgLookupImg();
		CreateNewOrganizationPage nop = new CreateNewOrganizationPage(driver);
		nop.createNewOrganization(ORGNAME);
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.getOrganizationText();
		//Assert.assertTrue(ORGHEADER.contains(ORGNAME));
		hp.clickOnContactsLink();
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg(driver);
		CreateNewContactPage ncp = new CreateNewContactPage(driver);
		ncp.createNewContact(driver, LASTNAME, ORGNAME);
		ContactInfoPage cip = new ContactInfoPage(driver);
		String CONTHEADER = cip.getContactText(LASTNAME);
		Assert.assertTrue(CONTHEADER.contains(LASTNAME));	

	}

}
