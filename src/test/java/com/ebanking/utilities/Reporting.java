package com.ebanking.utilities;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ebanking.pageObjects.BaseClass;





//Listener Class to generate reports
public class Reporting extends TestListenerAdapter {
	
	
	 
	public ExtentHtmlReporter htmlReporter;
	private String htmlReporter2;
	public ExtentReports extent;
	public ExtentTest logger;

	
	 BaseClass bs = new BaseClass();
	public WebDriver driver = BaseClass.driver;
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		 htmlReporter2= System.getProperty("user.dir")+ "/test-output/"+repName;//location of the Report
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt : ","QA");
		extent.setSystemInfo("user","oussama");
		
		
		htmlReporter.config().setDocumentTitle("e-Banking Test Project"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		 
		     
	        // Take a screenshot
	     String  screenshotPath1 = captureScreenshot(driver, tr.getName());
	        File f = new File(screenshotPath1); 

	        if(f.exists()) {
	            try {
					logger.pass("Screenshot of the alert is below:" + logger.addScreenCaptureFromPath(screenshotPath1));
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            }
		
		
	}
	
	public void onTestFailure(ITestResult tr) 
	{
	    logger = extent.createTest(tr.getName()); // create new entry in the report
	    logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the passed information to the report with Red color highlighted

	  
	     
	        // Take a screenshot
	     String  screenshotPath1 = captureScreenshot(driver, tr.getName());
	        File f = new File(screenshotPath1); 

	        if(f.exists()) {
	            try {
					logger.fail("Screenshot of the alert is below:" + logger.addScreenCaptureFromPath(screenshotPath1));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            }
	
	    }
	

	
	
	public String captureScreenshot(WebDriver driver, String testName) {
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	    String destination = System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + testName + "_" + timeStamp +".png";
	    File finalDestination = new File(destination);
	    try {
	        FileHandler.copy(source, finalDestination);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return destination;
	}
	
	
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		
		extent.flush();
	
	          //open Report after the test 
		 File reportFile = new File(htmlReporter2);
	        
	        if (reportFile.exists()) {
	            try {
	                Desktop.getDesktop().browse(reportFile.toURI());
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } else {
	            System.out.println("Le fichier de rapport n'existe pas.");
	        }
	         
		
		
	}
	
	

}
