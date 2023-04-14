package vtiger.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

public class POMClassPracticeTest {

	public static void main(String[] args) throws Exception 
	{
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		JavaUtility jUtil = new JavaUtility();
		String ORGNAME = eUtil.ReadDataFromExcelFile("Organization", 1, 2)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.ReadDataFromExcelFile("Contact", 1, 2)+jUtil.getRandomNumber();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(options);
		
		wUtil.maximizeWindow(driver);
		wUtil.waitforPageLoad(driver);
		
		driver.get(pUtil.readDataFromPropertyFile("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(pUtil.readDataFromPropertyFile("username"), pUtil.readDataFromPropertyFile("password"));
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOrgLookupImg();
		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createNewOrganization(ORGNAME);
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.getOrganizationText();
		hp.clickOnContactsLink();
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg(driver);
		CreateNewContactPage ncp = new CreateNewContactPage(driver);
		ncp.createNewContact(LASTNAME);
		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.getContactText(LASTNAME);
		wUtil.handleDefaultFrame(driver);
		hp.getSignOutLink();
		
		
				
		
		

	}

}
