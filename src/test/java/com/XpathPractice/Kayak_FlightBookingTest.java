package com.XpathPractice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Kayak_FlightBookingTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.kayak.com/flights");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@aria-current=\"page\"]")).sendKeys("banglore");
		//driver.findElement(By.xpath("//input[@placeholder='From?']")).sendKeys("banglore");
		driver.findElement(By.xpath("//input[@placeholder='To?']")).sendKeys("Delhi");
		driver.findElement(By.xpath("//span[text()='New Delhi, National Capital Territory of India, India']")).click();
	    driver.findElement(By.xpath("(//span[@class='sR_k-value'])[1]")).click();
		driver.findElement(By.xpath("(//div[text()='August 2023']/ancestor::div[@class='onx_ onx_-pres-mcfly onx_-double']//div[text()='2'])[1]")).click();
		driver.findElement(By.xpath("(//div[text()='September 2023']/ancestor::div[@class='onx_ onx_-pres-mcfly onx_-double']//div[text()='3'])[1]")).click();
		driver.findElement(By.xpath("//button[@aria-label='Search']")).click();
		Thread.sleep(5000);
		
		Set<String> id=driver.getWindowHandles();
		Iterator<String> it=id.iterator();
		while(it.hasNext())
		{
			String idd=it.next();
			String title=driver.switchTo().window(idd).getCurrentUrl();
			if(title.equalsIgnoreCase("https://www.kayak.com/flights/BLR-DEL/2023-08-02/2023-09-03?sort=bestflight_a"))
			{
				driver.switchTo().window(idd);
				break;
			}
			
		}
	
		driver.findElement(By.xpath("//div[text()='Other sort']")).click();
		List<WebElement> list=driver.findElements(By.xpath("//li[@role='tab']"));
		{
			for(int i=0;i<=list.size()-1;i++)
			{
				if(list.get(i).getText().equals("Slowest"))
				{
					list.get(i).click();
				}
				
			}
		}
		WebElement veryfy=driver.findElement(By.xpath("(//div[@class='f8F1-price-text'])[1]"));
		if(veryfy.equals("15k"))
		{
			System.out.println("its equal to 15k");
		}
		else
		{
			System.out.println("its not equal to 15k");
		}
		

	}

}
