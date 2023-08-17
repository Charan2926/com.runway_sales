package testng_Practice;

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
	
	public void demo1() {
		System.out.println("Qspiders");
		System.out.println("Testyantra");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals("Qspiders", "TestYantra");
		System.out.println("Both are related");
	}

}
