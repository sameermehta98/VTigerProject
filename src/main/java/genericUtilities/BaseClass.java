package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	
	public JavaUtility jUtil=new JavaUtility();
	public ExcelFileUtilities eUtil= new ExcelFileUtilities();
	public PropertyFileUtilities pUtil=new PropertyFileUtilities();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public WebDriver driver;
	
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("------DB Connection Successful------");
	}
	
	
//	@Parameters("browser")
//	@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws Throwable {
		String URL = pUtil.readPropertyData("url");
		String BROWSER = pUtil.readPropertyData("browser");
		
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
		
		System.out.println("------Driver launched successfully------");
		wUtil.maximizeWindow(driver);
		wUtil.waitforPageLoad(driver);
		sdriver=driver;
		driver.get(URL);
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws Throwable {

		String USERNAME = pUtil.readPropertyData("username");
		String PASSWORD = pUtil.readPropertyData("password");
	
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		System.out.println("------Login Successful------");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.logOut(driver);	
		System.out.println("------LogOut Successful------");
	}
	
//	@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig() {
		driver.quit();
		System.out.println("------Browser closed------");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("------DB Closed------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
