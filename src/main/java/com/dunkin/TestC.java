package com.dunkin;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestC {
	int i = 1;
	
	@Test
	public void loginTestC() {
		if(i == 2) {
			Assert.assertTrue(true);
		} else {
			i++;
			Assert.assertTrue(false);
		}
		
		
	}
}
