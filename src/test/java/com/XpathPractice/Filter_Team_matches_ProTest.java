package com.XpathPractice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Filter_Team_matches_ProTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		String team="Bengaluru Bulls";

		WebElement matchplayed = driver.findElement(By.xpath("//p[text()='"+team+"']/../../../../descendant::div[@class='table-data matches-play']"));
		WebElement matchwon = driver.findElement(By.xpath("//p[text()='"+team+"']/../../../../descendant::div[@class='table-data matches-won']"));
		WebElement lost = driver.findElement(By.xpath("//p[text()='"+team+"']/../../../../descendant::div[@class='table-data matches-lost']"));
		WebElement tie=driver.findElement(By.xpath("//p[text()='"+team+"']/../../../../descendant::div[@class='table-data matches-draw']"));
		System.out.println(team+": " + "match played "+matchplayed.getText()+"  "+"match won "+matchwon.getText()+"  "+"match lost "+ lost.getText()+"  "+"match tied "+ tie.getText());
		
        driver.close();
	}

}
