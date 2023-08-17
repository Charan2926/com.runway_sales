package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CampaignsPage {
	
	//Declaration
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createOpplink;
	
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement Campinfo;
	
	//Intialization
	public void CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization
	public WebElement getAddimagelink() {
		return createOpplink;
	}
	
	public WebElement getCampinfo() {
		return Campinfo;
	}

	//Business Libraries
	public void clickoncreatecamp() {
	createOpplink.click();
	}
	
	public void verifycamp(String exp) {
		String Actual =Campinfo.getText();
		boolean result = Actual.contains(exp);
		Assert.assertTrue(result, "campaings page is not opened ");
  }
}
