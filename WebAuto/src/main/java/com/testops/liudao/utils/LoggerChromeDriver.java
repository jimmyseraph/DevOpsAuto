package com.testops.liudao.utils;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerChromeDriver extends ChromeDriver {
	private static final Logger logger = LoggerFactory.getLogger(LoggerChromeDriver.class);
	public LoggerChromeDriver() {
		super();
	}
	public LoggerChromeDriver(ChromeDriverService service) {
		super(service);
	}
	public LoggerChromeDriver(ChromeDriverService service, ChromeOptions options) {
		super(service, options);
	}
	
	@Override
	protected WebElement findElement(String by, String using) {
		WebElement element = null;
		try {
			element = super.findElement(by, using);
			logger.info("找到"+by+" = "+using+"的元素");
		} catch(Exception e) {
			logger.error("根据"+by+" = "+using+"查询元素时出错...",e);
		}
		return element;
	}
	
	@Override
	protected List<WebElement> findElements(String by, String using) {
		List<WebElement> elements = null;
		try {
			elements = super.findElements(by, using);
			logger.info("找到"+by+" = "+using+"的"+elements.size()+"个元素");
		} catch(Exception e) {
			logger.error("根据"+by+" = "+using+"查询元素时出错...",e);
		}
		return elements;
	}
}
