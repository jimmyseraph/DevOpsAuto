package com.testops.liudao.demo;

import java.io.IOException;

import com.google.gson.Gson;
import com.testops.liudao.beans.PostRegisterUser;
import com.testops.liudao.beans.ReturnBean;
import com.testops.liudao.httpframework.EasyRequest;

import okhttp3.Response;

public class EasyRequestDemo {
	public static void main(String[] args) {
		Gson gson = new Gson();
		PostRegisterUser pru = new PostRegisterUser();
		pru.setUsername("liudao004");
		pru.setPassword("11111111");
		pru.setConfirmPassword("11111111");
		String json = gson.toJson(pru);
		
		try {
			Response response = new EasyRequest("http://localhost:10002/account/register")
					.method("post")
					.body("json", json)
					.doRequest();
			String result = response.body().string();
			System.out.println(result);
			ReturnBean rb = gson.fromJson(result, ReturnBean.class);
			System.out.println(rb.getRetMsg().equals("注册成功")?true:false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
