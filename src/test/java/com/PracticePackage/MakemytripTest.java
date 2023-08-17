package com.PracticePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakemytripTest {
public static void main(String[] args) throws InterruptedException {
		
		String Month_and_Year = "January 2024";
		int date = 1;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions act = new Actions(driver);
		act.moveByOffset(40,40).click().perform();
		
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		String actual = "//div[text()='"+Month_and_Year+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		String nextArrow = "//span[@aria-label='Next Month']";
		
		for(;;) 
		{
			try {
				driver.findElement(By.xpath(actual)).click();
				break;
			}
			catch(Exception e) {
				driver.findElement(By.xpath(nextArrow)).click();
			}
		}
		Thread.sleep(5000);
		driver.close();
			
 }
}
