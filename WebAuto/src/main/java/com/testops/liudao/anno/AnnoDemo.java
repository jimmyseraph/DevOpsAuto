package com.testops.liudao.anno;

public class AnnoDemo {
	
	@SayHi(msg="你好")
	public void doSomething() {
		System.out.println("I am doing something!");
	}
}
