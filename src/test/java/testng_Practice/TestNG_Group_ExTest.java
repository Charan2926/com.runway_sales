package testng_Practice;

import org.testng.annotations.Test;

import com.crmGenericUtility.BaseClass;

public class TestNG_Group_ExTest extends BaseClass {
	@Test 
	public void test1()
	{
		System.out.println("Testclass 4 =>test1");
	}
	@Test 
	public void test2()
	{
		System.out.println("Testclass 4 =>test2");
	}

}
