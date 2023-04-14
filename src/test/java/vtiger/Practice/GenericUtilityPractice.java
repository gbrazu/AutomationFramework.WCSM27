package vtiger.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Exception 
	{
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String data = pUtil.readDataFromPropertyFile("browser");
		System.out.println(data);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String value = eUtil.ReadDataFromExcelFile("Organization", 1, 2);
		System.out.print(value);
		
		ExcelFileUtility eUtil1 = new ExcelFileUtility();
		eUtil1.WriteIntoExcel("Organization", 10, 11, "HCL");
		System.out.println("Data added");
		
		JavaUtility jUtil = new JavaUtility();
		int num = jUtil.getRandomNumber();
		System.out.println(num);
		
		JavaUtility jdate = new JavaUtility();
		String date = jdate.getSystemDate();
		System.out.println(date);
		
		JavaUtility jdate1 = new JavaUtility();
		String dateformat = jdate1.getSystemDateInFormat();
		System.out.println(dateformat);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.maximizeWindow(driver);
		Thread.sleep(1000);
		wUtil.minimizeWindow(driver);
		
		
		
		

	}

}
