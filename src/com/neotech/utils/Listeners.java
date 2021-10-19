package com.neotech.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	
	public void onStart(ITestContext context) {
		
		System.out.println("Functionality Test Starting");
		
	}
	
	
	public void onFinish(ITestContext context) {
		
		System.out.println("Functionality Test Finished");
		
	}
	
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test Started: " + result.getName());
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Passed" + result.getName());
		
	}
	
	
	public void onTestFailure (ITestResult result) {
		
		System.out.println("Test Failed" + result.getName());
		
	}
	
	
	
	
	
}
