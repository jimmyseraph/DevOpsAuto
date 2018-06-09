package com.testops.liudao.ecshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcshopIndexPage {
	@FindBy(linkText = "请登录 ")
	private WebElement login_link;
	
	@FindBy(linkText = "免费注册")
	private WebElement register_link;
	
	public EcshopIndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void click_login_link() {
		login_link.click();
	}
	/**
	* 点击注册按钮
	*/
	public void click_register_link() {
		register_link.click();
	}
}
