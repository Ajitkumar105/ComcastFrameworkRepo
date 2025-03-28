package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClassReal;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImplementationClass implements ITestListener,ISuiteListener {
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	


	@Override
	public void onStart(ISuite suite) {
		
		ISuiteListener.super.onStart(suite);
		System.out.println("Report configuration");
		// 1.spark report config
		String time=new Date().toString().replace(" ", "_").replace(":", " ");
		 spark = new ExtentSparkReporter("./AdavaceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM  Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// 2.add envirnment information and create test

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		
		ISuiteListener.super.onFinish(suite);
		System.out.println("Report BackUP");
		//report back up OR STORING THE REPORT  
         report.flush(); 
	}

	@Override
	public void onTestStart(ITestResult result) {
	
		System.out.println("=== ===>"+result.getMethod().getMethodName() +">=====START======");//printing the testmethod name present in listener implementation class 
		ITestListener.super.onTestStart(result);
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName()+ "=====STARTED=====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		ITestListener.super.onTestSuccess(result);
		System.out.println("=== ===>"+result.getMethod().getMethodName() +">=====END======");
		UtilityClassObject.getTest().log(Status.PASS, result.getMethod().getMethodName()+ "=====COMPLETED=====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		ITestListener.super.onTestFailure(result);
		String testName =  result.getMethod().getMethodName();
		
 
		TakesScreenshot tS =(TakesScreenshot)BaseClassReal.sdriver;
		String filepath=tS.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ", "_").replace(":", " ");
		
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filepath, testName+"_"+time);
		
		UtilityClassObject.getTest().log(Status.FAIL, result.getMethod().getMethodName()+ "=====FAILED=====");
		
		/*try {
			FileUtils.copyFile(srcFile, new File("./screenshot/"+testName+"+"+time+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	

}
