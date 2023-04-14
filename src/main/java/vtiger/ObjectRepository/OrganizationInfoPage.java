package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage //Rule1: create a seperate pom class for webpage
{
	//Rule2: Identify all the web elements using Annotations
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	//Rule3: Initialize these web elements using constructor
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Rule4: Access these web elements using getters method
	public  WebElement getOrgHeaderText() {
		return OrgHeaderText;
		
	}
	//Business library
	
	public String getOrganizationText()
	{
		System.out.println("validated org created");
		return OrgHeaderText.getText();
	}
	
	
}
