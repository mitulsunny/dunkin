package com.dunkin.shadman.onlineStore.helper.frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;

/**
 * This class will the frame
 * @author shadmanshahriyar
 *
 */

public class FrameHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(FrameHelper.class);
	
	public FrameHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * This method will switchToFrame by index
	 * @param index
	 */
	
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
		log.info("switched to :" + index + " frame");
	}
	
	/**
	 * This method will switchToFrame by frameName
	 * @param frameName
	 */
	
	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
		log.info("Switched to :" + frameName + " frame");
	}
	
	/**
	 * This method will switchToFrame by WebElement
	 * @param element
	 */
	
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
		log.info("Switched to :" + element.toString() + " frmae");
	}
	
}
