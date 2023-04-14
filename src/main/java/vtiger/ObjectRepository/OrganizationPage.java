package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage //Rule1: create a POM class for every webpage
{
	//Rule2: Identify the web elements using Annotations
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateOrgLookupImg;
	
	//Rule3: Initialize the web elements using constructor
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule4: Use Getter methods to access these web elements

    public WebElement getCreateOrgLookupImg() 
    {
		return CreateOrgLookupImg;
	}

    //Business Library
    /**
     * this method will click on create org look up image
     */
    public void clickOrgLookupImg()
    
   {
    	CreateOrgLookupImg.click();
    	System.out.println("clicked create org lookup img");
	
   }
}
