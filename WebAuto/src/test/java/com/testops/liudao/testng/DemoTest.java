package com.testops.liudao.testng;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testops.liudao.testentities.Calc;

public class DemoTest {
	
	@BeforeMethod
	public void initMethod() {
		System.out.println("now running in BeforeMethod...");
	}
	
	@DataProvider(name="calc_test_data")
	public Object[][] getCalcTestData(){
		return new Object[][] {
			{10,20,30},
			{20,20,400},
			{40,20,20}
		};
	}
	
	@Test(dataProvider="calc_test_data")
	public void testCompute(int x, int y, int expected) {
		System.out.println("now running in testCompute...");
		Calc ca = new Calc();
		int actual = ca.compute(x, y);
		assertEquals(actual, expected);
	}
	
	/*@Test
	public void testCompute() {
		Calc ca = new Calc();
		int x = 10, y = 20;
		int expected = 30;
		int actual = ca.compute(x, y);
		assertEquals(actual, expected);
	}
	@Test
	public void testCompute2() {
		Calc ca = new Calc();
		int x = 20, y = 20;
		int expected =400;
		int actual = ca.compute(x, y);
		assertEquals(actual, expected);
	}
	@Test
	public void testCompute3() {
		Calc ca = new Calc();
		int x = 40, y = 20;
		int expected = 20;
		int actual = ca.compute(x, y);
		assertEquals(actual, expected);
	}*/
}
