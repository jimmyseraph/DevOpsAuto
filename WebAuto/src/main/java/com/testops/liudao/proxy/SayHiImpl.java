package com.testops.liudao.proxy;

public class SayHiImpl implements ISayHi{

	@Override
	public void sayHi(String msg) {
		System.out.println("hi, "+msg);
	}

}
