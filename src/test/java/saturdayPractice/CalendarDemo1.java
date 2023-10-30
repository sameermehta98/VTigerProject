package saturdayPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarDemo1 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.xpath("//p[text()='Hyderabad, India']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label='Tue Oct 10 2023']")).click();
		
		
		
	}

}
