package interview_practice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpiceJet_Assignment {
	@Test
	public void FetchAndVerifyDepDate() throws InterruptedException {
		
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
		
		
		driver.findElement(By.xpath("//div[.='Departure Date']")).click();
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
		Thread.sleep(3000);
		
		String str = driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-1hfyk0a']")).getText();
		
		boolean depdate=str.contains("Tue, 09 Jan 2024");
		
		Assert.assertTrue(depdate);
		System.out.println("verified sucessfully");
		
		driver.close();
	}
	
	@Test
	public void SelectMinFlight() throws InterruptedException {
		
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
		
		
		driver.findElement(By.xpath("//div[.='Departure Date']")).click();
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
		Thread.sleep(3000);
		
	    WebElement flightprice=driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-1sgu7fw r-1ljd8xs r-1phboty r-1777fci r-e9bn0q']/descendant::div[@class='css-76zvg2 r-homxoj r-1i10wst r-1kfrs79'])[4]"));
	    String price=flightprice.getText();
	   
	    driver.findElement(By.xpath("//div[@data-testid='continue-search-page-cta']")).click();
	    
	    System.out.println("the minimum price of flight is: "+ price);
	    driver.close(); 
		
	}			
}


