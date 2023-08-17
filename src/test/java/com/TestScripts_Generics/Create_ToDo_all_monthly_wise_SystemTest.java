package com.TestScripts_Generics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.crmGenericUtility.DataBaseUtility;
import com.crmGenericUtility.ExcelUtility;
import com.crmGenericUtility.FileUtility;
import com.crmGenericUtility.JavaUtility;
import com.crmGenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_ToDo_all_monthly_wise_SystemTest {

	public static void main(String[] args) throws Throwable {
	
		DataBaseUtility dlib= new DataBaseUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new 	FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		int random = jlib.getRandomno();
		
		//Read data from property file
		String url =flib.ReadDataFromPropertyFile("Url");
		String browser =flib.ReadDataFromPropertyFile("Browser");
		String username=flib.ReadDataFromPropertyFile("Username");
		String password=flib.ReadDataFromPropertyFile("Password");
		
		//Get All Data From the Excel Sheet
		String tdname=elib.readDataFromExcel("calendar", 0, 1);
		String description =elib.readDataFromExcel("calendar", 1, 1);
		String status = elib.readDataFromExcel("calendar", 2, 1);
		String priority =elib.readDataFromExcel("calendar", 3, 1);
		String startdate = elib.readDataFromExcel("calendar", 4, 1);
		String duedate =elib.readDataFromExcel("calendar", 5, 1);
		
		//launching browsers and appliction
		WebDriverManager.chromedriver().setup();
		WebDriver cd = new ChromeDriver();	
		wlib.maximizebrowser(cd);
		cd.get(url);
		wlib.waituntillpageload(cd);
	
		//login to the application
		cd.findElement(By.name("user_name")).sendKeys(username);
		cd.findElement(By.name("user_password")).sendKeys(password);
		cd.findElement(By.id("submitButton")).click();
		
		//Click on Calendar Module
		cd.findElement(By.linkText("Calendar")).click();
		
		//Click On Month Tab
		cd.findElement(By.xpath("//a[text()='Month']")).click();
		cd.findElement(By.linkText("To Dos")).click();
		
		//Click Add Button
		WebElement calAddButton = cd.findElement(By.xpath("//td[@class='calAddButton']"));
		wlib.mousehover(cd, calAddButton);
		
		//click on todo
		cd.findElement(By.linkText("To Do")).click();
	
		//pass data into todo page
		cd.findElement(By.name("task_subject")).sendKeys(tdname);
		cd.findElement(By.name("task_description")).sendKeys(description);
		
		//Select Task Status
		WebElement taskStatus = cd.findElement(By.id("taskstatus"));
		Select s = new Select(taskStatus);
		s.selectByVisibleText(status);
		
		//Select Task Priority
		WebElement taskPriority = cd.findElement(By.id("taskpriority"));
		Select s1 = new Select(taskPriority);
		s1.selectByVisibleText(priority);
		
		//Select Assign To
		cd.findElement(By.xpath("(//input[@name='task_assigntype'])[2]")).click();
		WebElement assignTo = cd.findElement(By.name("task_assigned_group_id"));
		Select s2 = new Select(assignTo);
		s2.selectByVisibleText("Marketing Group");
		
		
		//Select Start Date
		WebElement startDate = cd.findElement(By.id("task_date_start"));
		startDate.clear();
		startDate.sendKeys(startdate);
		
		//Select End Date
	     WebElement dueDate=cd.findElement(By.xpath("//b[text()='Due Date']"));
		dueDate.clear();
	    dueDate.sendKeys(duedate);
		
		//Click on Save Button
		cd.findElement(By.name("todosave")).click();
		Thread.sleep(3000);
		
		//validating the page is opened or not
		String  ele = cd.findElement(By.xpath("//a[@class='hdrLink']")).getText();
		if(ele.contains("Calendar")) 
		{
			System.out.println("Calendar page is opened sucessfully");
		}
		else
		{
			System.out.println("Calendar page loading is failed");
		}				
		
		//logout of the application
		WebElement logout = cd.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions ac=new Actions(cd);
		ac.moveToElement(logout).click().perform();
		cd.findElement(By.xpath("//a[text()='Sign Out']")).click();		
		
		cd.close();

	}

}
