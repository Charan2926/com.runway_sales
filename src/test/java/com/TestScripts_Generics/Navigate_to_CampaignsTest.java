package com.TestScripts_Generics;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.crmGenericUtility.DataBaseUtility;
import com.crmGenericUtility.ExcelUtility;
import com.crmGenericUtility.FileUtility;
import com.crmGenericUtility.JavaUtility;
import com.crmGenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigate_to_CampaignsTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		DataBaseUtility dlib= new DataBaseUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new 	FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		//Getting data from property file
		String url =flib.ReadDataFromPropertyFile("Url");
		String browser =flib.ReadDataFromPropertyFile("Browser");
		String username=flib.ReadDataFromPropertyFile("Username");
		String password=flib.ReadDataFromPropertyFile("Password");
		
		//launching the browsers
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	
		wlib.maximizebrowser(driver);
		
		//launching the application
		driver.get(url);
		wlib.waituntillpageload(driver);
		
		//logging to the application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		
		WebElement verify=driver.findElement(By.xpath("//table[@class='small']//descendant::td[@class='moduleName']"));
		String verifyText = verify.getText();
		if(verifyText.contains("Campaigns")) {
			System.out.println(" Campaigns Page is opened sucessfully");
		}else {
			System.out.println(" Campaigns Page loading is failed");
		}

	    driver.close();
		
		Thread.sleep(2000);

	}
}
