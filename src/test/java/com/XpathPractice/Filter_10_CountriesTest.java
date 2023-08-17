package com.XpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Filter_10_CountriesTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		List<WebElement> list = driver.findElements(By.xpath("//table//tbody//tr[*]"));
		
		for(int i=0;i<10;i++){
			System.out.println( list.get(i).getText());
		}
		driver.findElement(By.xpath("//div[text()='Accept']")).click();
		driver.close();

	}

}
