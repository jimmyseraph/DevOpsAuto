package com.testops.liudao.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class AppiumDemo {
	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".Calculator");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
		AndroidDriver<AndroidElement> driver = 
				new AndroidDriver<>(url, caps);
		driver.findElement(By.id("com.android.calculator2:id/digit_4")).click();
		driver.findElementById("com.android.calculator2:id/op_mul").click();
		driver.findElementById("com.android.calculator2:id/digit_5").click();
		driver.findElementById("com.android.calculator2:id/eq").click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.closeApp();
		driver.quit();
	}
}
