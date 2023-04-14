package vtiger.Organization.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)

public class CreateOrganizationWithIndustryAndTypeTest {

	@Test
	public void CreateOrgWithIndustryAndTypeTest() throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("UAE Chemicals");
		WebElement dropdown=driver.findElement(By.xpath("//select[@name='industry']"));
		Select s = new Select(dropdown);
		s.selectByVisibleText("Energy");
		WebElement dropdown1 = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select s1 = new Select(dropdown1);
		s1.selectByVisibleText("Customer");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.navigate().back();
		WebElement element=driver.findElement(By.xpath("//td[@class='genHeaderSmall']/../td[2]"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		WebElement signout=driver.findElement(By.linkText("Sign Out"));
		Thread.sleep(2000);
		signout.click();
		driver.close();

	}

}
