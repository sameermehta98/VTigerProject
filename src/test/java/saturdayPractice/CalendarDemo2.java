package saturdayPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarDemo2 {

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
		
		for(int x=1;x<4;x++) {
			Thread.sleep(1000);
			boolean isPresent;
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			Thread.sleep(1000);
			try {
			driver.findElement(By.xpath("//div[text()='December 2023']"));
			isPresent=true;
			}catch(Exception e) {
				isPresent=false;
			}
			if(isPresent) {
				driver.findElement(By.xpath("//div[@aria-label='Fri Dec 08 2023']")).click();
				break;
			}
		}
		
		
		driver.quit();
		
		
		
		
		
	}

}
