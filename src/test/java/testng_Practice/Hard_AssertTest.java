package testng_Practice;

import  org.testng.Assert;
import org.testng.annotations.Test;

public class Hard_AssertTest {
	
	@Test
	public void demo() 
	{
		System.out.println("-----------step1-------------");
		System.out.println("-----------step2-------------");
		Assert.assertEquals("a", "b");
		System.out.println("-----------step3-------------");
		System.out.println("-----------step4-------------");
		System.out.println("-----------step5-------------");
	}
	
	@Test
	public void demo1()
	{
		String s="hi";
		String s1="hi";
		Assert.assertEquals(s,s1);
		System.out.println(s);
		System.out.println(s1);
		System.out.println(s+s1);
  }
}
