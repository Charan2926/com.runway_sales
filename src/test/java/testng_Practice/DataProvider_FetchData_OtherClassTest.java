package testng_Practice;

import org.testng.annotations.Test;

public class DataProvider_FetchData_OtherClassTest {
	
	@Test(dataProviderClass = DataProvider_SingleClass_Store_FetchDataTest.class,dataProvider="Storedata")
	public void FetchData(String orgname,String branch,String courses) {
		System.out.println("orgname--:"+orgname+"----:branch:"+branch+"----:"+courses);
	}
	
	@Test(dataProviderClass = DataProvider_SingleClass_Store_FetchDataTest.class,dataProvider = "StoreData1")
	public void Fetchdata(String comname,String project) {
	System.out.println("company_name :"+ comname +"----project name:"+project);
		
	}
	
	@Test(dataProviderClass = DataProvider_SingleClass_Store_FetchDataTest.class,dataProvider = "storedata2")
	public void Fetchdata(String instname,String subname,int coursefee) {
	System.out.println("Institute_name:"+instname +"----Subject_name:"+subname+"----cousrefee-:"+coursefee);
		
	}

}
