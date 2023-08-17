package com.TestScripts_Generics_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.ObjectRepository.CalendarPage;
import com.crm.ObjectRepository.Homepage;
import com.crm.ObjectRepository.LoginPage;
import com.crmGenericUtility.DataBaseUtility;
import com.crmGenericUtility.ExcelUtility;
import com.crmGenericUtility.FileUtility;
import com.crmGenericUtility.JavaUtility;
import com.crmGenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Month_Todo_All_FieldsTest {

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
		String tdname=elib.readDataFromExcel("calendar", 0, 1)+random;
		String description =elib.readDataFromExcel("calendar", 1, 1);
		String status = elib.readDataFromExcel("calendar", 2, 1);
		String priority =elib.readDataFromExcel("calendar", 3, 1);
		String startdate = elib.readDataFromExcel("calendar", 4, 1);
		

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
		
		//click on calendarlink
		Homepage hp = new Homepage(driver);
		hp.clickoncalendar();
		
		//click on create todo by passing data
		CalendarPage cp = new CalendarPage(driver);
		cp.clickonlinks(driver);
		
		//create Todo with all fields in calendarpage
		cp.createTodoall(tdname, description, status, priority, startdate);
		
		//validation of created todo 
		cp.validate("Calendar");
		
		//logout of application
		hp.logout(driver);	
		
	}

}
