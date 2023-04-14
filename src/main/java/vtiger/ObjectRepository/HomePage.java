package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
    //Rule1: create a pom class for web page

	
	//Rule2: Identify all the web elements using Annotations
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OppurtunitiesLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy (linkText = "Sign Out")
	private WebElement SignOutLink;
	
	
	//Rule3: Initialize these webelements using a constructor
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule4: Provide getters to get these webelements
	
	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}	
	
	//Business library - Generic Methods
	public void clickOnOrganizationLink()
	{
		OrganizationLink.click();
	}
	
	public void clickOnContactsLink()
	{
		ContactsLink.click();
	}
	/**
	 * This method will perform signout operation of application
	 * @param driver
	 */
	public void logoutOfApp(WebDriver driver)
	{
		mousehoverAction(driver, AdministratorImg);
		SignOutLink.click();
	}
	
	
	

}
