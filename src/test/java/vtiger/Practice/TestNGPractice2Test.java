package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice2Test 
{
	@Test
	public void createUserTest()
	{
		Assert.fail();
		System.out.println("User created");//executed but failed
	}
	@Test(dependsOnMethods = "createUserTest")
	public void modifyUserTest()
	{
		System.out.println("User data modified");//should not execute
	}
	@Test(enabled = true)
	public void deleteUserTest()
	{
		System.out.println("User deleted");//should not execute
	}

}
