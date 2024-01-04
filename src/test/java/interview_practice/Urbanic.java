package interview_practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Urbanic {
	@Test
	public void clothesfilter() {
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver  driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.urbanic.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[text()='DENIM']")).click();
		
		WebElement ele=driver.findElement(By.xpath("(//a[@class='index-module_thirdCatName__Irl2t'])[1] "));
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().perform();
		
		driver.findElement(By.xpath("//span[text()='SHOW FILTERS']")).click();
		
		WebElement elem=driver.findElement(By.xpath("(//span[@class=\"PriceRange--SliderThumb--Hq74c3F\"])[2]"));
		
		Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(elem, -135, 0).build();
        action.perform();
        
       List<WebElement>item=driver.findElements(By.xpath("//div[@class=\"index-module_title__g60Zr\"]"));
       List<WebElement>Price= driver.findElements(By.xpath("//span[@class='index-module_price__-SuVE']"));
       for(int i=0;i<Price.size();i++) 
       {
    	   System.out.println(item.get(i).getText()+"---------"+Price.get(i).getText());
  		 
       }
       
        driver.close();	
	}
}
