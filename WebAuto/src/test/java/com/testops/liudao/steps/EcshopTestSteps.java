package com.testops.liudao.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

import com.testops.liudao.ecshop.pages.EcshopIndexPage;
import com.testops.liudao.ecshop.pages.EcshopRegisterPage;
import com.testops.liudao.utils.DriverUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EcshopTestSteps {
	private EcshopIndexPage indexPage;
	private EcshopRegisterPage registerPage;
	private static WebDriver driver;
	
	@Given("^打开ECshop首页$")
	public void open_ecshop_index() {
		driver = DriverUtils.getWebDriver("chrome");
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.get("http://localhost/ecshop");
		indexPage = new EcshopIndexPage(driver);
	}
	
	@And("^点击免费注册链接$")
	public void click_register_link() {
		indexPage.click_register_link();
		registerPage = new EcshopRegisterPage(driver);
	}
	
	@When("^填入\"([^\"]+)\"为\"([^\"]+)\"$")
	public void do_register_input(String inputName, String content) {
		switch(inputName) {
			case "用户名":
				registerPage.inputUsername(content);
				break;
			case "邮箱":
				registerPage.inputEmail(content);
				break;
			case "密码":
				registerPage.inputPassword(content);
				break;
			case "确认密码":
				registerPage.inputConfirmPassword(content);
				break;
			case "手机号码":
				registerPage.inputMobileNumber(content);
				break;
			default:
				throw new RuntimeException("未知字段");
		}
	}
	
	@And("点击注册按钮")
	public void click_register_btn() {
		registerPage.clickRegBtn();
	}
	
	@Then("在用户页面显示\"([^\"]+)\"")
	public void assert_register_success(String result) {
		registerPage.assertRegisterResult(result);
	}
}
