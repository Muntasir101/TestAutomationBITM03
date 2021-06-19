package com.ExtentReports;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;

public class ExtentReportsDemo {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	@Parameters({"OS","browser"})
	@BeforeTest
	public void startReports(String OS, String browser)
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReportsDemo.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("OS", OS);
		extent.setSystemInfo("Browser", browser);
		
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Test Report");
		htmlReporter.config().setReportName("Muntasir");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a");	
	}
	
	@Test
	public void testCase1()
	{
		
		test=extent.createTest("Test Case 1","Passed test case");
		Assert.assertTrue(true);
		test.log(Status.INFO, "Test Case 1 successfully Executed");
	}
	
	@Test
	public void testCase2()
	{
		test=extent.createTest("Test Case 2","Passed test case");
		Assert.assertTrue(true);
		test.log(Status.INFO, "Test Case 2 successfully Executed");
	}
	
	@Test
	public void testCase3()
	{
		test=extent.createTest("Test Case 3","Passed test case");
		Assert.assertTrue(true);
		test.log(Status.INFO, "Test Case 3 successfully Executed");
	}
	
	@Test
	public void testCase4()
	{
		test=extent.createTest("Test Case 4","Passed test case");
		Assert.assertTrue(true);
		test.log(Status.INFO, "Test Case 4 successfully Executed");
	}
	
	@Test
	public void testCase5()
	{
		test=extent.createTest("Test Case 5","Passed test case");
		Assert.assertTrue(false);
	}
	
	@Test
	public void testCase6()
	{
		test=extent.createTest("Test Case 6","Skipped test case");
		throw new SkipException("Skipped test case");
	}
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"PASSED", ExtentColor.GREEN));
		}
		
		else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"SKIPPED", ExtentColor.ORANGE));
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
	}
}
