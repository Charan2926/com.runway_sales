package com.PracticePackage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksAPSTRCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//Launch the application
		driver.get("https://apsrtclivetrack.com/#/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> linkslist =driver.findElements(By.xpath("//a"));
		System.out.println(linkslist.size());
		
		ArrayList<String> links = new ArrayList<String>();//Create an empty array
		
		for(int i=0;i<linkslist.size();i++) 
		{
			String eachlink = linkslist.get(i).getAttribute("href");
			
			URL url =null;
			int statuscode =0;
			try 
			{
				//load the url
				url = new URL(eachlink);
				
				//open the url connection
				HttpURLConnection HttpurlConnection = (HttpURLConnection)url.openConnection();
				
				statuscode = HttpurlConnection.getResponseCode();
				
				//check the status code
				if(statuscode>=400) 
				{
					links.add(eachlink+"-----"+statuscode);
				}
			}
		     catch(Exception e)
			{
				links.add(eachlink+"------"+statuscode);
				
			}
		} 
		    System.out.println(links);
		    
		    driver.quit();
		

	}

}
