package com.ebanking.pageObjects;


import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ebanking.utilites.ReadConfig;

import org.apache.log4j.Logger;



public class BaseClass {
	
	ReadConfig readconfig= new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	public String userName = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver ;
	public   Logger logger = Logger.getLogger("ebanking");
	
	
	
	
	
	
	
	@Parameters("browser")
	@BeforeClass
	public  void setup( String br ) {
	
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getChrome());
			
			PropertyConfigurator.configure("log4j.properties");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		
			
		}
		
		else if(br.equals("firefox")) {
			
			System.setProperty("webdriver.chrome.driver",readconfig.getFirefox());
		
			PropertyConfigurator.configure("log4j.properties");
			driver =  new FirefoxDriver();
			driver.manage().window().maximize();
			
			
		}
		
       else if(br.equals("Mse")) {
			
			System.setProperty("webdriver.chrome.driver",readconfig.getMse());
		
			PropertyConfigurator.configure("log4j.properties");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			
			
		}
		
		
		
	}
	
	
	@AfterClass
	public void tearDown() {
		
	//driver.quit();
		
	}
	

}
