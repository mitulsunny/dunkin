package com.dunkin.shadman.onlineStore.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;

public class Homepage {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(Homepage.class);
	
	@FindBy(xpath="/html/body/div[2]/div[1]/div/nav/ul[2]/li/a")
	WebElement DDperksImage;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/div/div[3]/div[2]/div[2]/a")
	WebElement signInLinkOnTop;
	
	@FindBy(xpath="//*[@id=\"global-nav-nonperks\"]/nav/div[2]/div/a[1]")
	WebElement signInButtonAfterClickingDDperksImage;
	
	@FindBy(xpath="//*[@id=\"global-nav-nonperks\"]/nav/div[2]/div/a[2]")
	WebElement learnMoreButtonAfterClickingDDperksImage;
	
	public Homepage(WebDriver driver) {
		log.info("Homepage initializing...");
		this.driver = driver;
		PageFactory.initElements(driver, this);
		log.info("pagefactory for homepage loaded... Homepage initialized.");
	}
	
	public void clickOnSignInLinkOnTop() {
		log.info("Clicking on SignInLinkOnTop");
		signInLinkOnTop.click();
		log.info("Clicked");
	}
	
	public void clickOnSignInButtonAfterClickingDDperksImage() {
		log.info("Clicking on signInButtonAfterClickingDDperksImage");
		signInButtonAfterClickingDDperksImage.click();
		log.info("Clicked");
	}
	
	public void clickOnLearnMoreButtonAfterClickingDDperksImage() {
		log.info("Clicking on learnMoreButtonAfterClickingDDperksImage");
		learnMoreButtonAfterClickingDDperksImage.click();
		log.info("Clicked");
	}
	
}
