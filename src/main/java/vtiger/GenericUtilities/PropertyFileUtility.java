package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file
 * @author Raju
 *
 */

//single line comment
public class PropertyFileUtility 
{	
	/**
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String readDataFromPropertyFile(String key) throws Exception
	{
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fisp);
		String value = pObj.getProperty(key);
		return value;
	}
	

}
