package com.XpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olympics_medal_wiseTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> teams =driver.findElements(By.xpath("//div[@class=\"Tablestyles__Wrapper-sc-xjyvs9-0 imdvdL\"]"));
		List<WebElement> gold = driver.findElements(By.xpath("//div[text()='Team']/..//following-sibling::div[@data-cy='header-cell']/div[text()='Gold']"));
		List<WebElement> silver = driver.findElements(By.xpath("//div[text()='Team']/..//following-sibling::div[@data-cy='header-cell']/div[text()='Silver']"));
		List<WebElement> Bronze = driver.findElements(By.xpath("//div[text()='Team']/..//following-sibling::div[@data-cy='header-cell']/div[text()='Bronze']"));
		
		
	}

}
