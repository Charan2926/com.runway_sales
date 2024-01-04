package interview_practice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpiceJet_Calender_Pop {
	@Test
	public void CalendarPop() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
 		WebDriver  driver= new ChromeDriver(options);
 		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement from =driver.findElement(By.xpath("//div[text()='From']"));
		from.sendKeys("mumbai");
		WebElement to=driver.findElement(By.xpath("(//input[@class=\"css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu\"])[2]"));
		to.sendKeys("Delhi");
		driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button']")).click();
		
		driver.findElement(By.xpath("//div[.='Departure Date']")).click();
		driver.findElement(By.xpath("(//div[.='Select Date'])[2]")).click();
		driver.findElement(By.xpath("//div[@data-testid='undefined-month-November-2023']//div[@data-testid='undefined-calendar-day-24']")).click();
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
		Thread.sleep(4000);
		String str = driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-1hfyk0a']")).getText();
		
		boolean plce=str.contains("Delhi");
		boolean ad=str.contains(" 1 Adult");
		boolean dep=str.contains("Wed, 04 Oct 2023");
		boolean ret=str.contains("Fri, 24 Nov 2023");
		
		Assert.assertTrue(plce);
		Assert.assertTrue(ad);
		Assert.assertTrue(dep);
		Assert.assertTrue(ret);
		System.out.println("verified sucessfully"); 
	}
				
}


