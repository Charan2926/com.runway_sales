package com.TestScripts_Generics_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepository.Homepage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.SalesOrderPage;
import com.crmGenericUtility.DataBaseUtility;
import com.crmGenericUtility.ExcelUtility;
import com.crmGenericUtility.FileUtility;
import com.crmGenericUtility.JavaUtility;
import com.crmGenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit_Exis_Saleorder_Update_NewSales_OrderTest {

	public static void main(String[] args) throws Throwable {
		DataBaseUtility dlib= new DataBaseUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new 	FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		int random = jlib.getRandomno();
		
		//Getting data from property file
		String url =flib.ReadDataFromPropertyFile("Url");
		String browser =flib.ReadDataFromPropertyFile("Browser");
		String username=flib.ReadDataFromPropertyFile("Username");
		String password=flib.ReadDataFromPropertyFile("Password");
		
		//Get All Data From the Excel Sheet
		String value = elib.readDataFromExcel("salesorder", 0, 1);
		String value1 = elib.readDataFromExcel("salesorder", 1, 1);
		String value2 = elib.readDataFromExcel("salesorder", 2, 1)+random;
		
		//Launching Browsers
		WebDriver driver;
		if(browser.equalsIgnoreCase("chrome"))
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
		driver.get(url);
		wlib.waituntillpageload(driver);
		
		//login to the application
		LoginPage lp = new LoginPage(driver);
		lp.Loginpage(username, password);
		
		//click on salesorderpage
		Homepage hp = new Homepage(driver);
		hp.clickonMore(driver);
		hp.clickonSales();
		
		//verify and update  sales order
		SalesOrderPage sp = new SalesOrderPage(driver);
		sp.verify_update_sales(value, value1, value2);
		
		//validate the updated salesorder
		sp.validateupdatedsales("Sales Order");
		
		
		

	}

}
