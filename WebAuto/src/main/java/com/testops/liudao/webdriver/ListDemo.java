package com.testops.liudao.webdriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testops.liudao.utils.DriverUtils;

public class ListDemo {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver("chrome");
		try {
			driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
			/*driver.get("http://bbs.51testing.com/forum-42-1.html");
			String forum_42_1 = driver.getWindowHandle();
			System.out.println("新手上路板块窗口为："+forum_42_1);
			List<WebElement> threads = driver.findElements(By.xpath("//tbody[starts-with(@id,'normalthread')]/tr/th/a[3]"));
			for(WebElement thread : threads) {
				
				System.out.println(thread.getText());
			}
			threads.get(0).click();
			Set<String> handles = driver.getWindowHandles();
			String current_thread = "";
			for(String handle : handles) {
				if(!handle.equals(forum_42_1)) {
					current_thread = handle;
					break;
				}
			}
			if(!current_thread.equals("")) {
				driver.switchTo().window(current_thread);
				driver.findElement(By.linkText("返回列表")).click();
			}
			driver.switchTo().window(forum_42_1);
			threads.get(1).click();*/
			
			driver.get("http://www.mangoscn.com/forum.php?mod=forumdisplay&fid=39");
			List<WebElement> threads = driver.findElements(By.xpath("//tbody[starts-with(@id,'normalthread')]/tr/th/a[1]"));
			for(WebElement thread : threads) {
				System.out.println(thread.getText());
			}
			threads.get(0).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("返回列表")).click();
			threads = driver.findElements(By.xpath("//tbody[starts-with(@id,'normalthread')]/tr/th/a[1]"));
			threads.get(1).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("返回列表")).click();
			Thread.sleep(3000);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DriverUtils.stopService();
		}
	}
}
