package com.dunkin.shadman.onlineStore.helper.browserConfiguration.config;

import com.dunkin.shadman.onlineStore.helper.browserConfiguration.BrowserType;

public interface ConfigReader {
	public int getImplicitWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public BrowserType getBrowserType();
}
