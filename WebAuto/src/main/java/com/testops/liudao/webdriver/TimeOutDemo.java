package com.testops.liudao.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testops.liudao.utils.DriverUtils;

public class TimeOutDemo {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver("chrome");
		try {
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get("file:///C:/eclipse-workspace/WebAuto/web/later.html");
			//Thread.sleep(3000);
			//driver.findElement(By.xpath("//button")).click();
			
			// 柔性等待
			/*WebDriverWait wait = new WebDriverWait(
					driver, 
					new SystemClock(), 
					Sleeper.SYSTEM_SLEEPER, 
					10L, 
					1000L);*/
			WebDriverWait wait = new WebDriverWait(driver, 10L);
			WebElement button = driver.findElement(By.xpath("//button"));
			wait.until(ExpectedConditions.visibilityOf(button)).click();
			
			Thread.sleep(2000);
			driver.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		DriverUtils.stopService();
	}
}
