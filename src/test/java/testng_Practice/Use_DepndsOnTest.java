package testng_Practice;

import org.testng.annotations.Test;

public class Use_DepndsOnTest {
	
	@Test(dependsOnMethods = "editdata")
	public void createdata() {
		System.out.println("-------------Data is crea ted------------");
	}
	
	@Test
	public void editdata() {
		int a[]= {1,2,3};
		System.out.println(a[4]);
		System.out.println("------updated the data");
	}
	
	@Test
	public void deletedata() {
		System.out.println("-----------deleted the data-------------");
	}
	

}
