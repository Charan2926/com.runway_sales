package testng_Practice;

import org.testng.annotations.Test;

public class Use_PriorityTest {
	
	@Test(priority=1)
	public void createdata() {
		System.out.println("-------------Data is creted------------");
	}
	
	@Test(priority =2)
	public void editdata() {
		System.out.println("-------Edited and updated the data--------------");
	}
	
	@Test(priority =-1)
	public void deletedata() {
		System.out.println("-----------deleted the data-------------");
	}
	

	

}
