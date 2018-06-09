package com.testops.liudao.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.service.DriverService;

public class DriverUtils {
	private static DriverService service;

	private static Map<String, DriverService> serviceMap = new HashMap<>();
	
	/**
	 * 获取一个指定名称的WebDriver对象，在获取WebDriver对象的同时，启动一个对应的Service。<br />
	 * 该Service为单例模式，不会被反复启动。不同的浏览器service互不干扰。
	 * @param browserName 浏览器名称，目前仅支持firefox和chrome，大小写不敏感。
	 * @return WebDriver对象
	 */
	public static WebDriver getWebDriver(String browserName) {
		if("chrome".equalsIgnoreCase(browserName)) {
			service = serviceMap.get("chrome");
			ChromeOptions options = new ChromeOptions();
			if(service == null || !service.isRunning()) {
				ChromeDriverService.Builder builder= new ChromeDriverService.Builder();
				if(ConfigManager.getDriverProperty("chrome.driver") != null) {
					builder.usingDriverExecutable(new File(ConfigManager.getDriverProperty("chrome.driver")));
				}
				if(ConfigManager.getDriverProperty("chrome.port") != null) {
					builder.usingPort(Integer.parseInt(ConfigManager.getDriverProperty("chrome.port")));
				}else {
					builder.usingAnyFreePort();
				}
				
				if(ConfigManager.getDriverProperty("chrome.option.browser") != null) {
					options.setBinary(ConfigManager.getDriverProperty("chrome.option.browser"));
				}
				if(ConfigManager.getDriverProperty("chrome.option.insecure") != null) {
					options.setAcceptInsecureCerts(Boolean.parseBoolean(ConfigManager.getDriverProperty("chrome.option.insecure")));
				}
				service = builder.build();
				serviceMap.put("chrome", service);
			}
			return new ChromeDriver((ChromeDriverService) service, options);
		}else if("firefox".equalsIgnoreCase(browserName)) {
			FirefoxOptions options = new FirefoxOptions();
			service = serviceMap.get("firefox");
			if(service == null || !service.isRunning()) {
				GeckoDriverService.Builder builder = new GeckoDriverService.Builder();
				if(ConfigManager.getDriverProperty("firefox.driver") != null) {
					builder.usingDriverExecutable(new File(ConfigManager.getDriverProperty("firefox.driver")));
				}
				if(ConfigManager.getDriverProperty("firefox.port") != null) {
					builder.usingPort(Integer.parseInt(ConfigManager.getDriverProperty("firefox.port")));
				}else {
					builder.usingAnyFreePort();
				}
				if(ConfigManager.getDriverProperty("forefox.option.browser") != null) {
					options.setBinary(ConfigManager.getDriverProperty("forefox.option.browser"));
				}
				if(ConfigManager.getDriverProperty("forefox.option.insecure") != null) {
					options.setAcceptInsecureCerts(Boolean.parseBoolean(ConfigManager.getDriverProperty("forefox.option.insecure")));
				}
				service = builder.build();
				serviceMap.put("firefox", service);
			}
			return new FirefoxDriver((GeckoDriverService)service,options);
		}else {
			throw new RuntimeException("未支持的浏览器类型");
		}
	}
	
	/**
	 * 获取一个指定名称的WebDriver对象，在获取WebDriver对象的同时，启动一个对应的Service。
	 * @param browserName 浏览器名称，目前仅支持firefox和chrome，大小写不敏感。
	 * @return WebDriver对象
	 * @deprecated 建议使用{@link #getWebDriver(String)}代替
	 */
	@Deprecated
	public static WebDriver getDriver(String browserName) {
		if("chrome".equalsIgnoreCase(browserName)) {
			if(service == null || !service.isRunning()) {
				service = new ChromeDriverService.Builder()
						.usingAnyFreePort()
						.usingDriverExecutable(new File("C:\\Course\\Selenium\\工具\\drivers\\chrome\\2.38\\chromedriver.exe"))
						.build();
			}
			return new ChromeDriver((ChromeDriverService) service);
		}else if("firefox".equalsIgnoreCase(browserName)) {
			if(service == null || !service.isRunning()) {
				service = new GeckoDriverService.Builder()
						.usingAnyFreePort()
						.usingDriverExecutable(new File("C:\\Course\\Selenium\\工具\\drivers\\gecko\\0.20.1\\geckodriver.exe"))
						.build();
			}
			return new FirefoxDriver((GeckoDriverService)service);
		}else {
			throw new RuntimeException("未支持的浏览器类型");
		}
	}
	/**
	 * 关闭所有目前开启的Service
	 */
	public static void stopAll() {
		for(Map.Entry<String, DriverService> entry : serviceMap.entrySet()) {
			entry.getValue().stop();
		}
	}
	/**
	 * 关闭当前的Service
	 */
	public static void stopService() {
		service.stop();
	}
}
