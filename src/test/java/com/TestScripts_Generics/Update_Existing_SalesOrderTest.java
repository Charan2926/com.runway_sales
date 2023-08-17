package com.TestScripts_Generics;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crmGenericUtility.DataBaseUtility;
import com.crmGenericUtility.ExcelUtility;
import com.crmGenericUtility.FileUtility;
import com.crmGenericUtility.JavaUtility;
import com.crmGenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Update_Existing_SalesOrderTest {

	public static void main(String[] args) throws InterruptedException, Throwable {
    
		DataBaseUtility dlib= new DataBaseUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new 	FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		//Read Data from property file
		String Url = flib.ReadDataFromPropertyFile("url");
		String Browser = flib.ReadDataFromPropertyFile("browser");
		String Username = flib.ReadDataFromPropertyFile("username");
		String Password = flib.ReadDataFromPropertyFile("password");
		
		//Read data From excel file
		String value = elib.readDataFromExcel("salesorder", 0, 1);
		String value1 = elib.readDataFromExcel("salesorder", 1, 1);
		String value2 = elib.readDataFromExcel("salesorder", 2, 1);
		
		//launching browsers and apllication
		WebDriver driver;
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
		wlib.maximizebrowser(driver);
		driver.get(Url);
		wlib.waituntillpageload(driver);
		
		//login to application 
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();

		WebElement ele = driver.findElement(By.xpath("//a[text()='More']"));
		wlib.mousehover(driver, ele);
		
		driver.findElement(By.name("Sales Order")).click();
		
		driver.findElement(By.name("search_text")).sendKeys(value);
		
		WebElement ele1 = driver.findElement(By.name("search_field"));
		wlib.select(value1, ele1);
		
		Thread.sleep(3000);
		driver.findElement(By.name("submit")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='edit']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.name("subject")).clear();
		driver.findElement(By.name("subject")).sendKeys(value2);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement ele2 = driver.findElement(By.xpath("(//a[text()='Sales Order'])[3]"));
		String text = ele2.getText();
		if(text.contains("Sales Order"))
		{
			System.out.println("sales order is updated sucessfully");
		}
		else
		{
			System.out.println("sales order is not updated");
		}
		
		WebElement findElement = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mousehover(driver, findElement);
		//Actions act1=new Actions(driver);
		//act1.moveToElement(findElement).click().perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	

	}

}
