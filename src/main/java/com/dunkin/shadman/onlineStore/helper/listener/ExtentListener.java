package com.dunkin.shadman.onlineStore.helper.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;
import com.dunkin.shadman.onlineStore.utils.ExtentManager;

public class ExtentListener implements ITestListener{
	private Logger log = LoggerHelper.getLogger(ExtentListener.class);
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	public void onFinish(ITestContext arg0) {
		//extent.flush();
		Reporter.log(arg0.getName()+" test finished...");
		log.info(arg0.getName()+" test finished...");
	}

	public void onStart(ITestContext arg0) {
		//extent = ExtentManager.getInstance();
		//test = extent.createTest(arg0.getName());
		Reporter.log(arg0.getName()+" test started...");
		log.info(arg0.getName()+" test started...");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		//test.log(Status.FAIL, arg0.getThrowable());
		Reporter.log(arg0.getName()+" test failed..." + arg0.getThrowable());
		log.error(arg0.getName()+" test failed..." + arg0.getThrowable());
	}

	public void onTestSkipped(ITestResult arg0) {
		//test.log(Status.SKIP, arg0.getThrowable());
		Reporter.log(arg0.getName()+" test skipped..." + arg0.getThrowable());
		log.warn(arg0.getName()+" test skipped..." + arg0.getThrowable());
	}

	public void onTestStart(ITestResult arg0) {
		//test.log(Status.INFO, arg0.getName()+" started...");
		Reporter.log(arg0.getName()+" test started...");
		log.info(arg0.getName()+" test started...");
	}

	public void onTestSuccess(ITestResult arg0) {
		//test.log(Status.PASS, arg0.getName()+" passed...");
		Reporter.log(arg0.getName()+" test passed...");
		log.info(arg0.getName()+" test passed...");
	}

}
