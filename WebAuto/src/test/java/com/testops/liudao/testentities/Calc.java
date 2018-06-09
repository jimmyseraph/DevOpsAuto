package com.testops.liudao.testentities;

public class Calc {
	public int compute(int x, int y) {
		if(x > y) {
			return x - y;
		}else if(x < y) {
			return x + y;
		}else {
			return x * y;
		}
	}
}
