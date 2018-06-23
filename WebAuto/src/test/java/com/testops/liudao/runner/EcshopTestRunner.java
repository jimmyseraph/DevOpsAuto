package com.testops.liudao.runner;

import org.testng.annotations.AfterSuite;

import com.testops.liudao.utils.DriverUtils;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
		features= {"classpath:features"},
		glue= {"com.testops.liudao.steps"},
		monochrome=true,
		plugin= {"pretty","html:target/cucumber-report/html"}
	)
public class EcshopTestRunner extends AbstractTestNGCucumberTests {
	@AfterSuite
	public void closeService() {
		DriverUtils.stopAll();
	}
}
