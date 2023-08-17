package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crmGenericUtility.WebDriverUtility;

public class Create_CampaignsPage extends WebDriverUtility{
	
	//Declaration
	
	@FindBy(name="campaignname")
	private WebElement Campname;
	
	@FindBy(xpath="//input[@type='radio'][2]")
	private WebElement assignradiobtn;
	
	@FindBy(id="massedit_calendar_closingdate")
	private WebElement datepopup;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement Campinfo;
	
	//Initialization
	public Create_CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	
	//Utilization
    public WebElement getCampname() {
		return Campname;
	}

	public WebElement getAssignradiobtn() {
		return assignradiobtn;
	}

	public WebElement getDatepopup() {
		return datepopup;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	public WebElement getCampinfo() {
		return Campinfo;
	}

	//Business Libraries
	
	public void verifycamp(String exp) {
	String Actual =Campinfo.getText();
	boolean result = Actual.contains(exp);
	Assert.assertTrue(result, "campaings page is not opened ");
  }
	public void creatcamp(String campname,String date) {
	Campname.sendKeys(campname);
	assignradiobtn.click();
	datepopup.sendKeys(date);
	savebutton.click();
	}
}
