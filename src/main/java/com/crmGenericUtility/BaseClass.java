package com.crmGenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.ObjectRepository.Homepage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public DataBaseUtility dlib= new DataBaseUtility();
	public ExcelUtility elib = new ExcelUtility();
	public FileUtility flib = new 	FileUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public static WebDriver driver;
	//public static WebDriver sdriver;
	
	/*@BeforeSuite(alwaysRun = true)
	public void config_Bs() throws Throwable 
	{
		dlib.connectToDB();
		System.out.println("-----connect to DataBase-------");
		
	}*/
    
	//@Parameters( "BROWSER")
	//@BeforeClass(alwaysRun = true)
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws Throwable {
		String BROWSER = flib.ReadDataFromPropertyFile("Browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		//sdriver = driver;
		System.out.println("-----Launch the Browser----------");
		wlib.maximizebrowser(driver);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void config_BM() throws Throwable {
		String USERNAME= flib.ReadDataFromPropertyFile("Username");
		String PASSWORD = flib.ReadDataFromPropertyFile("Password");
		String URL = flib.ReadDataFromPropertyFile("Url");
		
		driver.get(URL);
		wlib.waituntillpageload(driver);
		
		LoginPage lp = new LoginPage(driver);
		lp.Loginpage(USERNAME, PASSWORD);
		System.out.println("------Login into the aplication-------");
	}
	
	@AfterMethod(alwaysRun = true)
	public void config_AM() {
		Homepage hp = new Homepage(driver);
		hp.logout(driver);
		System.out.println("----logout of the application----");
	}
	
	@AfterClass(alwaysRun = true)
	public void config_AC() {
		driver.quit();
		System.out.println("---------Close the browser-------");
	}
	
	/*@AfterSuite(alwaysRun = true)
	public void config_AS() throws Throwable {
		dlib.CloseDb();
		System.out.println("-----Close DataBase connection------");
	}*/
}
