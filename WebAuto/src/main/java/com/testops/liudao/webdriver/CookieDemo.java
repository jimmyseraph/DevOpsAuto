package com.testops.liudao.webdriver;

import java.util.Date;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import com.testops.liudao.utils.DriverUtils;

public class CookieDemo {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getDriver("chrome");
		try {
			driver.get("https://www.taobao.com");
			Cookie cookie = new Cookie.Builder("token", "123456")
					.domain("www.taobao.com")
					.path("/")
					.expiresOn(new Date(System.currentTimeMillis()+3600000L))
					.build();
			driver.manage().addCookie(cookie);
		}catch(Exception e) {
			e.printStackTrace();
		}
		DriverUtils.stopService();
	}
}
