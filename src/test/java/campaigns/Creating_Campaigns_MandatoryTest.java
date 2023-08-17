package campaigns;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Creating_Campaigns_MandatoryTest {

	public static void main(String[] args) throws IOException {
		
		       //fetch data from properties file
				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
				Properties pObj = new Properties();
				pObj.load(fis);
				String Url = pObj.getProperty("Url");
				String Browser = pObj.getProperty("Browser");
				String Username = pObj.getProperty("Username");
				String Password = pObj.getProperty("Password");
				
				//excel test data
				FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestCase_data.xlsx");
				Workbook book = WorkbookFactory.create(fi);
				Sheet sh =book.getSheet("campaigns");
				String campname = sh.getRow(0).getCell(1).getStringCellValue();
				String date= sh.getRow(1).getCell(1).getStringCellValue();
				
				 //Launching the browsers
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(Url);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElement(By.name("user_name")).sendKeys(Username);
				driver.findElement(By.name("user_password")).sendKeys(Password);
				driver.findElement(By.id("submitButton")).click();
				
				driver.findElement(By.xpath("//a[text()='More']")).click();
				driver.findElement(By.linkText("Campaigns")).click();
				driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
				
				driver.findElement(By.name("campaignname")).sendKeys(campname);
				driver.findElement(By.xpath("//input[@type='radio'][2]")).sendKeys(date);
				
				driver.findElement(By.id("massedit_calendar_closingdate")).click();
				
				

				

	}

}
