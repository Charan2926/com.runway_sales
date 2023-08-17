package testng_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crmGenericUtility.ExcelUtility;

public class Data_Provider_FetchData_ExcelUtilityTest {
	
	@DataProvider
	public Object[][] getdatafromexcelUtility() throws Throwable {
		ExcelUtility elib = new ExcelUtility();
		Object[][] value = elib.DPMultipleDataFromExcel("DataProvider");
		return value;
	}
	
	@Test(dataProvider ="getdatafromexcelUtility" )
	public void fetchData(String subject,String topics,String faculty,String daysTaken) {
		System.out.println("Subject----:"+subject+"   Topics-----:"+topics+"  faculty-------:"+faculty+"  DaysTaken---:"+daysTaken);
		
	}
 
}
