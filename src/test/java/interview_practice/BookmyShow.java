package interview_practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BookmyShow {
	@Test
	public void MovieDetails() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver  driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://in.bookmyshow.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement ele=driver.findElement(By.xpath("(//img[@class='bwc__sc-ttnkwg-26 izPSOY'])[3]"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().perform();
		
		driver.findElement(By.xpath("//a[text()='Movies']")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)","");
		
		driver.findElement(By.xpath("(//div[@class='sc-7o7nez-0 ehthfR'])[2]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)","");
		
		driver.findElement(By.xpath("class=\"sc-eykeme-1 jrtRfk\"")).click();
		driver.findElement(By.xpath("(//div[@class='sc-1vmod7e-2 hhYlrx'])[1]")).click();
		
	}

}
