package com.TestScripts_TestNG;

import org.testng.annotations.Test;
import com.crm.ObjectRepository.Homepage;
import com.crm.ObjectRepository.SalesOrderPage;
import com.crmGenericUtility.BaseClass;

public class Verify_Exsiting_SalesOrder_Using_SubjectTest extends BaseClass{
	
	@Test
	public void verifyExistingSales() throws Throwable {
		
		//Getting data frome excel file
		String value = elib.readDataFromExcel("SalesOrder", 0,1);
		String value1 = elib.readDataFromExcel("SalesOrder", 2,1);
		
		//click on salesorder
		Homepage hp = new Homepage(driver);
		hp.clickonMore(driver);
		hp.clickonSales();
				
		//verify existing salesoder
		SalesOrderPage sp = new SalesOrderPage(driver);
		sp.verifyexistingsales(value, value1);
		
		//validating the salesorderpage
		sp.validateupdatedsales("Sales Order");
		
	}

}
