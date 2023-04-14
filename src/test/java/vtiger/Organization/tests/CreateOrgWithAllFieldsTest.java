package vtiger.Organization.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)

public class CreateOrgWithAllFieldsTest {

	public static void main(String[] args) throws Exception 
	{
		//Create objects of generic utilities
		PropertyFileUtility pUtil = new PropertyFileUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		
		//Read required data from the utilities using the object reference
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		String ORGNAME = eUtil.ReadDataFromExcelFile("Organization", 1, 2)+jUtil.getRandomNumber();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		//Initialize the driver
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver(options);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
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
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("https://www.infosys.com/");
		driver.findElement(By.xpath("//input[@name='employees']")).sendKeys("1000");
		driver.findElement(By.xpath("//input[@name='email2']")).sendKeys("abc@xyz.com");
		WebElement IndustryDropdown = driver.findElement(By.xpath("//select[@name='industry']"));
		Select sel = new Select(IndustryDropdown);
		sel.selectByVisibleText("Construction");
		WebElement TypeDropdown = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select sel1 = new Select(TypeDropdown);
		sel1.selectByIndex(2);
		driver.findElement(By.xpath("//input[@name='emailoptout']")).click();
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9999999999");
		driver.findElement(By.xpath("//input[@name='fax']")).sendKeys("000-12345");
		driver.findElement(By.xpath("//input[@name='otherphone']")).sendKeys("8888888888");
		driver.findElement(By.xpath("//input[@name='email1']")).sendKeys("xyz@123.com");
		driver.findElement(By.xpath("//input[@name='ownership']")).sendKeys("Yes");
		WebElement RatingDropdown = driver.findElement(By.xpath("//select[@name='rating']"));
		Select sel2 = new Select(RatingDropdown);
		sel2.selectByIndex(2);
		WebElement AnnualRevenue = driver.findElement(By.xpath("//input[@name='annual_revenue']"));
		AnnualRevenue.clear();
		AnnualRevenue.sendKeys("1000");
		driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys("Plot 462, Infosys Campus, Gachibowli");
		driver.findElement(By.xpath("//input[@name='bill_pobox']")).sendKeys("PO: 1234");
		driver.findElement(By.xpath("//input[@name='bill_city']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//input[@name='bill_state']")).sendKeys("Telangana");
		driver.findElement(By.xpath("//input[@name='bill_code']")).sendKeys("500085");
		driver.findElement(By.xpath("//b[text()='Copy Billing address']")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//wUtil.dismissAlert(driver);
		//wUtil.switchToWindow(driver, "Accounts");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String ORGHEADER = oip.getOrganizationText();
		if(ORGHEADER.contains(ORGNAME))
		{
			System.out.println(ORGNAME+" "+"created");
		}
		else
		{
			System.out.println("Failed");
		}
		hp.logoutOfApp(driver);
		driver.quit();
		
		
	}

}
