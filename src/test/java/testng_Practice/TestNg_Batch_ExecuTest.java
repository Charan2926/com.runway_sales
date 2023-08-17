package testng_Practice;

import org.testng.annotations.Test;

import com.crmGenericUtility.BaseClass;

public class TestNg_Batch_ExecuTest extends BaseClass {
	
	
		@Test (groups = "regression")
		public void test1()
		{
			System.out.println("Testclass2 =>test1");
		}
		@Test 
		public void test2()
		{
			System.out.println("Testclass2 =>test2");
		}
   }
