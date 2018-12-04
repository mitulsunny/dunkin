package com.dunkin;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestB {
	int i = 1;
	
	@Test
	public void loginTestB() {
		if(i == 3) {
			Assert.assertTrue(true);
		} else {
			i++;
			Assert.assertTrue(false);
		}
		
		
	}
}
