 package com.PracticePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_ProjectTest {

	public static void main(String[] args) throws InterruptedException, SQLException {
		        String expc ="RunWay_Sales";
		        
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				
				driver.manage().window().maximize();
				
				//Launch the application
				driver.get("http://rmgtestingserver:8084/");
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
				
				//Login to the application
				driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
				driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
				driver.findElement(By.xpath("//button[text()='Sign in']")).click();
				Thread.sleep(4000);
				
				//validating the application
				WebElement data = driver.findElement(By.xpath("//span[text()='Test Yantra']"));
				String text=data.getText();
				if(text.equals("Test Yantra")){
					System.out.println("Application is loged in sucussfully");
				}
				else{
				   System.out.println("Logged in failed");
			   }
			   //Click on projects
				driver.findElement(By.xpath("//a[text()='Projects']")).click();
				driver.findElement(By.xpath("//span[text()='Create Project']")).click();
				
				//Create a project
				driver.findElement(By.name("projectName")).sendKeys("RunWay_Sales3");
				driver.findElement(By.name("createdBy")).sendKeys("Laxmi_mam");
				WebElement element =driver.findElement(By.name("status"));
				Select s= new Select(element);
				s.selectByValue("Created");
				driver.findElement(By.xpath("//input[@type='submit']")).click();	
				Thread.sleep(4000);
				
				//connect to database
				Driver driver1 = new Driver();
				DriverManager.registerDriver(driver1);
				
			
				Connection con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
				
				Statement state =con.createStatement();
				String query="select *from project;";
				

				ResultSet result =state.executeQuery(query);
				boolean flag=false;
				while(result.next()) {
					String actual=result.getString(4);
					if(actual.equalsIgnoreCase(expc)) {
						flag=true;
						break;
					}
				}
				//check the data created in database
				if(flag) {
					System.out.println("Project is created sucessfully");
				}
				else {
					System.out.println("Project creation is failed");
				}
				
				//close the database
				con.close();
	            driver.quit();
	}

}
