package com.testops.liudao.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testops.liudao.utils.DriverUtils;

public class FrameDemo {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getWebDriver("chrome");
		try {
			driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
			driver.get("file:///C:/eclipse-workspace/WebAuto/web/frame.html");
//			driver.switchTo().frame(0);
//			driver.switchTo().frame("taobao");
			driver.switchTo().frame(driver.findElement(By.name("taobao")));
			WebElement element = driver.findElement(By.xpath("//div[@class='logo']/h1/a[2]/img"));
			System.out.println(element.getAttribute("src"));
//			driver.switchTo().defaultContent();
			driver.switchTo().parentFrame();
			driver.switchTo().frame("baidu");
			driver.findElement(By.id("kw")).sendKeys("webdriver");
			Thread.sleep(2000);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DriverUtils.stopAll();
		}
	}
}
