package com.TestScripts_TestNG;

import static org.testng.Assert.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.ObjectRepository.CampaignsPage;
import com.crm.ObjectRepository.Homepage;
import com.crmGenericUtility.BaseClass;

@Listeners(com.crmGenericUtility.ExtendsReportClass.class)
public class Navigate_To_Campaigns_Test extends BaseClass {
	
	@Test
	public void navigateToCampaigns() {
		
		
		//click on campaigns link through morebtnlink
		Homepage hp = new Homepage(driver);
		hp.clickonMore(driver);
		//fail();
		hp.clickonCamp();
		
		
		//validation of campaigns page
		CampaignsPage cp = new CampaignsPage();
		cp.verifycamp("Campaigns");
	}

}
