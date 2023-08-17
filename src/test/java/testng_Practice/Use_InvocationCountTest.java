package testng_Practice;

import org.testng.annotations.Test;

public class Use_InvocationCountTest {
	
	@Test(invocationCount=3)
	public void createdata() {
		System.out.println("-------------Data is creted------------");
	}
	
	@Test(invocationCount =2)
	public void editdata() {
		System.out.println("-------Edited and updated the data--------------");
	}
	
	@Test(invocationCount =-1)
	public void deletedata() {
		System.out.println("-----------deleted the data-------------");
	}

}
