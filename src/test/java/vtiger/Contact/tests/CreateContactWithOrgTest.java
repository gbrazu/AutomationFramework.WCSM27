package vtiger.Contact.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)

public class CreateContactWithOrgTest {

	@Test
	public void CreatecontactWithOrgTest() throws Exception
	{
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		JavaUtility jUtil = new JavaUtility();
		
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME = eUtil.ReadDataFromExcelFile("Organization", 1, 2)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.ReadDataFromExcelFile("Contact", 1, 2)+jUtil.getRandomNumber();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
				
		WebDriver driver=null;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			 driver = new ChromeDriver(options);
		}
		else if
		(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitforPageLoad(driver);
		
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOrgLookupImg();
		
		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createNewOrganization(ORGNAME);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		//WebElement ORGHEADER = oip.getOrgHeaderText();
		String ORGHEADER = oip.getOrganizationText();
		Assert.assertTrue(ORGHEADER.contains(ORGNAME));
		hp.clickOnContactsLink();
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg(driver);
		CreateNewContactPage ncp =new CreateNewContactPage(driver);
		ncp.createNewContact(driver, LASTNAME, ORGNAME);
		ContactInfoPage cip = new ContactInfoPage(driver);
		String CONTHEADER = cip.getContactText(LASTNAME);
		if(CONTHEADER.contains(LASTNAME))
		{
			System.out.println("Contact created-Pass");
		}
		else
		{
			System.out.println("Failed");
		}
		hp.logoutOfApp(driver);
		driver.quit();

	}

}