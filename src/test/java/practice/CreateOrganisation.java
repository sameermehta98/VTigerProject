package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelFileUtilities;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtilities;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisation {

	public static void main(String[] args) throws Throwable {
		JavaUtility jUtil=new JavaUtility();
		ExcelFileUtilities eUtil= new ExcelFileUtilities();
		PropertyFileUtilities pUtil=new PropertyFileUtilities();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		//read the required data
		String URL = pUtil.readPropertyData("url");
		String BROWSER = pUtil.readPropertyData("browser");
		String USERNAME = pUtil.readPropertyData("username");
		String PASSWORD = pUtil.readPropertyData("password");
		
		String cred = eUtil.readExcelData("Organization", 1, 2)+jUtil.getRandomNum();
		WebDriver driver=null;
		if(BROWSER.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		}else  {
			System.out.println("Invalid browser");
		}
		
		
		wUtil.maximizeWindow(driver);
		wUtil.waitforPageLoad(driver);
		
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(cred);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String text=driver.findElement(By.xpath("//span[text()='"+cred+"']")).getText();
		if(text.contains(cred)) {
			System.out.println("test pass");
		}else {
			System.out.println("test fail");
		}
		 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver,ele );
		driver.findElement(By.linkText("Sign Out")).click();
	}
}
