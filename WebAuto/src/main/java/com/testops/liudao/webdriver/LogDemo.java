package com.testops.liudao.webdriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogDemo {
	private static final Logger logger = LoggerFactory.getLogger(LogDemo.class);
	public static void main(String[] args) {
		// trace\debug\info\warn\error
		logger.error("---> 错误日志");
		logger.info("---> 你好");
	}
}
