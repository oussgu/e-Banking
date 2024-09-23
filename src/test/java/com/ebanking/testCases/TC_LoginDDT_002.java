package com.ebanking.testCases;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.BaseClass;
import com.ebanking.pageObjects.LoginPage;
import com.ebanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{

	
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubm();
		

		
		
		if(isAlertPresent()==true)
		{
			
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			
			Assert.assertTrue(false);
			logger.info(" Login fail");
		
	
			
		}
		else
		{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a"))));
			Assert.assertTrue(true);
			logger.info("Login passed");
			
			lp.clickLogout();
			  
		
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	
	public boolean isAlertPresent() throws IOException //user defined method created to check alert is presetn or not
	{
		try
		{
			
			
		driver.switchTo().alert();//switch to alert javascript  
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());
		return true;
		
		}
		catch(NoAlertPresentException e)
		{   
			return false;
			
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/ebanking/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
}
