package com.PracticePackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ReadDataFromCmdline {
	@Test
	public void readdatafromcmdline() {
		
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
		String BROWSER = System.getProperty("Browser");
		String URL =System.getProperty("Url");
		String USERNAME = System.getProperty("Username");
		String PASSWORD= System.getProperty("Password");
		
       
		
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	
	}
}
