package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * 
 * This generic class is for reading data from properties file
 * @author rajes
 * 
 * 
 */
public class PropertyFileUtilities {
	
	
	public String readPropertyData(String key) throws Throwable {
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
		
	}

}
