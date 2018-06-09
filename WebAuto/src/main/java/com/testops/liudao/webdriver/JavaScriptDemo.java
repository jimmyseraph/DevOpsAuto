package com.testops.liudao.webdriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testops.liudao.utils.DriverUtils;

public class JavaScriptDemo {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver("chrome");
		try {
			/*driver.get("http://bbs.51testing.com/forum.php");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			//WebElement element = (WebElement) jse.executeScript("return document.getElementById('q')");
			List<WebElement> elements = (ArrayList<WebElement>) jse.executeScript("return jQuery('#ls_username')");
			elements.get(0).sendKeys("笔记本电脑");*/
			// 关于DOM的操作
			driver.get("https://www.taobao.com");
			String js = "var script_element = document.createElement(\"script\");"
					+ "var type_attr = document.createAttribute(\"type\");"
					+ "type_attr.value = \"text/javascript\";"
					+ "var src_attr = document.createAttribute(\"src\");"
					+ "src_attr.value = \"https://code.jquery.com/jquery-3.3.1.min.js\";"
					+ "script_element.setAttributeNode(type_attr);"
					+ "script_element.setAttributeNode(src_attr);"
					+ "document.head.appendChild(script_element);";
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript(js);
			/*Thread.sleep(2000);
			WebElement element = (WebElement) jse.executeScript("return $('#q')[0]");*/
			WebElement element = (WebElement) new WebDriverWait(driver, 10L)
					.until(ExpectedConditions.jsReturnsValue("return $('#q')[0]"));
			element.sendKeys("笔记本电脑");
			Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		DriverUtils.stopService();
	}
}
