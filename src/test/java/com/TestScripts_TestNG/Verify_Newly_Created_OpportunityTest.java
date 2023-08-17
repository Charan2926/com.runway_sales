package com.TestScripts_TestNG;

import org.testng.annotations.Test;

import com.crm.ObjectRepository.Create_OpportunitiesPage;
import com.crm.ObjectRepository.Homepage;
import com.crm.ObjectRepository.Opportunitiespage;
import com.crmGenericUtility.BaseClass;

public class Verify_Newly_Created_OpportunityTest extends BaseClass {
	
	@Test
	public void verifyCreatedOpp() throws Throwable {
		
	//Get All Data From the Excel Sheet
	String oppname = elib.readDataFromExcel("opportunities", 0, 1);
	String salesstage= elib.readDataFromExcel("opportunities", 1, 1);
	String orgname = elib.readDataFromExcel("opportunities", 2, 1);
	String date = elib.readDataFromExcel("opportunities", 3, 1);
	
	//click on  to the opportunities link
	Homepage hp = new Homepage(driver);
	hp.clickonOpp();
		
	//click on create opportunity link
    Opportunitiespage op = new Opportunitiespage();
    op.clickoncreatenewopp();
	
	//Pass Data into create opportunity page
	Create_OpportunitiesPage cop = new Create_OpportunitiesPage();
	cop.createnewopp(oppname, driver, orgname, salesstage, date);
	
	//validate the opportunities page
	cop.validateopp("Opportunities");
		
	
	
	
	}

}
