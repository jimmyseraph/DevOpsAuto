package com.testops.liudao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyDemo {
	public static void main(String[] args) {
		ClassLoader loader = ProxyDemo.class.getClassLoader();
		Class<?>[] interfaces = new Class<?>[] {ISayHi.class};
		InvocationHandler handler = new SayHiInvocationHandler();
		ISayHi sh = (ISayHi) Proxy.newProxyInstance(loader, interfaces, handler);
		sh.sayHi("你今天好吗？");
	}
}
