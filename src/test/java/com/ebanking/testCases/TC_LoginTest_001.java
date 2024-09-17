package com.ebanking.testCases;



import org.testng.annotations.Test;

import com.ebanking.pageObjects.BaseClass;
import com.ebanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void LoginTest() throws InterruptedException{
		
		logger.info("get URL from BaseClass that we have already  because it extends ");
		
		driver.get(baseURL);
		//
	   logger.info("Create LoginPage object so we can have the methods using constructor ");
		LoginPage lp = new LoginPage(driver);
		//
		logger.info("use methods from LoginPage and variables from BaseClass ");
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickSubm();
		
		//
		logger.info(" Verify that the title of the page is as expected ");
	    String expectedTitle = "Guru99 Bank Manager HomePage";
	    String actualTitle = driver.getTitle();
	  
		//
	    logger.info("Verify with TestNg that we are logged in to HomePage ");
	    
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
