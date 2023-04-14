package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility //Rule1: Create a POM class for every web page
{
	//Rule2: Identify the web elements using the Annotations
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement OrgnameEdt;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement Industrydropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Rule3: Initialize the web elements by using a constructor
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Rule4: Use getter methods to access these web elements

	public WebElement getOrgnameEdt() {
		return OrgnameEdt;
	}
	public WebElement getIndustrydropdown() {
		return Industrydropdown;
	}
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business Library
	/**
	 * This method will create an organization
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME)
	{
		OrgnameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
		System.out.println("Org created");
	}
	/**
	 * This method will create org with industry drop down
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrganization(String ORGNAME, String INDUSTRY)
	{
		OrgnameEdt.sendKeys(ORGNAME);
		handleDropdown(Industrydropdown, INDUSTRY);	
		SaveBtn.click();
		System.out.println("Org created");
		}

}
