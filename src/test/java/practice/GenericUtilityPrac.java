package practice;

import genericUtilities.ExcelFileUtilities;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtilities;
import genericUtilities.WebDriverUtility;

public class GenericUtilityPrac {

	public static void main(String[] args) throws Throwable {
		PropertyFileUtilities pUtil = new PropertyFileUtilities();
		String URL = pUtil.readPropertyData("url");
		System.out.println(URL);
		
		ExcelFileUtilities excelUtil = new ExcelFileUtilities();
		String valueFetch = excelUtil.readExcelData("Contact",1, 2);
		System.out.println(valueFetch);
		
		excelUtil.writeExcelData("hi how are you", 7, 7, "Contact");
		System.out.println("Data successfully written!");
		
		String valueFetch2 = excelUtil.readExcelData("Contact",7, 7);
		System.out.println(valueFetch2);
		
		JavaUtility ju = new JavaUtility();
		int randnum = ju.getRandomNum();
		System.out.println(randnum);
		
		String sysDate = ju.getSystemDate();
		System.out.println(sysDate);
		
		WebDriverUtility wdu=new WebDriverUtility();
//		wdu.

		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
