package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement CreateContLookupImg;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateContLookupImg() {
		return CreateContLookupImg;
	}
	public void clickOnCreateContactLookUpImg(WebDriver driver)
	{
		CreateContLookupImg.click();
		System.out.println("clicked on createcontact lookup image");
	}
}
