package com.dunkin.shadman.onlineStore.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;

/**
 * This class will help us to verify elements
 * @author shadmanshahriyar
 *
 */

public class VerificationHelper {
	WebDriver driver;
	Logger log = LoggerHelper.getLogger(VerificationHelper.class);
	
	public VerificationHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * This method will will verify if element is displayed or not
	 * @param element
	 * @return boolean
	 */
	
	public boolean isDiplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is displayed : " + element.getText());
			return true;
		} catch(Exception e){
			log.error("element is not displayed", e.getCause());
			return false;
		}
	}
	
	/**
	 * this method will verify if an element is not displayed
	 * @param element
	 * @return boolean
	 */
	
	public boolean isNotDiplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is displayed : " + element.getText());
			return false;
		} catch(Exception e){
			log.error("element is not displayed", e.getCause());
			return true;
		}
	}
	
	/**
	 * This method will help us to read any value from any tag
	 * @param element
	 * @return String
	 */
	
	public String readValueFromElement(WebElement element) {
		if(element == null) {
			log.info("Webelement is null");
			return null;
		} 
		
		boolean status = isDiplayed(element); //check if the elemnt is displayed or not
		
		if(status) {
			log.info("element text is : " + element.getText());
			return element.getText();
		} else {
			return null;
		}
	}
	
	/**
	 * This method will help us  to get text from any element
	 * @param element
	 * @return String
	 */
	
	public String getText(WebElement element) {
		return readValueFromElement(element);
	}
}
