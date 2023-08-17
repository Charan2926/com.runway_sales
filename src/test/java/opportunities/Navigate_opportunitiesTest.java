	package opportunities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigate_opportunitiesTest {
		
	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String url= pObj.getProperty("Url");
		String browser= pObj.getProperty("Browser");
		String un= pObj.getProperty("Username");
		String pwd= pObj.getProperty("Password");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		
		//Launch the application
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//login to the application
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Opportunities")).click();
		Thread.sleep(2000);
		
		String  ele = driver.findElement(By.linkText("Opportunities")).getText();
		if(ele.contains("Opportunities")) 
		{
			System.out.println("opportunities page is opened sucessfully");
		}
		else {
			System.out.println("opportunities page loading is failed");
		}
		driver.close();
		
	}
		
}
	

