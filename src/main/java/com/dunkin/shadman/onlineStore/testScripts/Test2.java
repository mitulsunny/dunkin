package com.dunkin.shadman.onlineStore.testScripts;

import org.testng.annotations.Test;

import com.dunkin.shadman.onlineStore.helper.assertion.AssertionHelper;
import com.dunkin.shadman.onlineStore.testBase.TestBase;

public class Test2 extends TestBase {
	
	@Test
	public void loginTest() {
		AssertionHelper.makeTrue();
	}
	
	@Test
	public void loginTest1() {
		AssertionHelper.makeFalse();
	}
	
	@Test
	public void loginTest2() {
		AssertionHelper.makeTrue();
	}
	
	@Test
	public void loginTest3() {
		AssertionHelper.makeFalse();
	}
}
