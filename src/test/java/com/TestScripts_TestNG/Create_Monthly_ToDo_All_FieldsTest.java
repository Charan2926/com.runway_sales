package com.TestScripts_TestNG;

import static org.testng.Assert.fail;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.ObjectRepository.CalendarPage;
import com.crm.ObjectRepository.Homepage;
import com.crmGenericUtility.BaseClass;

//@Listeners(com.crmGenericUtility.ExtendsReportClass.class)
public class Create_Monthly_ToDo_All_FieldsTest extends BaseClass{
	
	@Test(groups = "system")
	public void monthlyTodoAllFields() throws Throwable {
		
	int random = jlib.getRandomno();	
	//Get All Data From the Excel Sheet
	String tdname=elib.readDataFromExcel("calendar", 0, 1)+random;
	String description =elib.readDataFromExcel("calendar", 1, 1);
	String status = elib.readDataFromExcel("calendar", 2, 1);
	String priority =elib.readDataFromExcel("calendar", 3, 1);
	String startdate = elib.readDataFromExcel("calendar", 4, 1);
	
	//click on calendarlink
	Homepage hp = new Homepage(driver);
	hp.clickoncalendar();
		
     fail();
	//click on create todo by passing data
	CalendarPage cp = new CalendarPage(driver);
	cp.clickonlinks(driver);
	
	//create Todo with all fields in calendarpage
	cp.createTodoall(tdname, description, status, priority, startdate);
			
	//validation of created todo 
	cp.validate("Calendar");
			
	}

}
