package com.testops.liudao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SayHiInvocationHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("开始代理执行"+method.getName()+"方法");
		ISayHi sh = new SayHiImpl();
		Object ret = method.invoke(sh, args);
		System.out.println("代理"+method.getName()+"方法执行完成");
		return ret;
	}

}
