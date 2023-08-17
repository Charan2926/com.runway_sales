package com.TestScripts_Generics_pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepository.Create_OpportunitiesPage;
import com.crm.ObjectRepository.Homepage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.Opportunitiespage;
import com.crmGenericUtility.DataBaseUtility;
import com.crmGenericUtility.ExcelUtility;
import com.crmGenericUtility.FileUtility;
import com.crmGenericUtility.JavaUtility;
import com.crmGenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigate_OpportunitiesPageTest {

	public static void main(String[] args) throws IOException {
		
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
		
		//click on opportunities link
		Homepage hp = new Homepage(driver);
		hp.clickonOpp();
		
		//validation of opportunity page 
	    Opportunitiespage op = new Opportunitiespage();
		op.validateopp("Opportunities");
	}
}
