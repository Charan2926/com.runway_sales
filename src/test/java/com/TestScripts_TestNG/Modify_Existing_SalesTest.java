package com.TestScripts_TestNG;

import org.testng.annotations.Test;

import com.crm.ObjectRepository.Homepage;
import com.crm.ObjectRepository.SalesOrderPage;
import com.crmGenericUtility.BaseClass;

public class Modify_Existing_SalesTest extends BaseClass {
	@Test
	public void modifySalesOrder() throws Throwable {
		
	int random = jlib.getRandomno();
	
	//Get All Data From the Excel Sheet
	String value = elib.readDataFromExcel("salesorder", 0, 1);
	String value1 = elib.readDataFromExcel("salesorder", 1, 1);
	String value2 = elib.readDataFromExcel("salesorder", 2, 1)+random;	
	
	//click on salesorderpage
	Homepage hp = new Homepage(driver);
	hp.clickonMore(driver);
	hp.clickonSales();
			
	//verify and update  sales order
	SalesOrderPage sp = new SalesOrderPage(driver);
	sp.verify_update_sales(value, value1, value2);
	
	//validate the updated salesorder
	sp.validateupdatedsales("Sales Order");		
				
		
	}

}
