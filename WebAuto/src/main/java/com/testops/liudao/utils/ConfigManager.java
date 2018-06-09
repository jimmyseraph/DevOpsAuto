package com.testops.liudao.utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	private static Properties driverProp;
	public static String getDriverProperty(String propertyName) {
		String value = null;
		if(driverProp == null) {
			driverProp = new Properties();
		}
		try {
			driverProp.load(ConfigManager.class.getClassLoader().getResourceAsStream("driver.properties"));
			value = driverProp.getProperty(propertyName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
