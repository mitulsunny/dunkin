package com.dunkin.shadman.onlineStore.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;

/**
 * This class will handle all wait related problems
 * @author shadmanshahriyar
 *
 */

public class WaitHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * This will setImplicitWait
	 * @param timeout
	 * @param unit
	 */
	
	public void setImplicitWait(long timeout, TimeUnit unit) {
		log.info("Implicit wait has been set to: " + timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}
	
	/**
	 * This will help us to get WebDriverWait object
	 * @param TimeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return wait
	 */
	
	private WebDriverWait getWait(int TimeOutInSeconds, int pollingEveryInMiliSec) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	/**
	 * This method will check if element is visible
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	
	public void waitForElementVisible(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element is visible now");
	}
	
	/**
	 * this method will check if elementToBeClickable
	 * @param element
	 * @param timeOutInSeconds
	 */
	
	public void waitForElementClickable(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Element is clickable now");
	}
	
	/**
	 * this method will check invisibilityOf element
	 * @param element
	 * @param timeOutInSeconds
	 * @author shadmanshahriyar
	 * @return boolean
	 */
	
	public boolean waitForElementNotPresent(WebElement element, long timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		Boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("element is invisible now");
		return status;
	}
	
	/**
	 * this method will wait for frameToBeAvailableAndSwitchToIt
	 * @param element
	 * @param timeOutInSeconds
	 */
	
	public void waitForFrameToBeAvailableAndSwitchToIt(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("Frame is available and switched");
	}
	
	/**
	 * This method will give FluentWait object
	 * @param TimeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return Wait<WebDriver>
	 */
	
	private Wait<WebDriver> getFluentWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)).ignoring(NoSuchElementException.class);
		
		return fwait;
		
	}
	
	/**
	 * this method will wait until visibilityOf an element
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */
	
	public WebElement waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		Wait<WebDriver> fwait = getFluentWait(timeOutInSeconds, pollingEveryInMiliSec);
		fwait.until(ExpectedConditions.visibilityOf(element));
		
		return element;
		
	}
	
	/**
	 * this method will wait till pageLoad
	 * @param timeout
	 * @param unit
	 */
	
	public void pageLoad(long timeout, TimeUnit unit) {
		log.info("waiting for page to load for :" + unit + " seconds");
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("page is loaded");
	}
}
