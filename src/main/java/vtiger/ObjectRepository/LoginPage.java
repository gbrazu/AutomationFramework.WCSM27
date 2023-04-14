package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //Rule1: Create a seperate pom class for every webpage
{
	//Rule2: Identify all the web elements using Annotations
	@FindBy(name="user_name")
	private WebElement UserNameEdt;
	
	@FindBy(name="user_password")
	private WebElement PassWordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement SubmitBtn;
			
	//Rule3: Initialize these webelements using a constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Rule4: Provide Getters to access these elements

	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPassWordEdt() {
		return PassWordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	/**
	 * this method will login in to the application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	//Business library - Generic Methods - Project specific.
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		UserNameEdt.sendKeys(USERNAME);
		PassWordEdt.sendKeys(PASSWORD);
		SubmitBtn.click();
		
	}

}
