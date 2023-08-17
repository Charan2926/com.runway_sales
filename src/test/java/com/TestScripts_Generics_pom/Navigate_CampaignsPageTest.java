package com.TestScripts_Generics_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.ObjectRepository.CampaignsPage;
import com.crm.ObjectRepository.Create_CampaignsPage;
import com.crm.ObjectRepository.Homepage;
import com.crm.ObjectRepository.LoginPage;
import com.crmGenericUtility.DataBaseUtility;
import com.crmGenericUtility.ExcelUtility;
import com.crmGenericUtility.FileUtility;
import com.crmGenericUtility.JavaUtility;
import com.crmGenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigate_CampaignsPageTest {
	
	public static void main(String[] args) throws Throwable {
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

	//Launching the browsers
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
	
	//click on campaigns link through morebtnlink
	Homepage hp = new Homepage(driver);
	hp.clickonMore(driver);
	hp.clickonCamp();
	
	//validation of campaigns page
	CampaignsPage cp = new CampaignsPage();
	cp.verifycamp("Campaigns");

	
  }
}

