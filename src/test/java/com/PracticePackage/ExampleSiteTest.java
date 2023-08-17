package com.PracticePackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleSiteTest {

	public static void main(String[] args) {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	List<WebElement> links=driver.findElements(By.tagName("a"));
	System.out.println(links);
	
	driver.get("http://www.example.com/login");
	//driver.findElement(By.id("username")).sendKeys("testuser");
	//driver.findElement(By.id("password")).sendKeys("Password123");
	driver.findElement(By.id("submit")).click();
	String exp ="Welcome";
	if(exp.contains("welcome")) 
	{
		System.out.println("test is passed");
	}
	else 
	{
		System.out.println("test is failed");
	}

	}

      
}
