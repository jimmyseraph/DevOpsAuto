package com.testops.liudao.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.testops.liudao.ecshop.pages.EcshopIndexPage;
import com.testops.liudao.utils.DriverUtils;

public class PageObjectDemo {
	public static void main(String[] args) {
		WebDriver driver = DriverUtils.getWebDriver("chrome");
		try {
			driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
			driver.get("http://localhost/ecshop");
			
			EcshopIndexPage indexPage = new EcshopIndexPage(driver);
//			PageFactory.initElements(driver, indexPage);
//			EcshopIndexPage indexPage = PageFactory.initElements(driver, EcshopIndexPage.class);
			indexPage.click_register_link();
			Thread.sleep(2000);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DriverUtils.stopAll();
		}
	}
}
