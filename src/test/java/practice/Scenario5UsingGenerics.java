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
import objectRepository.LoginPage;

public class Scenario5UsingGenerics {

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
		String LASTNAME = eUtil.readExcelData("Contact", 1, 2);
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
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		LoginPage lp=new LoginPage(driver);
		lp.getUsernameTxt().sendKeys(USERNAME);
		lp.getPwdTxt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
		
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(cred);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		wUtil.switchToWindow(driver, "Accounts");
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(cred);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.linkText(cred)).click();
		wUtil.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();		
		
		
		 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wUtil.mouseHoverAction(driver,ele );
			driver.findElement(By.linkText("Sign Out")).click();
		
		
		
		
		
		
		
		
	}

}
