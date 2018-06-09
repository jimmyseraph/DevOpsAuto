package com.testops.liudao.anno;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainDemo {
	public static void main(String[] args) {
		AnnoDemo ad = new AnnoDemo();
		Class<?> clazz = AnnoDemo.class;
		Method[] methods = clazz.getMethods();
		for(int i = 0; i < methods.length; i++) {
			SayHi[] sayHis = methods[i].getAnnotationsByType(SayHi.class);
			for(int j = 0; j < sayHis.length; j++) {
				String msg = sayHis[j].msg();
				System.out.println(msg);
			}
			if(sayHis.length > 0) {
				try {
					methods[i].invoke(ad);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
