package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContHeaderText;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getContHeaderText() {
		return ContHeaderText;
	}
	public String getContactText(String LASTNAME)
	{
		System.out.println("verified contact created");
		return ContHeaderText.getText();
		
	}

}
