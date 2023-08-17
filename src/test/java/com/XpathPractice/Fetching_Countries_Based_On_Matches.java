package com.XpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fetching_Countries_Based_On_Matches {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> teams = driver.findElements(By.xpath("//table//tr[*]/td[2]"));
        List<WebElement> matches = driver.findElements(By.xpath("//table//tr[*]/td[3]"));
        
        for(int i=0;i>30;i++) {
        	System.out.println(teams.get(i).getText()+"----- "+matches.get(i).getText());
        	
        }
        
	}

}
