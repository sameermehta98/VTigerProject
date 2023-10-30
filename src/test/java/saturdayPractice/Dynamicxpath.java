package saturdayPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamicxpath {

	public static void main(String[] args) {
		String countryName="Albania";
WebDriverManager.chromedriver().setup();
WebDriver dri=new ChromeDriver();
dri.get("https://www.countries-ofthe-world.com/capitals-of-the-world.html");


		WebElement ctry = dri.findElement(By.xpath("//td[text()='"+countryName+"']/following-sibling::td"));
		String cap = ctry.getText();
	System.out.println(cap);
	
	
	
	
	}

}
