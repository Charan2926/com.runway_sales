 package testng_Practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_AssertTest {
	@Test
	public void demo() {
		System.out.println("hi");
		System.out.println("hello");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals("hi", "hello");
		soft.assertAll();
	}
	@Test
	public void demo1() {
		System.out.println("Qspiders");
		System.out.println("Testyantra");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals("Qspiders", "TestYantra");
		System.out.println("Both are related");
		//soft.assertAll();
	}
	@Test
	public void demo2()
	{
		String s="hi";
		String s1="hello";
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(s, s1);
		System.out.println(s);
		System.out.println(s1);
		System.out.println(s+s1);
		//soft.assertAll();
		Reporter.log("Test case is passed");
  }

}
