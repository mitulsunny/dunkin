package com.dunkin.shadman.onlineStore.helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;

/**
 * This class will help us to handle alerts
 * @author shadmanshahriyar
 *
 */

public class AlertHelper {
	WebDriver driver;
	Logger log = LoggerHelper.getLogger(AlertHelper.class);
	
	public AlertHelper(WebDriver driver) {
		this.driver = driver;
		log.info("AlertHelper object has been initiliazed");
	}
	
	public Alert getAlert() {
		Alert a = driver.switchTo().alert();
		log.info("alert test: "+a.getText());
		return a;		
	}
	
	public void acceptAlert() {
		Alert a = getAlert();
		a.accept();
		log.info("alert accepted");
	}
	
	public void dismissAlert() {
		Alert a = getAlert();
		a.dismiss();
		log.info("alert dismissed");
	}
	
	public String getAlertText() {
		String txt = getAlert().getText();
		log.info("alert text : "+txt);
		return txt;
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			log.info("Alert is present");
			return true;
		} catch(NoAlertPresentException e) {
			log.info("Alert is not present : "+ e.getCause());
			return false;
		}
	}
	
	public void acceptAlertIfPresent() {
		if(isAlertPresent()) {
			acceptAlert();
		}
	}
	
	public void dismissAlertIfPresent() {
		if(isAlertPresent()) {
			dismissAlert();
		}
	}
	
	public void acceptPrompt(String text) {
		if(isAlertPresent()) {
			Alert a = getAlert();
			a.sendKeys(text);
			a.accept();
			log.info("Alert text submitted : " + text);
		}
	}
}
