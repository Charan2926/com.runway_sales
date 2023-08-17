  package com.PracticePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopupTest {

	public static void main(String[] args) throws InterruptedException {
		
		String Month_and_Year = "September 2023";
		int date = 25;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		String actual = "//div[text()='"+Month_and_Year+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		String nextArrow = "//span[@aria-label='Next Month']";
		
		for(;;) 
		{
			try 
			{
				driver.findElement(By.xpath(actual)).click();
				break;
			}
			catch(Exception e) 
			{
				driver.findElement(By.xpath(nextArrow)).click();
			}
		}
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		Thread.sleep(5000);
		
		WebElement result =driver.findElement(By.xpath("//p[contains(text(),'25 Sep')]"));
		System.out.println(result.getText());
		driver.close();
	}
  }

