package com.testops.liudao.webdriver;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDemo {
	public static void main(String[] args) {
		WebDriver driver = null;
		try {
			URL remoteAddress = new URL("http://192.168.100.167:4444/wd/hub");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
			caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
			driver = new RemoteWebDriver(remoteAddress, caps);
			driver.get("https://www.baidu.com");
			Thread.sleep(3000);
			driver.close();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(driver != null) {
				driver.quit();
			}
		}
		
	}
}
