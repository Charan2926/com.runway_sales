package interview_practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class cosmocode_fetch_details {
@Test
public void FetchDetails() throws Throwable {
	
	System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
	WebDriver  driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://cosmocode.io/automation-practice-webtable/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	 List<WebElement>countries = driver.findElements(By.xpath("//table//tr[*]/td[2]"));
	 List<WebElement>currency = driver.findElements(By.xpath("//table//tr[*]//td[4][contains(text(),'Dollar')]"));
	 List<WebElement>language=driver.findElements(By.xpath("//table//tr[*]//td[5][contains(text(),'English')]"));
	 int count =0;
	 for(int i=0;i<currency.size();i++) 
	 {
			 System.out.println(countries.get(i).getText() +"-------"+currency.get(i).getText()+"----"+language.get(i).getText());
			 count++;
			 
			//Create excel sheet
			 FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestScripts_data.xlsx");
			 Workbook wb = WorkbookFactory.create(fi);
			 Sheet sh =wb.createSheet("Data");
				
			//write data into excelsheet 
			 sh.createRow(3).createCell(0).setCellValue(countries.get(i).getText());
			 sh.createRow(3).createCell(1).setCellValue(currency.get(i).getText());
			 sh.createRow(3).createCell(2).setCellValue(language.get(i).getText());
			 
				
			 FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestScripts_data.xlsx");
			 wb.write(fos);
			 wb.close();					
		
	}	 
	 System.out.println(count);
	 driver.close();
  }
}
