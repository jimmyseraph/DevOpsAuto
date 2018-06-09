package com.testops.liudao.testecshop;

import org.testng.annotations.Test;

import com.testops.liudao.dataproviders.EcshopTestDataProvider;
import com.testops.liudao.ecshop.pages.EcshopIndexPage;
import com.testops.liudao.ecshop.pages.EcshopRegisterPage;
import com.testops.liudao.testbase.BaseTest;

public class RegisterTest extends BaseTest {
	
	@Test
	public void registerSuccess() {
		driver.get("http://localhost/ecshop");
		EcshopIndexPage indexPage = new EcshopIndexPage(driver);
		indexPage.click_register_link();
		EcshopRegisterPage registerPage = new EcshopRegisterPage(driver);
		String username = "L"+System.currentTimeMillis();
		registerPage.inputUsername(username);
		registerPage.inputEmail(username+"@163.com");
		registerPage.inputPassword("123456");
		registerPage.inputConfirmPassword("123456");
		registerPage.inputMobileNumber("13544444444");
		registerPage.clickRegBtn();
		registerPage.assertRegisterResult("用户名 "+username+" 注册成功 ");
	}
	@Test(
		dataProviderClass=EcshopTestDataProvider.class,
		dataProvider="null_value_test_data"
	)
	public void registerFailWithNullValue(
			String username,
			String email,
			String password,
			String confirmPassword,
			String phoneNumber,
			String expectedAlertText
			) {
		driver.get("http://localhost/ecshop");
		EcshopIndexPage indexPage = new EcshopIndexPage(driver);
		indexPage.click_register_link();
		EcshopRegisterPage registerPage = new EcshopRegisterPage(driver);
		registerPage.inputUsername(username);
		registerPage.inputEmail(email);
		registerPage.inputPassword(password);
		registerPage.inputConfirmPassword(confirmPassword);
		registerPage.inputMobileNumber(phoneNumber);
		registerPage.clickRegBtn();
		registerPage.assertAlertText(expectedAlertText);
	}
}
