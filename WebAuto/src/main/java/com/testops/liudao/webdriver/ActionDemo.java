package com.testops.liudao.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.testops.liudao.utils.DriverUtils;

public class ActionDemo {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver("chrome");
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("https://www.taobao.com");
			Actions actions = new Actions(driver);
			/*Action action = actions
					.moveToElement(driver.findElement(By.id("J_SiteNavMytaobao")))
					.build();
			action.perform();*/
			actions.moveToElement(driver.findElement(By.id("J_SiteNavMytaobao")))
				.pause(2000)
				.perform();
			
			actions.moveToElement(driver.findElement(By.linkText("我的足迹")))
				.pause(2000)
				.click()
				.perform();
				
			Thread.sleep(2000);
			driver.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		DriverUtils.stopService();
	}
}
