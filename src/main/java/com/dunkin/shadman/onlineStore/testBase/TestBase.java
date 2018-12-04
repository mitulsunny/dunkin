package com.dunkin.shadman.onlineStore.testBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.dunkin.shadman.onlineStore.helper.browserConfiguration.BrowserType;
import com.dunkin.shadman.onlineStore.helper.browserConfiguration.ChromeBrowser;
import com.dunkin.shadman.onlineStore.helper.browserConfiguration.FirefoxBrowser;
import com.dunkin.shadman.onlineStore.helper.browserConfiguration.config.ObjectReader;
import com.dunkin.shadman.onlineStore.helper.browserConfiguration.config.PropertyReader;
import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;
import com.dunkin.shadman.onlineStore.helper.resource.ResourceHelper;
import com.dunkin.shadman.onlineStore.helper.wait.WaitHelper;
import com.dunkin.shadman.onlineStore.utils.ExtentManager;
import com.google.common.io.Files;
import com.graphbuilder.struc.LinkedList;

public class TestBase {
	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	public static String reportDirectory;
	public static String screenShotDirectory;
	
	Logger log = LoggerHelper.getLogger(TestBase.class);
	
	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.getInstance();
	}
	
	@BeforeTest
	public void beforeTest() {
		ObjectReader.reader = new PropertyReader();
		reportDirectory = ResourceHelper.getResourcePath("/test-output");
		screenShotDirectory = reportDirectory+"/screenshots";
		setupDriver(ObjectReader.reader.getBrowserType());
	}
	
	@BeforeClass
	public void beforeClass() {
		test = extent.createTest(getClass().getName());
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + " test started");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
			String screenshot = captureScreen(result.getName());
			test.addScreenCaptureFromPath(screenshot);
		} else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " is passed");
			String screenshot = captureScreen(result.getName());
			test.addScreenCaptureFromPath(screenshot);
		} else if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
		}
		
		extent.flush();
	}
	
	@AfterTest
	public void afterTest() {
		if(driver!=null) {
			log.info("driver is quiting");
			driver.quit();
			log.info("driver quit");
		}
	}
	
	public WebDriver getBrowserObject(BrowserType bType) {
		try {
			switch(bType) {
			case Chrome:
				ChromeBrowser chrome = new ChromeBrowser();
				return chrome.getChromeDriver(chrome.getChromeOptions());
				
			case Firefox:
				FirefoxBrowser firefox = new FirefoxBrowser();
				return firefox.getFirefoxDriver(firefox.getFirefoxOptions());
			
			default:
				throw new Exception("Driver not found.. Browser type: " + bType.name());
			}
		} catch(Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}
	
	public void setupDriver(BrowserType bType) {
		driver = getBrowserObject(bType);
		log.info("Browser is being initialized" + driver.hashCode());
		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitWait(ObjectReader.reader.getImplicitWait(), TimeUnit.SECONDS);
		wait.pageLoad(ObjectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	
	public String captureScreen(String filename) {
		if(driver==null) {
			log.info("driver is null");
			return null;
		}
		
		if(filename=="") {
			filename = "blank";
		}
		
		File destinationFile = null;
		
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("mm-dd-yyyy_hh:mm:ss");
		TakesScreenshot s = ((TakesScreenshot)driver);
		File sf = s.getScreenshotAs(OutputType.FILE);
		try {
			log.info("Taking ScreenShot");
			destinationFile = new File(screenShotDirectory+"/"+filename+"_"+format.format(calender.getTime())+".png");
			Files.copy(sf, destinationFile);
			Reporter.log("<a href='"+destinationFile.getAbsolutePath()+"'><img src='"+destinationFile.getAbsolutePath()+"' height='100' width='100'/></a>");
		} catch(Exception e) {
			log.info("ERROR: Taking Screenshot failed!");
			e.printStackTrace();
		}
		return destinationFile.toString();
	}
	
	public String captureScreen(String filename, WebDriver driver) {
		if(driver==null) {
			log.info("driver is null");
			return null;
		}
		
		if(filename=="") {
			filename = "blank";
		}
		
		File destinationFile = null;
		
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("mm-dd-yyyy_hh:mm:ss");
		TakesScreenshot s = ((TakesScreenshot)driver);
		File sf = s.getScreenshotAs(OutputType.FILE);
		try {
			log.info("Taking ScreenShot");
			destinationFile = new File(screenShotDirectory+"/"+filename+"_"+format.format(calender.getTime())+".png");
			Files.copy(sf, destinationFile);
			Reporter.log("<a href='"+destinationFile.getAbsolutePath()+"'><img src='"+destinationFile.getAbsolutePath()+"' height='100' width='100'/></a>");
		} catch(Exception e) {
			log.info("ERROR: Taking Screenshot failed!");
			e.printStackTrace();
		}
		return destinationFile.toString();
	}
	
	public void getNavigationScreen(WebDriver driver) {
		log.info("Capturing navigation screen");
		String screen = captureScreen("", driver);
		try {
			test.addScreenCaptureFromPath(screen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
