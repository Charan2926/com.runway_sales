package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crmGenericUtility.WebDriverUtility;

public class SalesOrderPage extends WebDriverUtility{
	//Declaration
	@FindBy(name="search_text")
	private WebElement TextBox;
	
	@FindBy(id="bas_searchfield")
	private WebElement Searchdropdown;
	
	@FindBy(xpath="//input[@value=' Search Now ']")
	private WebElement submitbutton;
	
	@FindBy(xpath="//a[text()='edit']")
	private WebElement editlink;
	
	@FindBy(name="subject")
	private WebElement subtext;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement salesinfo;

    //Initialization
   public SalesOrderPage(WebDriver driver)
   {
	   PageFactory.initElements(driver , this);
   }
    
   //Utilization
   public WebElement getTextBox() {
		return TextBox;
	}

	public WebElement getSearchdropdown() {
		return Searchdropdown;
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}

	public WebElement getEditlink() {
		return editlink;
	}

	public WebElement getSubtext() {
		return subtext;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public WebElement getSalesinfo() {
		return salesinfo;
	}

	//Business Libraries
	public void verify_update_sales(String value,String value1,String value2) {
	TextBox.sendKeys(value);
	Searchdropdown.sendKeys(value1);
	submitbutton.click();
	editlink.click();
	subtext.clear();
	subtext.sendKeys(value2);
	savebtn.click();
	}
	
	public void validateupdatedsales(String exp) {
		String Actual = salesinfo.getText();
		boolean result =Actual.contains(exp);
		Assert.assertTrue(result, "Sales page is not opened");
			
	}
	public void verifyexistingsales (String value,String value1) {
	TextBox.sendKeys(value);	
	select(value1, Searchdropdown);
	submitbutton.click();
	}
}
   
