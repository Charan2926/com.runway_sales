package testng_Practice;

import org.testng.annotations.Test;

import com.crmGenericUtility.BaseClass;

public class TestNg_Group_ExeTest extends BaseClass  {
	@Test 
	public void test1()
	{
		System.out.println("Testclass 3 =>test1");
	}
	@Test 
	public void test2()
	{
		System.out.println("Testclass 3 =>test2");
	}

}
