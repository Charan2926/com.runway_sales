package com.XpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Filter_SamaungPhones_By_BrandTest {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		
		WebElement element = driver.findElement(By.xpath("//img[@src=\"https://images-na.ssl-images-amazon.com/captcha/bcxmjlko/Captcha_dwtztxxfee.jpg\"]"));
		String result =element.getText();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(result);
		driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();
		
		driver.findElement(By.xpath("//input[@aria-label='Search Amazon']")).sendKeys("Phone");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(500);
		JavascriptExecutor js=(JavascriptExecutor )driver;
		js.executeScript("window.scrollBy(0,400)","");
		List<WebElement> list=driver.findElements(By.xpath("//div[@id='brandsRefinements']/ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium']/span[@data-csa-c-type='element']"));
		for(int i=0;i<=list.size()-1;i++)
		{
			if(list.get(i).getText().equals("SAMSUNG"))
			{
				System.out.println(list.get(i).getText());
			    list.get(i).click();
				break;
			}
			
		}		
	
	driver.close();
	
  }
}
