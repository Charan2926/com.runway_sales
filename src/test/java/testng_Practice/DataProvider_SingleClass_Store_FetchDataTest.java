package testng_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_SingleClass_Store_FetchDataTest {
	
	@DataProvider
	public Object[][] Storedata() {
		
	Object[][] obj = new Object[2][3];
	
	obj[0][0]="qspiders";
	obj[0][1]="hebbal";
	obj[0][2]="manual_testing";
	
	obj[1][0]="Qspiders";
	obj[1][1]="hebbal";
	obj[1][2]="Automation_testing";
	
	return obj;
		
  }
	@DataProvider
	public Object[][] StoreData1() {
		
	Object[][] obj = new Object[2][2];
		
		obj[0][0]="testyantra";
		obj[0][1]="Automation";
		
		obj[1][0]="Testyantra";
		obj[1][1]="manual";
		
		return obj;
	}
	     
	@DataProvider
	public Object[][] storedata2() {
		
	Object[][] obj = new Object[3][3];
	
	obj[0][0]="qspiders";
	obj[0][1]="Testing";
	obj[0][2]= 40000;
	
	obj[1][0]="jspiders";
	obj[1][1]="java";
	obj[1][2]= 40000;
	
	obj[2][0]="pyspiders";
	obj[2][1]="python";
	obj[2][2]= 40000;
	
	return obj;
			
	}
	
	
	/*@Test(dataProvider = "Storedata" )
	public void Fetchdata(String orgname,String branch,String courses) {
		System.out.println("orgname--:"+orgname+"----:branch:"+branch+"----:"+courses);
		
	}*/
	
}
