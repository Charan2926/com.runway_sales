package com.PracticePackage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launching_the_app_using_propertyfileTest {

	public static void main(String[] args) throws Throwable {
		        //create object for fileinputstream
				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
				
				//create object for properties class
				Properties pobj = new Properties();
				
				//load the data from property file
				pobj.load(fis);
				
				//fectching the data using key 
				String url= pobj.getProperty("url");
				String browser= pobj.getProperty("browser");
				String un= pobj.getProperty("username");
				String pwd= pobj.getProperty("password");
				
				//launch the browsers
				WebDriver driver;
				if(browser.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					
				}
				else if(browser.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				}
				else {
					
						driver=new ChromeDriver();
						
				}
				
				driver.manage().window().maximize();
				
				//Launch the application
				driver.get(url);
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				//login to the application
				driver.findElement(By.name("user_name")).sendKeys(un);
				driver.findElement(By.name("user_password")).sendKeys(pwd);
				driver.findElement(By.id("submitButton")).click();
				
				Thread.sleep(3000);
				driver.close();

	}

}
