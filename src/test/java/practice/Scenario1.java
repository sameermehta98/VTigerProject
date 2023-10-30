package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 {
		public static void main(String[] args) throws Throwable {
			//Launch Browser.
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//Get URL
			driver.get("http://localhost:8888/");
			
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			WebElement dd_sal = driver.findElement(By.xpath("//select[@name='salutationtype']"));
			Select s1 = new Select(dd_sal);
			s1.selectByValue("Mr.");
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("abc");
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
			
			WebElement lgout_btn = driver.findElement(By.xpath("//td[contains(@onmouseover,'~abc@gmail.com')]"));
			
//			1.
//			lgout_btn.click();
//			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			
//			2.
			Actions act = new Actions(driver);
			act.moveToElement(lgout_btn).perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();		
		}
}
