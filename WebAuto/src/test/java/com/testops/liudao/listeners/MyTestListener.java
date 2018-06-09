package com.testops.liudao.listeners;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyTestListener extends TestListenerAdapter{
	private static final Logger logger = LoggerFactory.getLogger(MyTestListener.class);
	@Override
	public void onTestStart(ITestResult result) {
		super.onTestStart(result);
		String methodName = result.getMethod().getMethodName();
		logger.info("测试方法"+methodName+"开始执行...");
	}
	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		String methodName = tr.getMethod().getMethodName();
		logger.info("测试方法"+methodName+"执行成功...");
	}
	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		String methodName = tr.getMethod().getMethodName();
		logger.warn("测试方法"+methodName+"执行失败...");
		// 失败时截图
		WebDriver driver;
		// 1、从当前正在运行的测试类中获取driver对象
		Object testObject = tr.getInstance();
		Class<?> testClass = tr.getTestClass().getRealClass();
		try {
			Field field = testClass.getField("driver");
			driver = (WebDriver)field.get(testObject);
			// 2、使用TakesScreenShot类进行截图
			File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// 3、将截图作为文件保存在指定的目录中
			File path = new File("screenShots");
			if(!path.exists()) {
				path.mkdir();
			}
			// 文件名希望格式是类名.方法名_YYYY-MM-dd_HH.mm.ss.png
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd_HH.mm.ss");
			String filename = testClass.getName()+"."+methodName+"_"+sdf.format(new Date())+".png";
			screenShot.renameTo(new File(path,filename));
			logger.info("错误截图已生成在"+path+"目录下，文件名为"+filename);
		} catch (NoSuchFieldException e) {
			logger.error("该文件不存在",e);
		} catch (SecurityException e) {
			logger.error("无法访问WebDriver字段",e);
		} catch (IllegalArgumentException e) {
			logger.error("访问WebDriver字段参数非法",e);
		} catch (IllegalAccessException e) {
			logger.error("访问WebDriver字段非法",e);
		}
		
		
 
		
	}
}
