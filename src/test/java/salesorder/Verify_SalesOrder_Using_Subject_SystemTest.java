package salesorder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_SalesOrder_Using_Subject_SystemTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Random r = new Random();
		int num = r.nextInt(200);
		
		//Read data from properties file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String url = pobj.getProperty("Url");
		String browser = pobj.getProperty("Browser");
		String username = pobj.getProperty("Username");
		String password = pobj.getProperty("Password");
		
		//Fetching Data from Excel
		FileInputStream fis2=new FileInputStream(".\\src\\test\\resources\\TestScripts_data.xlsx");
		Workbook wb=WorkbookFactory.create(fis2);
		Sheet sh=wb.getSheet("SalesOrder");
		String value = sh.getRow(0).getCell(1).getStringCellValue()+num;	
		String value1=sh.getRow(2).getCell(1).getStringCellValue();
				
		//launch browsers and application
		WebDriverManager.chromedriver().setup();
		WebDriver cd = new ChromeDriver();	
		cd.manage().window().maximize();
		cd.get(url);
		cd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//login to the application
		cd.findElement(By.name("user_name")).sendKeys(username);
		cd.findElement(By.name("user_password")).sendKeys(password);
		cd.findElement(By.id("submitButton")).click();
		
		//Click on More 
		Actions ac=new Actions(cd);
        WebElement more = cd.findElement(By.xpath("//a[text()='More']"));
		more.click();
	
		//Click on Sales Order Link
		cd.findElement(By.linkText("Sales Order")).click();
		
		//Enter Organization name in Search TextBox
		cd.findElement(By.name("search_text")).sendKeys(value);
		
		WebElement SerchBy=cd.findElement(By.id("bas_searchfield"));
		SerchBy.click();
		Select s = new Select(SerchBy);
		s.selectByVisibleText(value1);
		
		cd.findElement(By.xpath("//input[@value=' Search Now ']")).click();
		Thread.sleep(3000);
		
		//logout From Application
		WebElement logout = cd.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		ac.moveToElement(logout).perform();
		Thread.sleep(3000);
		cd.findElement(By.linkText("Sign Out")).click();
		
		cd.close();

	}

}
