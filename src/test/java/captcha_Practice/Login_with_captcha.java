package captcha_Practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Login_with_captcha {
	@Test
	public void Text_captcha() throws IOException, InterruptedException, TesseractException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver  driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//a[@class='search_btn loginText ng-star-inserted']")).click();
		WebElement ele=driver.findElement(By.xpath("//img[@class='captcha-img']"));
		Thread.sleep(2000);
		File src = ele.getScreenshotAs(OutputType.FILE);
		String path ="C:\\Users\\Nani\\eclipse-workspace\\com.RunWaySales(main)\\ScreenShot\\img.png";
		org.openqa.selenium.io.FileHandler.copy(src, new File(path));
		Thread.sleep(2000);
		
		ITesseract tess = new Tesseract();
		tess.setDatapath("C:\\Users\\Nani\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
		String text =tess.doOCR(new File(path));
		System.out.println(text);
		
		driver.findElement(By.id("captcha")).sendKeys(text);
		driver.findElement(By.xpath("//button[text()='SIGN IN']")).click();
		Thread.sleep(2000);
		//driver.close();
		   
	}
	

}
