package com.testops.liudao.httpframework;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class EasyRequest {
	
	private String url;
	private String method;
	private RequestBody requestBody;
	private Map<String, String> headers = new HashMap<>();
	private final static TempCookieJar cookieJar = new TempCookieJar();
	
	private final OkHttpClient client = new OkHttpClient.Builder()
			.followRedirects(true)
			.connectTimeout(30L, TimeUnit.SECONDS)
			.readTimeout(30L, TimeUnit.SECONDS)
			.cookieJar(cookieJar)
			.build();
	
	public EasyRequest(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public EasyRequest url(String url) {
		this.url = url;
		return this;
	}
	
	public EasyRequest method(String method) {
		this.method = method.toUpperCase();
		return this;
	}
	
	public String getMethod() {
		return this.method;
	}
	
	public EasyRequest body(String mimeType, String body) {
		mimeType = mimeType.toLowerCase();
		MediaType mediaType = null;
		switch(mimeType) {
			case "plain":
				mediaType = MediaType.parse("text/plain;charset=utf-8");
				break;
			case "json":
				mediaType = MediaType.parse("application/json;charset=utf-8");
				break;
			case "xml":
				mediaType = MediaType.parse("application/xml;charset=utf-8");
				break;
			default:
				System.err.println("不支持的mime-type类型");
				break;
		}
		if(mediaType != null) {
			this.requestBody = RequestBody.create(mediaType, body);
		}
		return this;
	}
	
	public EasyRequest formBody(String key, String value) {
		FormBody.Builder builder = new FormBody.Builder();
		if(this.requestBody != null && this.requestBody.getClass().isAssignableFrom(FormBody.class)) {
			FormBody formBody = (FormBody)requestBody;
			for(int i = 0; i < formBody.size(); i++) {
				builder.add(formBody.name(i), formBody.value(i));
			}
		}
		builder.add(key, value);
		this.requestBody = builder.build();
		return this;
	}
	
	public EasyRequest header(String headerName, String headerValue) {
		headers.put(headerName, headerValue);
		return this;
	}
	
	public EasyRequest cookie(Cookie cookie) {
		cookieJar.addCookie(cookie);
		return this;
	}
	public EasyRequest removeCookie(String name) {
		cookieJar.removeCookie(name);
		return this;
	}
	public EasyRequest clearCookies() {
		cookieJar.clearCookies();;
		return this;
	}
	
	public Response doRequest() throws IOException {
		Request.Builder builder = new Request.Builder();
		builder.url(this.url);
		if(this.headers.size() > 0) {
			for(Map.Entry<String, String> entry : headers.entrySet()) {
				builder.header(entry.getKey(), entry.getValue());				
			}
		}
		builder.method(method, requestBody);
		Response response = client.newCall(builder.build()).execute();
		return response;
	}
	
}
