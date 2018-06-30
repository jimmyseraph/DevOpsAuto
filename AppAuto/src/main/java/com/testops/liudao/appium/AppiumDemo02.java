package com.testops.liudao.appium;

import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class AppiumDemo02 {
	public static void main(String[] args) {
		AndroidDriver<AndroidElement> driver = null;
		try {
			URL url = new URL("http://127.0.0.1:4723/wd/hub");;
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
			caps.setCapability(MobileCapabilityType.APP, "C:\\backup\\ApiDemos-debug.apk");
			driver = new AndroidDriver<>(url, caps);
			driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
			
			AndroidElement element = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Animation\")");
			Set<String> contexts = driver.getContextHandles();
			System.out.println(contexts);
//			driver.context("")
			element.click();
			Thread.sleep(3000);
			driver.closeApp();
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			if(driver != null) {
				driver.quit();
			}
		}
		
		
	}
}
