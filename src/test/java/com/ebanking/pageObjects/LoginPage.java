package com.ebanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Attributes (Driver)
	
	 WebDriver driver;

	
	//Creating the Constructor with PageFactory Object
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//All Elements 
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	//All Methods 
	
	public void setUserName( String uname) {
	
    txtUserName.sendKeys(uname);}
	
	public void setPassword( String pwd) {
		
	    txtPassword.sendKeys(pwd);}
	
	public void clickSubm( ) {
		
	    btnLogin.click();}
	
	
	
	
	
	
	
	
	
	
	
}
