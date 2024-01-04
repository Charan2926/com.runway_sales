package testng_Practice;

import org.testng.annotations.Test;

import com.crmGenericUtility.BaseClass;

public class Running_Muliple_TestsTest extends BaseClass {
	@Test
	public void createdata() {
		System.out.println("-------------Data is creted------------");
	}
	
	@Test
	public void editdata() {
		System.out.println("-------Edited and updated the data--------------");
	}
	
	@Test
	public void deletedata() {
		System.out.println("-----------deleted the data-------------");
	}
	

}
