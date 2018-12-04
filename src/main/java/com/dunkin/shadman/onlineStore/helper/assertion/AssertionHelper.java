package com.dunkin.shadman.onlineStore.helper.assertion;

import org.apache.log4j.Logger;

import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;

import junit.framework.Assert;

public class AssertionHelper {
	private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);
	
	/**
	 * This method will verify two Strings are matching or not
	 * @param s1
	 * @param s2
	 */
	
	public static void verifyText(String s1, String s2) {
		log.info("verifying text '" + s1 + "' with '" + s2 + "'");
		Assert.assertEquals(s1, s2);
	}
	
	/**
	 * This method will make any test passed
	 */
	
	public static void makeTrue() {
		log.info("making test passed");
		Assert.assertTrue(true);
	}
	
	/**
	 * This method will pass any test with a message
	 * @param msg
	 */
	
	public static void makeTrue(String msg) {
		log.info("making test passed -> msg : " + msg);
		Assert.assertTrue(msg, true);
	}
	
	/**
	 * This method will make any test fail
	 */
	
	public static void makeFalse() {
		log.info("making test failed");
		Assert.assertTrue(false);
	}
	
	/**
	 * This method will fail any test with a message
	 * @param msg
	 */
	
	public static void makeFalse(String msg) {
		log.info("making test failed -> msg : " + msg);
		Assert.assertTrue(msg, false);
	}
	
	/**
	 * This method will verify if any condition is true
	 * @param sts
	 */
	
	public static void verifyTrue(boolean sts) {
		log.info("Verify true or not ");
		Assert.assertTrue(sts);
	}
	
	/**
	 * This method will verify if any condition is false
	 * @param sts
	 */
	
	public static void verifyFalse(boolean sts) {
		log.info("making test false or not ");
		Assert.assertFalse(sts);
	}
	
	/**
	 * This method will verify if any object is null
	 * @param s1
	 */
	
	public static void verifyNull(String s1) {
		log.info("Verifying object is null : " + s1);
		Assert.assertNull(s1);
	}
	
	/**
	 * this method will verify if any object is not null
	 * @param s1
	 */
	
	public static void verifyNotNull(String s1) {
		log.info("Verifying object is not null : " + s1);
		Assert.assertNotNull(s1);
	}
	
}
