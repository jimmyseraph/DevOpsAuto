package com.testops.liudao.dataproviders;

import org.testng.annotations.DataProvider;

public class EcshopTestDataProvider {
	@DataProvider(name="null_value_test_data")
	public static Object[][] getRegisterDataWithNull(){
		return new Object[][] {
			{"","liudao006@163.com","123456","123456","123","- 用户名不能为空。\n"},
			{"liudao006","liudao006@163.com","","","123","- 登录密码不能为空。\n"},
			{"liudao006","liudao006@163.com","123456","12333","123","- 两次输入密码不一致\n"}
		};
	}
}
