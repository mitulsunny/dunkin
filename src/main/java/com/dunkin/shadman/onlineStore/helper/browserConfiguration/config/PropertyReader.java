package com.dunkin.shadman.onlineStore.helper.browserConfiguration.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.dunkin.shadman.onlineStore.helper.browserConfiguration.BrowserType;
import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;
import com.dunkin.shadman.onlineStore.helper.resource.ResourceHelper;

public class PropertyReader implements ConfigReader {
	Logger log = LoggerHelper.getLogger(PropertyReader.class);
	private static FileInputStream file;
	public static Properties or;
	
	public PropertyReader() {
		String filePath = ResourceHelper.getResourcePath("/src/main/resources/configfile/config.properties");
		try {
			log.info("Trying to read :" + filePath);
			file = new FileInputStream(new File(filePath));
			or = new Properties();
			or.load(file);
			log.info("Property file loaded");
			
		} catch (Exception e) {
			log.info("Error: Property file not loaded.");
			e.printStackTrace();
		}
	}
	
	public int getImplicitWait() {
		return Integer.parseInt(or.getProperty("implicitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(or.getProperty("explicitWait"));
	}

	public int getPageLoadTime() {
		return Integer.parseInt(or.getProperty("pageLoadTime"));
	}

	public BrowserType getBrowserType() {
		return BrowserType.valueOf(or.getProperty("browserType"));
	}

}
