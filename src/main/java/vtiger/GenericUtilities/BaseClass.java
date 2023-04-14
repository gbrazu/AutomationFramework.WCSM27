package vtiger.GenericUtilities;
/**
 * This class consists of all basic config annotations
 * @author v-bgelli
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass 
{
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	
	ChromeOptions options = new ChromeOptions();
	
	public WebDriver driver = null;
	public static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("database connection successful");
	}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups = {"Smokesuite","Regressionsuite"})
	public void bcconfig(/*String BROWSER*/) throws Exception
	{
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			System.out.println("---"+BROWSER+" launched----");
		}
else if(BROWSER.equalsIgnoreCase("firefox"))
{
	driver=new FirefoxDriver();
	System.out.println("---"+BROWSER+" launched----");
}
else
{
	System.out.println("Invalid browser");
}
sDriver = driver;//This is for listeners
wUtil.maximizeWindow(driver);
wUtil.waitforPageLoad(driver);
driver.get(URL);
	}
	@BeforeMethod(groups = {"Smokesuite","Regressionsuite"})
	public void bmconfig() throws Exception
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("--- Login to APP successful ---");
				
	}
	@AfterMethod(groups = {"Smokesuite","Regressionsuite"})
	public void amconfig()
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("--- logout of APP successful ---");
		
	}
	//@Parameters("browser")
	//@AfterTest
	@AfterClass(groups = {"Smokesuite","Regressionsuite"})
	public void acconfig()
	{
		driver.quit();
        System.out.println("--- Browser closed ---");
		
	}
	@AfterSuite(groups = {"Smokesuite","Regressionsuite"})
	public void asConfig()
	{
		System.out.println("Database closed successfully");
	}

}
