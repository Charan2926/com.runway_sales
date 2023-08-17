package salesorder;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit_Update_SalesOrderTest {

	public static void main(String[] args) throws InterruptedException, Throwable {
		
        //ReadData from properties file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String url = pobj.getProperty("Url");
		String browser = pobj.getProperty("Browser");
		String username = pobj.getProperty("Username");
		String password = pobj.getProperty("Password");
		
		//Read data from excel file
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		String value = book.getSheet("Sheet4").getRow(0).getCell(1).getStringCellValue();
		String value1 = book.getSheet("Sheet4").getRow(1).getCell(1).getStringCellValue();
		String value2 = book.getSheet("Sheet4").getRow(2).getCell(1).getStringCellValue();

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
	
		driver.manage().window().maximize();
		
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//login to application 
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		WebElement ele = driver.findElement(By.xpath("//a[text()='More']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).click().perform();
		
		driver.findElement(By.name("Sales Order")).click();
		
		driver.findElement(By.name("search_text")).sendKeys(value);
		
		WebElement ele1 = driver.findElement(By.name("search_field"));
		Select s=new Select(ele1);
		s.selectByVisibleText(value1);
		
		Thread.sleep(3000);
		driver.findElement(By.name("submit")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='edit']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.name("subject")).clear();
		driver.findElement(By.name("subject")).sendKeys(value2);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validation steps
		WebElement ele2 = driver.findElement(By.xpath("(//a[text()='Sales Order'])[3]"));
		String text = ele2.getText();
		if(text.contains("Sales Order"))
		{
			System.out.println("updated sales order is visible");
		}
		else
		{
			System.out.println("sales order is not updated");
		}
		
		//logout of the application
		WebElement findElement = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions act1=new Actions(driver);
		 act1.moveToElement(findElement).click().perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
