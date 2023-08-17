 package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crmGenericUtility.WebDriverUtility;

public class CalendarPage extends WebDriverUtility {
	
	//Declaration
	@FindBy(xpath="//a[text()='Month']")
	private WebElement monthlink;
	
	@FindBy(linkText="To Dos")
	private WebElement todoslink;
	
	@FindBy(xpath="//td[@class='calAddButton']")
	private WebElement addlink;
	
	@FindBy(linkText="To Do")
	private WebElement todolink;
	
	@FindBy(name="task_subject")
	private WebElement Todoname;
	
	@FindBy(name="task_description")
	private WebElement Description;
	
	@FindBy(id="taskstatus")
	private WebElement statusdropdown;
	
	@FindBy(id="taskpriority")
	private WebElement prioritydropdown;
	
	@FindBy(xpath="(//input[@name='task_assigntype'])[2]")
	private WebElement assignedradiobtn;
	
	@FindBy(id="task_date_start")
	private WebElement setdatepopup;
	
	@FindBy(id="task_due_date")
	private WebElement duedatepopup;
	
	@FindBy(name="todosave")
	private WebElement savelink;
	
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement calinfo;
	
	//Intialization
	

	public CalendarPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getMonthlink() {
		return monthlink;
	}

	public WebElement getTodoslink() {
		return todoslink;
	}

	public WebElement getAddlink() {
		return addlink;
	}

	public WebElement getTodolink() {
		return todolink;
	}

	public WebElement getTodoname() {
		return Todoname;
	}

	public WebElement getDescription() {
		return Description;
	}

	public WebElement getStatusdropdown() {
		return statusdropdown;
	}

	public WebElement getPrioritydropdown() {
		return prioritydropdown;
	}
	
	public WebElement getAssignedradiobtn() {
		return assignedradiobtn;
	}

	public WebElement getSetdatepopup() {
		return setdatepopup;
	}

	public WebElement getDuedatepopup() {
		return duedatepopup;
	}

	public WebElement getSavelink() {
		return savelink;
	}
	
	
	public WebElement getCalinfo() {
		return calinfo;
	}
	
	//Business Libraries
	public void clickonlinks(WebDriver driver){
		monthlink.click();
		todoslink.click();
		addlink.click();
		mousehover(driver, todolink);	
	}
	public void createTodoall(String tdname,String description,String status,String priority,String startdate) {
		Todoname.sendKeys(tdname);
		Description.sendKeys(description);
	    select( status,statusdropdown);
	    select(priority, prioritydropdown);
	    assignedradiobtn.click();
	    setdatepopup.sendKeys(startdate);
	    //duedatepopup.sendKeys(duedate);	
	}
	//validating the page is opened or not
	public void validate(String Exp) {
		String Actual = calinfo.getText();
		boolean result =Actual.contains(Exp);
		Assert.assertTrue(result, "Calendar to do is not created ");
			
	}
}
