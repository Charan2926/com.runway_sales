package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crmGenericUtility.WebDriverUtility;

public class Create_OpportunitiesPage extends WebDriverUtility {
	//Declaration
	@FindBy(name="potentialname")
	private WebElement oppname;

	@FindBy(xpath ="//img[@src='themes/softed/images/select.gif']")
	private WebElement relatedtowindowhandles;
	
	@FindBy(name="search_text")
	private WebElement searchtext;
	
	@FindBy(name="search")
	private WebElement submitbtn;
	
	@FindBy(id="jscal_trigger_closingdate")
	private WebElement enddate;
	
	@FindBy(name="sales_stage")
	private WebElement salesdropdown;
	
	@FindBy(name="button")
	private WebElement savebtn;
	
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement Oppinfo;
	
	
	//intialiazation
	public void Create_OpportunityPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}	
	
	//Utiliazation
	public WebElement getOppname() {
		return oppname;
	}

	public WebElement getRelatedtowindowhandles() {
		return relatedtowindowhandles;
	}
	
	
	public WebElement getSearchtext() {
		return searchtext;
	}
	
	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	public WebElement getEnddate() {
		return enddate;
	}
	
	public WebElement getSalesdropdown() {
		return salesdropdown;
	}
	
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public WebElement getOppinfo() {
		return Oppinfo;
	}

	//Business Libraries
	public void validateopp(String Exp) 
	{
		String actual = Oppinfo.getText();
		boolean result =actual.contains(Exp);
		Assert.assertTrue(result, "opp is not verified");
    }
	
	public void createnewopp(String newoppname,WebDriver driver,String orgname,String sales,String date) {
	oppname.sendKeys(newoppname);
	relatedtowindowhandles.click();
	switchtowindow(driver, "Accounts");
	searchtext.sendKeys(orgname);
	submitbtn.click();	
	driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
	switchtowindow(driver, "Potentials");
	enddate.clear();
	enddate.sendKeys(date);
    select(sales, salesdropdown);
	savebtn.click();
	
	}		

}
