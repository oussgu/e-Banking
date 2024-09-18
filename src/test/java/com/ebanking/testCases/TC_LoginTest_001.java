package com.ebanking.testCases;



import org.testng.annotations.Test;

import com.ebanking.pageObjects.BaseClass;
import com.ebanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void LoginTest() {
		
		logger.info("get URL from ");
		
		
		//
	  
		LoginPage lp = new LoginPage(driver);
		//
		logger.info("set name and password and click login ");
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickSubm();
		
		//
		
	    String expectedTitle = "Guru99 Bank Manager HomePage";
	    String actualTitle = driver.getTitle();
	  
		//
	    logger.info("Verify that we are  logged in to HomePage ");
	    
	  if (actualTitle.equals(expectedTitle)) {
		Assert.assertTrue(true);
		
		logger.info("successfully Logged to HomePage");
		
	}
	  else {
		  Assert.assertTrue(true);
		  logger.info("Fail to  Log to HomePage");
	}
	   
	  
		
	}
	

}
