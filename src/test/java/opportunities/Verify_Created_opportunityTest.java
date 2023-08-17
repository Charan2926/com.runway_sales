package opportunities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.crmGenericUtility.DataBaseUtility;
import com.crmGenericUtility.ExcelUtility;
import com.crmGenericUtility.FileUtility;
import com.crmGenericUtility.JavaUtility;
import com.crmGenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_Created_opportunityTest {

	public static void main(String[] args) throws Throwable {
		//Read the data from propertyfile
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
	
		String url= pObj.getProperty("Url");
		String browser= pObj.getProperty("Browser");
		String username= pObj.getProperty("Username");
		String password= pObj.getProperty("Password");
		
		
		//Read data from excel file
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		String oppname = book.getSheet("opportunities").getRow(0).getCell(1).getStringCellValue();
		String salesstage = book.getSheet("opportunities").getRow(1).getCell(1).getStringCellValue();
		String orgname = book.getSheet("opportunities").getRow(2).getCell(1).getStringCellValue();
		
	    //Launching the browsers
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//click on opportunity link
		driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
		
		//click on create opportunity lookup image
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		
		//enter details into all the text fields
		driver.findElement(By.name("potentialname")).sendKeys(oppname);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		Thread.sleep(2000);
		
		//switching between windows
		String parent = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		
		for (String handle : handles) 
		{
			if(!handle.equals(parent)) 
			{
				driver.switchTo().window(handle);
				driver.findElement(By.xpath("//a[text()='qspiders']")).click();
				Thread.sleep(2000);
			}
		}
		driver.switchTo().window(parent);
		driver.findElement(By.id("jscal_trigger_closingdate")).click();
		driver.findElement(By.xpath("//div[@class='calendar']/following-sibling::div[@class='calendar']/descendant::td[text()='August, 2023']/ancestor::div[@class='calendar']//tbody/descendant::td[contains(@class,'day') and text()='03' and not(contains(@class,'wn'))]")).click();
	    
		driver.close();
	}
	

}
