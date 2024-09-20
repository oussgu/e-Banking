package com.ebanking.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ebanking.pageObjects.BaseClass;
import com.ebanking.pageObjects.AddCustomerPage;
import com.ebanking.pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;


public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("User name is provided");
		lp.setPassword(password);
		
		logger.info("Passsword is provided");
		lp.clickSubm();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
	
		addcust.custName("oussama");
		addcust.custgender("male");
		Thread.sleep(3000);
		addcust.custdob("11","15","1993");
		Thread.sleep(3000);
		addcust.custaddress("Canada");
		addcust.custcity("MTL");
		addcust.custstate("QC");
		addcust.custpinno("204512");
		addcust.custtelephoneno("5142343010");
		
		String email=randomestring()+"@gmail.com";
		
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreenshot(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}

	private String randomestring() {
		String generateString = RandomStringUtils.randomAlphabetic(8);

		return generateString;
	}
	
	
}
