package com.testops.liudao.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testops.liudao.utils.DriverUtils;

public class BaiduTitleWait {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver("chrome");
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("https://www.baidu.com");
			driver.findElement(By.id("kw")).sendKeys("webdriver");
			Thread.sleep(2000); // 如何替换成条件等待？
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			driver.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		DriverUtils.stopService();
	}
}
