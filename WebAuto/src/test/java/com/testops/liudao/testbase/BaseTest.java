package com.testops.liudao.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.testops.liudao.utils.DriverUtils;

public class BaseTest {
	public WebDriver driver;
	@BeforeMethod
	public void initDriver() {
		driver = DriverUtils.getWebDriver("chrome");
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	@AfterSuite
	public void stopService() {
		DriverUtils.stopAll();
	}
}
