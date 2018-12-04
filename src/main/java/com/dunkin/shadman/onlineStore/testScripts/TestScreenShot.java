package com.dunkin.shadman.onlineStore.testScripts;

import org.testng.annotations.Test;

import com.dunkin.shadman.onlineStore.testBase.TestBase;

public class TestScreenShot extends TestBase {
	@Test
	public void testScreen() {
		driver.get("http://facebook.com");
		//captureScreen("facebookSceenShot");
	}
}
