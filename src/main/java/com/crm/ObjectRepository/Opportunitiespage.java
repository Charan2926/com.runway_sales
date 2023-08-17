package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crmGenericUtility.WebDriverUtility;


public class Opportunitiespage extends WebDriverUtility {
	//Declaration
	
	@FindBy(xpath="//img[@alt='Create Opportunity...']")
	private WebElement opplookupimage;
	
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement Oppinfo;
	
	//intialiazation
	public void Opportunitypage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utiliazation
	public WebElement getOpplookupimage() {
		return opplookupimage;
	}
	
	public WebElement getOppinfo() {
		return Oppinfo;
	}

	//Business Libraries 
	public void clickoncreatenewopp() {
	opplookupimage.click();
	}
	
	public void validateopp(String Exp) 
	{
		String actual = Oppinfo.getText();
		boolean result =actual.contains(Exp);
		Assert.assertTrue(result, "opp page is not oponed ");
    }
}

