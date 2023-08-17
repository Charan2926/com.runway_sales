package com.XpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Filter_SamsungPhones_pricesTest {
	public static void main(String[] args) {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
	driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Samsung phones");
	driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	
	//storing all the Samsung-phones along with price in one list
    List<WebElement> price=driver.findElements(By.xpath("//div[@class=\"col col-5-12 nlI3QM\"]//descendant::div[@class=\"_25b18c\"]"));
    List<WebElement> name=driver.findElements(By.xpath("//div[@class=\"col col-7-12\"]//descendant::div[@class='_4rR01T']"));
    
    for(int i=0;i<=price.size()-1;i++)
    {
    	
    		System.out.println("name ="+name.get(i).getText()+"--------"+"price="+price.get(i).getText());	
 
    }
	driver.close();
  }
}
