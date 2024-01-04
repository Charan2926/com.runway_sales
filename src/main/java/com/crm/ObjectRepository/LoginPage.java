package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Declaration
	@FindBy(name="user_name")
	private WebElement username;
	
    @FindBy(name="user_password")
    private WebElement password;
    
    @FindBy(id="submitButton")
    private WebElement loginbutton;
    
    //Intialiazation
     public LoginPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }

    //Declaration
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	//Business Libraries
	public void Loginpage(String Username,String Password ) {
	username.sendKeys(Username);
	password.sendKeys(Password);
	loginbutton.click();	
	}

	
    
	
	

}
