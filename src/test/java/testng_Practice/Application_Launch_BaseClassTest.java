package testng_Practice;

import org.testng.annotations.Test;

import com.crmGenericUtility.BaseClass;

public class Application_Launch_BaseClassTest extends BaseClass{
	
	@Test
	public void launchapp() {
		System.out.println("-----launching the appliction-----");
	}

}
