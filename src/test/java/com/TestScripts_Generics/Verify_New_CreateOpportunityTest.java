package com.TestScripts_Generics;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.crmGenericUtility.DataBaseUtility;
import com.crmGenericUtility.ExcelUtility;
import com.crmGenericUtility.FileUtility;
import com.crmGenericUtility.JavaUtility;
import com.crmGenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_New_CreateOpportunityTest {
public static void main(String[] args) throws Throwable {
		
		DataBaseUtility dlib= new DataBaseUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new 	FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		int random = jlib.getRandomno();
		
		//fetch data from properties file
		String url =flib.ReadDataFromPropertyFile("Url");
		String browser =flib.ReadDataFromPropertyFile("Browser");
		String username=flib.ReadDataFromPropertyFile("Username");
		String password=flib.ReadDataFromPropertyFile("Password");
		
		
		//excel test data
		String oppname = elib.readDataFromExcel("opportunities", 0, 1)+random;
		String salesstage = elib.readDataFromExcel("opportunities", 1, 1);
		String orgname = elib.readDataFromExcel("opportunities", 2, 1);
		String date = elib.readDataFromExcel("opportunities", 3, 1);
		
        
	    //Launching the browsers
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		wlib.maximizebrowser(driver);
		driver.get(url);
		wlib.waituntillpageload(driver);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//click on opportunity link
		driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
		
		//click on create opportunity lookup image
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		
		//enter details into all the text fields
		driver.findElement(By.name("potentialname")).sendKeys(oppname);
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		Thread.sleep(2000);

		//switching between windows
		String parent = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		
		for (String handle : handles) 
		{
			if(!handle.equals(parent)) 
			{
				driver.switchTo().window(handle);
				driver.findElement(By.name("search_text")).sendKeys(orgname);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='qspiders']")).click();
				Thread.sleep(2000);
			}
		}
		driver.switchTo().window(parent);
		driver.findElement(By.id("jscal_trigger_closingdate")).click();
		driver.findElement(By.name("closingdate")).sendKeys(date);
		
		WebElement ele1 = driver.findElement(By.name("sales_stage"));
		Select sel = new Select(ele1);
		ele1.sendKeys(salesstage);
		
		//validating the page is opened or not
		String  ele = driver.findElement(By.linkText("Opportunities")).getText();
		if(ele.contains("Opportunities")) 
		{
			System.out.println("opportunities page is opened sucessfully");
		}
		else
		{
			System.out.println("opportunities page loading is failed");
		}		
	   driver.close();
	}
}
