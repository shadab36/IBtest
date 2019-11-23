package com.intelligencebank.platform;

import com.intelligencebank.utils.Retry;
import org.testng.*;

import com.intelligencebank.utils.CucumberTestContext;
import com.intelligencebank.utils.WebDriverManager;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Listeners implements ITestListener, IAnnotationTransformer {

	// CucumberTestContext cucumberTestContext;

	// public Listeners(CucumberTestContext context) {
	//	cucumberTestContext = context;
	//}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		//hey i am done
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		//
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {

		try {
 			CucumberTestContext cucumberTestContext = new CucumberTestContext();
 			WebDriverManager webDriverManager = cucumberTestContext.getWebDriverManager();

			String contextPart = result.getMethod().getMethodName();
			String filenamePart = " failed ";

			if (webDriverManager != null) webDriverManager.takeScreenshot(contextPart, filenamePart);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
		iTestAnnotation.setRetryAnalyzer(Retry.class);
	}
}
