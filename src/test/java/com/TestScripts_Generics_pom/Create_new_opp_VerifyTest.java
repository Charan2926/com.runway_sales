package com.TestScripts_Generics_pom;

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

public class Create_new_opp_VerifyTest {
	
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
	
	//Get All Data From the Excel Sheet
	String oppname = elib.readDataFromExcel("opportunities", 0, 1);
	String salesstage= elib.readDataFromExcel("opportunities", 1, 1);
	String orgname = elib.readDataFromExcel("opportunities", 2, 1);
	String date = elib.readDataFromExcel("opportunities", 3, 1);
	
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
	
	//click on  to the opportunities link
	Homepage hp = new Homepage(driver);
	hp.clickonOpp();
	
	//click on create opportunity link
    Opportunitiespage op = new Opportunitiespage();
    op.clickoncreatenewopp();
	
	//Pass Data into create opportunity page
	Create_OpportunitiesPage cop = new Create_OpportunitiesPage();
	cop.createnewopp(oppname, driver, orgname, salesstage, date);
	
	//validate the opportunities page
	cop.validateopp("Opportunities");
	
	//logout of the application
	hp.logout(driver);

 }
}
