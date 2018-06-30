package com.testops.liudao.demo;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpDemo {
	private static final OkHttpClient client = new OkHttpClient();
	public static void main(String[] args) {
		Request request = new Request.Builder()
				.url("http://localhost:10002/account/login?username=liudao003&password=123456")
				.get()
				.build();
		try(Response response = client.newCall(request).execute()){
			System.out.println(response.body().string());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
