package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * 
 * This class consists of all generic methods related to web driver actions
 * @author rajes
 */
public class WebDriverUtility {
/**
 * 
 * This method is used to maximize the Window
 * @author rajes
 * @param driver
 */
	public void maximizeWindow(WebDriver driver) {	
		driver.manage().window().maximize();
	}
	/**
	 *
	 *This method is used to minimize the window 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * 
	 * This method is for implicit wait of upto 10 seconds
	 * 
	 * @param driver
	 */
	public void waitforPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * 
	 * 
	 * This method will wait for a particular element to be visible in the DOM
	 * @param driver
	 * @param element
	 */
	public void waitforElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * This method will wait for a particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitforElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * 
	 * This method is used to handle DropDown using Index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * 
	 * This method is used to handle DropDown using Value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);;
	}
	/**
	 * 
	 * This method is used to handle DropDown using Visible Text
	 * @param element
	 * @param text
	 */
	public void handleDropDown(String visibletext,WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibletext);;
	}
	/**
	 * 
	 *  This method will perform right click 
	 * @param driver
	 * @param ele
	 */
	public void rightClickAction(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}
	/**
	 * 
	 * This method will perform mouse hovering action
	 * @param driver
	 * @param ele
	 */
	public void mouseHoverAction(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	/**
	 * 
	 *  This method will move the cursor based on offset and click on web page
	 * @param driver
	 */
	public void moveAndClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveByOffset(10,10).click().perform();
	}
	
	/**
	 * 
	 *  This method will perform drag and drop operation
	 * @param driver
	 * @param drag
	 * @param drop
	 */
	public void dragNDrop(WebDriver driver, WebElement drag, WebElement drop) {
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).perform();
	}
	/**
	 * 
	 *  This method will perform drag and drop operation
	 * @param drag
	 * @param drop
	 * @param driver
	 */
	public void dragNDrop(WebElement drag, WebElement drop, WebDriver driver) {
		Actions act = new Actions(driver);
		act.clickAndHold(drag).perform();
		act.release(drop).perform();
	}
	/**
	 * 
	 * 
	 * @param driver
	 * @param ele
	 * @param value
	 */
	public void sendKeys(WebDriver driver, WebElement ele, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(ele, value).build().perform();
	}
	/**
	 * This method is for double clicking an element
	 * 
	 * @param driver
	 * @param ele
	 */
	public void doubleClick(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
	}
	/**
	 * 
	 * This method is for Scroll down by 1000 units
	 * @return
	 * @param driver
	 */
	public void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000);","");
	}
	/**
	 * 
	 * This method is for Scroll Up by 1000 units
	 * @return
	 * @param driver
	 */
	public void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-1000);","");
	}
	/**
	 * 
	 * This method is for Scrolling down to a particular WebElement
	 * @return
	 * @param driver
	 * @param element
	 */
	public void scrollDown(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	/**
	 * 
	 * This method will handle frame by name or Id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * 
	 * This method will handle frame by indexValue
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method will handle frame by Element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * 
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 *  This method will cancel the alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will fetch the alert text and return it to caller
	 * 
	 * @param driver
	 */
	public void getAlertText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	/**
	 * 
	 * This method will take screenshot and return the dst path
	 * @param driver
	 * @param fileName
	 * @return 
	 * @throws Throwable
	 */
	public String captureScreenshot(WebDriver driver, String fileName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\"+fileName+".png");
		Files.copy(src, dst);
		
		return dst.getAbsolutePath();// used for extent reports
		
	}
	
	/**
	 * 
	 * This method will switch from one window to another based on window Title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		//Step 1: get all the window IDs
		Set<String> allWinIDs = driver.getWindowHandles();
		
		//Step 2: Navigate thru each window
		for(String winID:allWinIDs)
		{
			//Step 3: switch to each window and capture the title
			driver.switchTo().window(winID);
			String actTitle = driver.getTitle();
			
			//Step 4: Compare act title with expected partial Title
			if(actTitle.contains(partialWinTitle)) {
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
}
