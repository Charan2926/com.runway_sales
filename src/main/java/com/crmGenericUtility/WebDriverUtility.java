package com.crmGenericUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * This method is used to maximize browser
	 * @author Nani
	 * @param driver
	 */
	public void maximizebrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to wait untill page is loaded
	 * @author Nani
	 * @param driver
	 */
	public void waituntillpageload(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	/**
	 * This method is used to wait untill element is visible
	 * @author Nani
	 * @param driver
	 * @param element
	 */
	public void waituntillelementtobevisible(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**This method is used to handle dropdown using index
	 * @author Nani
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index) {
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method is used to handle dropdown using visibletext
	 * @author Nani
	 * @param element
	 * @param text
	 */
	public void select(WebElement element,String text) {
	   Select sel=new Select(element);
	   sel.selectByVisibleText(text);
	}
	/**
	 * This method is used to handle dropdown using value
	 * @author Nani
	 * @param value
	 * @param element
	 */
	public void select(String value,WebElement element) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method is used to perform mousehover actions
	 * @author Nani
	 * @param driver
	 * @param element
	 */
	public void mousehover(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	/**
	 * This method is used to perform drag and drop actions
	 * @author Nani
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void draganddrop(WebDriver driver,WebElement src,WebElement dest) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest);
	}
	/**
	 * This method is used to perform double click action
	 * @author Nani 
	 * @param driver
	 */
	public void doubleclickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * This method is used to perform right click action on webpage
	 * @author Nani
	 * @param driver
	 */
	public void rightclick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This method is used to perform right click action on web element
	 * @author Nani
	 * @param driver
	 * @param element
	 */
	public void rightclick(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick().perform();	
	}
	/**
	 * This method is used to press right key
	 * @author Nani
	 * @param driver
	 */
	public void enterkeypress(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * This method is used to press right key by using robot class
	 * @author Nani
	 * @param driver
	 * @throws Throwable
	 */
	public void enterkey(WebDriver driver) throws Throwable {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to release the key
	 * @author Nani
	 * @param driver
	 * @throws Throwable
	 */
	public void enterrelease(WebDriver driver) throws Throwable {
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to switch one frame to another frame by using index
	 * @author Nani
	 * @param driver
	 * @param index
	 */
	public void switchtoframe(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch one frame to another frame by using name or id
	 * @author Nani
	 * @param driver
	 * @param nameorID
	 */
	public void swtichtoframe(WebDriver driver,String nameorID) {
		driver.switchTo().frame(nameorID);
	}
	/**
	 * This method is used to switch one frame to another frame by using element address
	 * @author Nani
	 * @param driver
	 * @param element
	 */
	public void switchframe(WebDriver driver,WebElement elementaddress) {
		driver.switchTo().frame(elementaddress);
	}
	/**
	 * This method is used to swtich back to parent frame
	 * @author Nani
	 * @param driver
	 */
	public void switchbacktoparentframe(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * This method is used to swtich back to main window
	 * @author Nani
	 * @param driver
	 */
	public void switchbacktomainwindow(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	 /**
     * This method is used to switchch between windows 
     * @author Nani
     * @param driver
     * @param partialtitle
     */
	public void switchtowindow(WebDriver driver,String partialtitle) {
		
		//step1:use getwindowhandles to capture all window id's
		Set<String> windows=driver.getWindowHandles();
		
		//step2:iterate through the windows
		Iterator <String> it =windows.iterator();
		
		//step3:check whether there is next window
		while(it.hasNext()) {
			
	   //step4: capture current window id
		String winid=it.next();
			
	   //step5: switch to current window and capture title
	    String currentwintitle=driver.switchTo().window(winid).getTitle();
			
		//step6: check whether cuurent window is expected 
		if(currentwintitle.contains(partialtitle)) {
				break;
			}
		}
	}
	
	/**
	 * This method is used to accept alret popup
	 * @author Nani
	 * @param driver
	 */
	public void acceptalert(WebDriver driver){
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to cancel alert popup
	 * @author Nani
	 * @param driver
	 */
	public void cancelalert(WebDriver driver){
		driver.switchTo().alert().dismiss();
	}
   /**
    * This method is used to take screenshot and store in an folder 
    * @author Nani
    * @param driver
    * @param screenshotname
    * @return
    * @throws Throwable
    */
    public static String getscreenshot(WebDriver driver,String screenshotname) throws Throwable   {
    	TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\"+screenshotname+".png";
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		return path;
    }
    /**
     * This method is used to perform all scrolling of webpage
     * @author Nani
     * @param driver
     */
    public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)","");
	}
    /**
     * This method is used to perform all scrolling of webpage untill the element is found
     * @author Nani
     * @param driver
     * @param element
     */
    public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
}
