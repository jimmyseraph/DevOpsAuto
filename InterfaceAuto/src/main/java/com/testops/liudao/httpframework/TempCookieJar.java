package com.testops.liudao.httpframework;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public class TempCookieJar implements CookieJar {
	private final List<Cookie> cookieList = new ArrayList<>();

	@Override
	public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
		cookieList.addAll(cookies);
	}

	@Override
	public List<Cookie> loadForRequest(HttpUrl url) {
		return cookieList;
	}
	
	public void clearCookies() {
		cookieList.clear();
	}
	
	public void addCookie(Cookie cookie) {
		cookieList.add(cookie);
	}
	
	public void removeCookie(String name) {
		for(int i = 0; i < cookieList.size(); i++) {
			if(cookieList.get(i).name().equals(name)) {
				cookieList.remove(i);
			}
		}
	}
}
