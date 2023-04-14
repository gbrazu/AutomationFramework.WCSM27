package vtiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest 
{
	@Test
	public void test()
	{
		String BROWSER1 = System.getProperty("browser");//run time parameter
		System.out.println(BROWSER1);
	}

}
