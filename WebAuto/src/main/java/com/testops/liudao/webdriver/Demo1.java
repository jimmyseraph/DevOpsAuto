package com.testops.liudao.webdriver;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.testops.liudao.utils.DriverUtils;

public class Demo1 {
	public static void main(String[] args) {
		/*
		 * driver的查找：
		 * 1、首先检查系统属性webdriver.chrome.driver是否设置了driver文件路径
		 * 2、当前项目文件夹下是否存在该driver
		 * 3、环境变量Path中所指定的路径是否存在driver
		 */
		// 传统的driver启动方法
		/*System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\Course\\Selenium\\工具\\drivers\\chrome\\2.38\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://www.baidu.com");
		driver.close();
		driver.quit();*/
		
		// driver的高级启动方法
		/*ChromeDriverService service = new ChromeDriverService.Builder()
				.usingPort(1234)
				.usingDriverExecutable(new File("C:\\Course\\Selenium\\工具\\drivers\\chrome\\2.38\\chromedriver.exe"))
				.withVerbose(true)
				.build();
		WebDriver driver = new ChromeDriver(service);
		driver.get("https://www.baidu.com");
		driver.close();
		service.stop();*/
		
		// 封装后的使用
		WebDriver driver = DriverUtils.getDriver("chrome");
		driver.get("https://www.baidu.com");
		driver.close();
		DriverUtils.stopService();
	}
}
