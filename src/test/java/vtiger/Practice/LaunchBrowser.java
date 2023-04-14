package vtiger.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {

	public static void main(String[] args)
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("\"--remote-allow-origins=*\"");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		//driver.get("http://localhost:8888/");
		

	}

}
