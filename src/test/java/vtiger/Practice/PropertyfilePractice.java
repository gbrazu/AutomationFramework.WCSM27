package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyfilePractice {

	public static void main(String[] args) throws IOException 
	{
		//Step1: Load the file in java readable format using file input stream
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		
		//Step2: Create an object of properties from java.util package
		Properties pObj = new Properties();
		
		//Step3: Load file input stream into properties
		pObj.load(fis);
		
		//Step4: using the keys read the value
		String BROWSER=pObj.getProperty("browser");
		System.out.println(BROWSER);
		String USERNAME=pObj.getProperty("username");
		System.out.println(USERNAME);
		String PASSWORD=pObj.getProperty("password");
		System.out.println(PASSWORD);
		String URL=pObj.getProperty("url");
		System.out.println(URL);
		

	}

}
