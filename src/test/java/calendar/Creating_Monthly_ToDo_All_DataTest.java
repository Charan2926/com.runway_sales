package calendar;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Creating_Monthly_ToDo_All_DataTest {

	public static void main(String[] args) throws   Throwable {
		
		Random r = new Random();
		int num = r.nextInt(500);
		
		//load the data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String url = pobj.getProperty("Url");
		String browser = pobj.getProperty("Browser");
		String un = pobj.getProperty("Username");
		String pwd = pobj.getProperty("Password");
		
		//Get All Data From the Excel Sheet
		FileInputStream fis2=new FileInputStream(".\\src\\test\\resources\\TestScripts_data.xlsx");
		Workbook wb=WorkbookFactory.create(fis2);
		Sheet sh=wb.getSheet("calendar");
		String tdname = sh.getRow(0).getCell(1).getStringCellValue()+num;
		String description = sh.getRow(1).getCell(1).getStringCellValue();
		String status = sh.getRow(2).getCell(1).getStringCellValue();
		String priority= sh.getRow(3).getCell(1).getStringCellValue();
		String startdate = sh.getRow(4).getCell(1).getStringCellValue();
		//String duedate =sh.getRow(5).getCell(1).getStringCellValue();
		
		//launching browsers and appliction
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//login to the application
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
		//Click on Calendar Module
		driver.findElement(By.linkText("Calendar")).click();
		
		//Click On Month Tab
		driver.findElement(By.xpath("//a[text()='Month']")).click();
		driver.findElement(By.linkText("To Dos")).click();
		
		//Click Add Button
		WebElement calAddButton = driver.findElement(By.xpath("//td[@class='calAddButton']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(calAddButton).perform();
		
		//click on todo
		driver.findElement(By.linkText("To Do")).click();
		
		driver.findElement(By.name("task_subject")).sendKeys(tdname);
		driver.findElement(By.name("task_description")).sendKeys(description);
		
		//Select Task Status
		WebElement taskStatus = driver.findElement(By.id("taskstatus"));
		Select s = new Select(taskStatus);
		s.selectByVisibleText("Planned");
		
		//Select Task Priority
		WebElement taskPriority = driver.findElement(By.id("taskpriority"));
		Select s1 = new Select(taskPriority);
		s1.selectByVisibleText("High");
		
		//Select Assign To
		driver.findElement(By.xpath("(//input[@name='task_assigntype'])[2]")).click();
		WebElement assignTo = driver.findElement(By.name("task_assigned_group_id"));
		Select s2 = new Select(assignTo);
		s2.selectByVisibleText("Marketing Group");
		
		
		//Select Start Date
		driver.findElement(By.id("jscal_trigger_task_date_start")).click();
		WebElement sd=driver.findElement(By.id("task_date_start"));
		sd.clear();
		sd.sendKeys(startdate);
		
		//Select Start Date
		driver.findElement(By.xpath("//td[text()='December, 2023']/ancestor::thead/child::tr[@class=\"headrow\"]/td[text()='Today']/parent::tr/following-sibling::tr/child::td[text()='Wed']/ancestor::table/child::tbody/child::tr/td[text()='6']")).click();
//		driver.findElement(By.id("jscal_trigger_task_due_date")).click();
//		WebElement ed=driver.findElement(By.xpath("//input[@id='task_due_date']"));
//		ed.clear();
//		ed.sendKeys("2023-10-28");		
		
		/*//Select End Date
		driver.findElement(By.id("jscal_trigger_task_due_date")).click();
		driver.findElement(By.xpath("//div[@class='calendar']/descendant::td[contains(text(),'August, 2023')]/../../following-sibling::tbody//tr[2]//td[contains(text(),'10')]")).click();*/
		
		//Click on Save Button
		//driver.navigate().refresh();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@alt='Save [Alt+S]'])[2]")).click();
		Thread.sleep(3000);
		
		//validating the page is opened or not
		String  ele = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
		if(ele.contains("Calendar")) 
		{
			System.out.println("Calendar page is opened sucessfully");
		}
		else
		{
			System.out.println("Calendar page loading is failed");
		}		
		 
		//logout of the application
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		ac.moveToElement(logout).click().perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();		
		
		driver.close();
	 }
	}