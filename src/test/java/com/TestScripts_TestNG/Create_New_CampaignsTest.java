package com.TestScripts_TestNG;

import org.testng.annotations.Test;

import com.crm.ObjectRepository.CampaignsPage;
import com.crm.ObjectRepository.Create_CampaignsPage;
import com.crm.ObjectRepository.Homepage;
import com.crmGenericUtility.BaseClass;

public class Create_New_CampaignsTest extends BaseClass{
	
	@Test(groups = {"system"})
	public void createNewCamp() throws Throwable {
		
		
		//Read data from excel
		String campname = elib.readDataFromExcel("campaigns", 0, 1);
		String date = elib.readDataFromExcel("campaigns", 1, 1);
		
		//click on campaings page
	    Homepage hp = new Homepage(driver);
	    hp.clickonMore(driver);
	    hp.clickonCamp();
	    
	    //click on create campaigns page
	    CampaignsPage cp = new CampaignsPage();
	    cp.clickoncreatecamp();
	     
	    //Create new campaign with entering data to mandatory fields
	    Create_CampaignsPage ccp = new Create_CampaignsPage(driver);
	    ccp.creatcamp(campname, date);
	    
	    //validation of created campaigns
	    ccp.verifycamp("Campaigns");
	    
		
	}

}
