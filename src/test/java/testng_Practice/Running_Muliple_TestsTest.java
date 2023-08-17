package testng_Practice;

import org.testng.annotations.Test;

public class Running_Muliple_TestsTest {
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
