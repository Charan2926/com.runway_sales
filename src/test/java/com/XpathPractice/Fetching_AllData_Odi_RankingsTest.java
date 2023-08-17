package com.XpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fetching_AllData_Odi_RankingsTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/odi");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		List<WebElement> list = driver.findElements(By.xpath("//table//tbody//tr[*]"));
		
		for (WebElement ele : list) {
			System.out.println(ele.getText());
		}
		driver.findElement(By.xpath("//div[text()='Accept']")).click();
		driver.close();
	}
}

