package com.TestScripts_TestNG;

import org.testng.annotations.Test;

import com.crm.ObjectRepository.Create_OpportunitiesPage;
import com.crm.ObjectRepository.Homepage;
import com.crm.ObjectRepository.Opportunitiespage;
import com.crmGenericUtility.BaseClass;

public class Navigate_To_Opportunities_Test extends BaseClass{
	
	@Test(groups = {"smoke"})
	public void navigateToOpp() {
		
		//click on opportunities link
		Homepage hp = new Homepage(driver);
		hp.clickonOpp();
				
		//validation of opportunity page 
	    Opportunitiespage op = new Opportunitiespage();
		op.validateopp("Opportunities");
	}

}
