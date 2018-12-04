package com.dunkin.shadman.onlineStore.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.dunkin.shadman.onlineStore.helper.resource.ResourceHelper;

/**
 * 
 * @author shadmanshahriyar
 *
 */

public class FirefoxBrowser {
	public FirefoxOptions getFirefoxOptions() {
		DesiredCapabilities firefox = DesiredCapabilities.firefox();
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("marionette", true);
		
		FirefoxOptions option = new FirefoxOptions(firefox);
		
		if(System.getProperty("os.name").contains("Linux")) {
			option.addArguments("--headless", "window-size=1074,768", "--no-sandbox");
		}
		
		return option;
	}
	
	public WebDriver getFirefoxDriver(FirefoxOptions cap) {
		if(System.getProperty("os.name").contains("Mac")) {
			System.getProperty("webdriver.gecko.driver",ResourceHelper.getResourcePath("/src/main/resources/drivers/geckodriver"));
			return new FirefoxDriver(cap);
		} else if(System.getProperty("os.name").contains("Window")) {
			System.getProperty("webdriver.gecko.driver",ResourceHelper.getResourcePath("/src/main/resources/drivers/geckodriver.exe"));
			return new FirefoxDriver(cap);
		} else if(System.getProperty("os.name").contains("Linux")) {
			System.getProperty("webdriver.gecko.driver",ResourceHelper.getResourcePath("/src/main/resources/drivers/geckodriverLinux"));
			return new FirefoxDriver(cap);
		} 
		
		return null;
	}
}
