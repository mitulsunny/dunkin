package com.dunkin.shadman.onlineStore.helper.javascript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;

/**
 * This class will handle all JavaScript related problems
 * @author shadmanshahriyar
 *
 */

public class JavaScriptHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);
	
	public JavaScriptHelper(WebDriver driver) {
		log.info("initialising JavaScriptHelper");
		this.driver = driver;
		log.info("JavaScriptHelper has been initialised");
	}
	
	/**
	 * This method will execute script by taking any JavaScript string
	 * @param script
	 * @return
	 */
	
	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script);
	}
	
	/**
	 * This method will execute script by script and any arguments
	 * @param script
	 * @param args
	 * @return
	 */
	
	public Object executeScript(String script, Object...args) {
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script,args);
	}
	
	/**
	 * This method will scroll into a element
	 * @param element
	 */
	
	public void scrollToElement(WebElement element) {
		log.info("scroll to WebElement");
		executeScript("window.ScrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
	}
	
	/**
	 * This method will scroll into element and click on that element
	 * @param element
	 */
	
	public void scrollToElementAndClick(WebElement element) {
		scrollToElement(element);
		element.click();
		log.info("Element is clicked : " + element.toString());
	}
	
	/**
	 * This method will scroll into view
	 * @param element
	 */
	
	public void scrollIntoView(WebElement element) {
		log.info("Scrolling till : " + element.toString());
		executeScript("arguments[0].scrollIntoView()",element);
	}
	
	/**
	 * This method will scroll into view and click on the element
	 * @param element
	 */
	
	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log.info("Element is clicked : " + element.toString());
	}
	
	/**
	 * This method will scroll down vertically
	 */
	
	public void scrollDownVertically() {
		log.info("scrolling down vertically");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	/**
	 * This method will scroll up vertically
	 */
	
	public void scrollUpVertically() {
		log.info("scrolling up vertically");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
	/**
	 * This method will scroll down by pixel
	 * @param pixel
	 */
	
	public void scrollDownByPixel(int pixel) {
		log.info("scrolling down by pixel");
		executeScript("window.scrollBy(0," + pixel + ")");
	}
	
	/**
	 * This method will scrollUpByPixel
	 * @param pixel
	 */
	
	public void scrollUpByPixel(int pixel) {
		log.info("scrolling down by pixel");
		executeScript("window.scrollBy(0,-" + pixel + ")");
	}
	
	/**
	 * This method will zoomInByPercentage
	 * @param zoom
	 */
	
	public void zoomInByPercentage(double zoom) {
		log.info("zooming in by "+ zoom +" percentage");
		executeScript("document.body.style.zoom='"+ zoom +"%'");
	}
	
	/**
	 * This method will click on any element
	 * @param element
	 */
	
	public void clickElement(WebElement element) {
		executeScript("arguments[0].click();", element);
	}
}
