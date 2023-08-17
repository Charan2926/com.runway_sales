package testng_Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_Annotations_Mul_TestScriptsTest {
	
	 @BeforeSuite
	  public void config_BS()
	  {
		System.out.println("--------connect to Database-----");
	  }
	  
	  @BeforeClass
	  public void config_BC() 
	  {
		  System.out.println("--------open the browser------");  
	  }
	  
	  @BeforeMethod
	  public void config_BM()
	  {
		  System.out.println("--------Login to the application------");
	  }
	  
	  @Test
	  public void testScript() 
	  {
		  System.out.println("-------excute the first test_script--------");
	  }
	  
	  @Test
	  public void testScript1() 
	  {
		  System.out.println("-------excute the second  test_script--------");
	  }
	  
	  @AfterMethod
	  public void config_AM()
	  {
		  System.out.println("-------logout from the application---------");
	  }
	  
	  @AfterClass
	  public void config_AC() 
	  {
		  System.out.println("--------close the Broswer--------");
	  }

	  @AfterSuite
	  public void config_AS() {
		  System.out.println("--------close database connection----------");
	  }

}
