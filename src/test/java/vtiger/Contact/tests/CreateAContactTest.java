package vtiger.Contact.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateAContactTest extends BaseClass
{

	@Test(groups = {"Smokesuite","Regressionsuite"})
	public void CreateContactTest() throws Exception
	{
		String LASTNAME = eUtil.ReadDataFromExcelFile("Contact", 4, 2)+jUtil.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		Reporter.log("Clicked on contacts link");
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg(driver);
		Reporter.log("clicked on contacklookupimg");
		CreateNewContactPage ncp = new CreateNewContactPage(driver);
		ncp.createNewContact(LASTNAME);
		Reporter.log("created new contact", true);
		ContactInfoPage cip = new ContactInfoPage(driver);
		String CONTHEADER = cip.getContactText(LASTNAME);
		Assert.assertTrue(CONTHEADER.contains(LASTNAME));
		
	}

}
