package testng_Practice;

import org.testng.annotations.Test;

import com.crmGenericUtility.BaseClass;

public class TestNG_Batch_ExecutionTest extends BaseClass {
	
	@Test
	public void test1()
		{
			System.out.println("Testclass1 =>test1");
		}
	@Test 
	public void test2()
	{
		System.out.println("Testclass1 =>test2");
	}



}
