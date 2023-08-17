package com.TestScripts_Generics;

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

public class Create_Campaigns_Mandatory_System {

	public static void main(String[] args) throws Throwable {
		
		DataBaseUtility dlib= new DataBaseUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new 	FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		//Read Data from propertyfile
		String Url = flib.ReadDataFromPropertyFile("url");
		String Password = flib.ReadDataFromPropertyFile("password");
		String Username = flib.ReadDataFromPropertyFile("username");
		String Browser = flib.ReadDataFromPropertyFile("browser");
		
        //Read data from excel
		String value = elib.readDataFromExcel("campaigns", 0, 1);
		String value1 = elib.readDataFromExcel("campaigns", 1, 1);
		
		
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
	
		driver.findElement(By.name("Campaigns")).click();

		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();

		driver.findElement(By.name("campaignname")).sendKeys(value);

		driver.findElement(By.xpath("//input[@type='radio']/../input[2]")).click();

		WebElement f1 = driver.findElement(By.name("closingdate"));
		f1.clear();
		f1.sendKeys(value1);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		WebElement verifyCampaigns=driver.findElement(By.xpath("//table[@class='small']/descendant::td[@class='moduleName']"));
		String verifyText = verifyCampaigns.getText();
		if(verifyText.contains("Campaigns")) 
		{
			System.out.println("Navigated to the Campaigns Page");
		}
		else 
		{
			System.out.println("Didn't navigated to the Campaigns Page");
		}

		WebElement ele1 = driver.findElement(By.xpath("//td[@class='genHeaderSmall']/following-sibling::td[1]"));
		wlib.mousehover(driver, ele1);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
