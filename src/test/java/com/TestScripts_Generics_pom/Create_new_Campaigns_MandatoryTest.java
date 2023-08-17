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

public class Create_new_Campaigns_MandatoryTest {

	public static void main(String[] args) throws Throwable {
		
		DataBaseUtility dlib= new DataBaseUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new 	FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		//Read Data from propertyfile
		String Url = flib.ReadDataFromPropertyFile("Url");
		String Password = flib.ReadDataFromPropertyFile("Password");
		String Username = flib.ReadDataFromPropertyFile("Username");
		String Browser = flib.ReadDataFromPropertyFile("Browser");
		
        //Read data from excel
		String campname = elib.readDataFromExcel("campaigns", 0, 1);
		String date = elib.readDataFromExcel("campaigns", 1, 1);
		
		//Lunching the browsers
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
		
		//login to the application
		LoginPage lp = new LoginPage(driver);
		lp.Loginpage(Username, Password);	
		
		//click on campaings page
	    Homepage hp = new Homepage(driver);
	    hp.clickonMore(driver);
	    hp.clickonCamp();
	    
	    //click on create campaigns page
	    CampaignsPage cp = new CampaignsPage();
	    cp.clickoncreatecamp();
	    
	    //Create new campaign with entering data to mandatory fields
	    Create_CampaignsPage ccp = new Create_CampaignsPage(driver);
	    ccp.creatcamp(campname, date);
	    
	    //validation of created campaigns
	    ccp.verifycamp( "Campaigns");
	    
	    //logout of the application
	    hp.logout(driver);
	    
		

	}

}
