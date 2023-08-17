package com.crmGenericUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendsReportClass implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) 
	{	
	//Execution stsrts from here
	String Methodname=result.getMethod().getMethodName();
	report.createTest(Methodname);
	Reporter.log(Methodname+"------>TestScript execution started");
    }

	public void onTestSuccess(ITestResult result) 
	{
	String Methodname=result.getMethod().getMethodName();
	test.log(Status.PASS, Methodname+"----->Passed");
	Reporter.log(Methodname+"---->TestScript Passed");
	}

	public void onTestFailure(ITestResult result) {
		
		String fscript=result.getMethod().getMethodName();
		String failedscript = fscript+ new JavaUtility().GetSystemDateInFormat();
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.driver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File Dest = new File("./Screenshots/"+failedscript+".png");
		try 
		{
			FileUtils.copyFile(src, Dest);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	    //test.addScreenCaptureFromPath(Dest.getAbsolutePath());
		test.log(Status.FAIL, fscript+"------>failed");
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(failedscript+"------>TestScript failed");
		
	}
	
	public void onTestSkipped(ITestResult result) {
		String Methodname=result.getMethod().getMethodName();	
		test.log(Status.SKIP, Methodname+"------>skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(Methodname+"------->TestScript skipped");
	}


	public void onStart(ITestContext context) {
		//Create Html Report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReports/report.html");
		htmlreport.config().setDocumentTitle("CRM");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("RunWaySales");
		
	    report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Os", "Windows");
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("Base-url", "http://rmgtestingserver:8888/");
		report.setSystemInfo("ReporterName","charan");	
	}
		
	public void onFinish(ITestContext context) {
		//consolidate the report
		report.flush();
	}
	

}
