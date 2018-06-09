package com.testops.liudao.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.testops.liudao.utils.DriverUtils;

public class FindElementDemo {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver("chrome");
		try {
//			driver.get("https://www.taobao.com");
//			driver.get("file:///C:/eclipse-workspace/WebAuto/web/later.html");
			/*By.ById byId = new By.ById("J_SiteNavMytaobao");
			byId.findElement(driver).click();*/
			//driver.findElement(By.id("J_SiteNavMytaobao")).click();
			//driver.findElement(By.linkText("我的淘宝")).click();
//			driver.findElement(By.xpath("/html/body/div/div/div/ul[2]/li[2]/div/a/span")).click();
//			driver.findElement(By.cssSelector("#J_SiteNavMytaobao")).click();
//			driver.findElement(By.cssSelector("li.site-nav-menu.site-nav-mytaobao")).click();
			
//			WebElement div = driver.findElement(By.cssSelector("div[data-name='goods']"));
//			Point point = div.getLocation();
//			System.out.println("x: "+point.x+", y: "+point.y);
//			((ChromeDriver)driver).executeScript("window.scrollTo(arguments[0],arguments[1])",0,point.y);
//			scrollY(driver, div);
//			Thread.sleep(2000);
//			WebElement element = driver.findElement(By.cssSelector("h4[id='dg-item-tl-0']"));
//			System.out.println(element.getText());
			
			driver.get("file:///C:/eclipse-workspace/WebAuto/web/table_input.html");
//			driver.findElement(By.id("name")).sendKeys("234");
			WebElement username = driver.findElements(By.xpath("//td[@class='input']")).get(0);
			username.click();
			username.findElement(By.tagName("input")).sendKeys("liudao");
			username.findElement(By.xpath("../th")).click();
			WebElement age = driver.findElements(By.xpath("//td[@class='input']")).get(1);
			age.click();
			age.findElement(By.tagName("input")).sendKeys("20");
			age.findElement(By.xpath("../th")).click();
			Thread.sleep(3000);
			driver.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		DriverUtils.stopService();
	}
	
	public static void scrollY(WebDriver driver, WebElement element) {
		if(driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript(
					"window.scrollTo(0,arguments[0])", 
					element.getLocation().y);
		}
			
	}
}
