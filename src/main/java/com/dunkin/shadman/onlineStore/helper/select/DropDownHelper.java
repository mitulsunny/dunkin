package com.dunkin.shadman.onlineStore.helper.select;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;

/**
 * This class will help us to handle the select boxes or dropdowns
 * @author shadmanshahriyar
 *
 */

public class DropDownHelper {
	WebDriver driver;
	Logger log = LoggerHelper.getLogger(DropDownHelper.class);
	
	public DropDownHelper(WebDriver driver) {
		this.driver = driver;
		log.info("DropDownHelper object has been initiliazed");
	}
	
	public void selectUsingValue(WebElement e, String val) {
		Select s = new Select(e);
		log.info("Selecting element by value : " +val);
		s.selectByValue(val);
		log.info("selected");
	}
	
	public void selectUsingIndex(WebElement e, int val) {
		Select s = new Select(e);
		log.info("Selecting element by index : " +val);
		s.selectByIndex(val);
		log.info("selected");
	}
	
	public void selectUsingVisibleText(WebElement e, String val) {
		Select s = new Select(e);
		log.info("Selecting element by VisibleText : " +val);
		s.selectByVisibleText(val);
		log.info("selected");
	}
	
	public void deselectUsingValue(WebElement e, String val) {
		Select s = new Select(e);
		log.info("Deselecting element by value : " +val);
		s.deselectByValue(val);
		log.info("Deselected");
	}
	
	public void deselectUsingIndex(WebElement e, int val) {
		Select s = new Select(e);
		log.info("Deselecting element by index : " +val);
		s.deselectByIndex(val);
		log.info("Deselected");
	}
	
	public void deselectUsingVisibleText(WebElement e, String val) {
		Select s = new Select(e);
		log.info("Deselecting element by VisibleText : " +val);
		s.deselectByVisibleText(val);
		log.info("Deselected");
	}
	
	public List<String> getAllDropDownData(WebElement e){
		Select s = new Select(e);
		List<WebElement> els = s.getOptions();
		List<String> stringList = new LinkedList<String>();
		for(WebElement singleE:els) {
			log.info("adding element to list : " + singleE.getText());
			stringList.add(singleE.getText());
		}
		
		return stringList;
	}
	
}
