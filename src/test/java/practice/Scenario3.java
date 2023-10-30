package practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario3 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Get URL
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("hi!2");
		WebElement industry_dd = driver.findElement(By.xpath("//select[@name='industry']"));
		Select indus_dd = new Select(industry_dd);
		indus_dd.selectByValue("Chemicals");
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[2]")).click();
//		Thread.sleep(2000);
//		Alert alt = driver.switchTo().alert();
//		alt.accept();
		
		
		
		
		
		
		
		
		
		
	}

}
