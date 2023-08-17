package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmGenericUtility.WebDriverUtility;

public class Homepage extends WebDriverUtility{
	
	//declaration
	@FindBy(xpath="//a[text()='Calendar']")
	private WebElement calendarlink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportuntieslink;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement morelink;

	@FindBy(linkText="Campaigns")
	private WebElement Campaignslink;
	
	@FindBy(linkText="Sales Order")
	private WebElement Salesorderlink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutoptionlink;
	
	@FindBy(linkText="Sign Out")
	private WebElement logoutlink;
	
	//Intialiazation
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	//Utilization
	
	public WebElement getCalendarlink() {
		return calendarlink;
	}

	public WebElement getOpportuntieslink() {
		return opportuntieslink;
	}
	
	public WebElement getMoreMousehover() {
		return morelink;
	}

	public WebElement getCampaignslink() {
		return Campaignslink;
	}

	public WebElement getSalesorderlink() {
		return Salesorderlink;
	}

	public WebElement getLogoutoptionlink() {
		return logoutoptionlink;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}
	
	//Business Libraries
	public void clickoncalendar() {
		calendarlink.click();	
	}
	public void clickonOpp() {	
		opportuntieslink.click();
	}
	public void clickonMore(WebDriver driver) {
		mousehover(driver, morelink);
	}
	public void clickonCamp() {
		Campaignslink.click();
	}
	public void clickonSales() {
		Salesorderlink.click();
	}
	public void logout(WebDriver driver) {
	logoutoptionlink.click();
	mousehover(driver, logoutlink);
	}
	
}
	

