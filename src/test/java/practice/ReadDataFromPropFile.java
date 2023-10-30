package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropFile {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browser_call = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String un = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		
	}

}
