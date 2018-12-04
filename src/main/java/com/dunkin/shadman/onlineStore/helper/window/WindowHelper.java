package com.dunkin.shadman.onlineStore.helper.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;

public class WindowHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WindowHelper.class);
	
	public WindowHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * This method will switchToParentWindow
	 */
	
	public void switchToParentWindow() {
		log.info("Switching to parent window");
		driver.switchTo().defaultContent();
		log.info("swithed to parent window");
	}
	
	/**
	 * This method will switchToWindow by index
	 * @param index
	 */
	
	public void switchToWindow(int index) {
		Set<String> windows = driver.getWindowHandles();
		
		log.info("switching to " + index + " number window");
		int i = 1;
		for(String window:windows) {
			if(i == index) {
				driver.switchTo().window(window);
				log.info("switched to " + index + " number window");
			} else {
				i++;
			}
		}
	}
	
	/**
	 * This method will close All Tabs And Switch To MainWindow
	 */
	
	public void closeAllTabsAndSwitchToMainWindow() {
		Set<String> windows = driver.getWindowHandles();
		String mainWindow = driver.getWindowHandle();
		
		for(String window:windows) {
			if(!window.equalsIgnoreCase(mainWindow)) {
				log.info("closing window: " + window);
				driver.close();
				log.info("window closed");
			}
		}
		
		log.info("Switching to main window");
		driver.switchTo().window(mainWindow);
		log.info("Switched to main window");
	}
	
	/**
	 * This method will navigateBack 
	 */
	
	public void navigateBack() {
		log.info("navigating back");
		driver.navigate().back();
		log.info("navigated to back");
	}
	
	/**
	 * this method will navigateForward
	 */
	
	public void navigateForward() {
		log.info("navigating forward");
		driver.navigate().forward();
		log.info("navigated to forward");
	}
}
