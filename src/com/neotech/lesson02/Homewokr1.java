package com.neotech.lesson02;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class Homewokr1 extends CommonMethods{

	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}
	
	
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
	
	
	//I have two test methods in this class 
	//openAndNavigate will be executed before every test methods -> 2 times
	//setUp() will be executed every test methods 
	
	
	@Test
	public void negativeLoginTest() {
		
	}
	
	
	@Test
	public void loginValidation() {
		
	}
	
	
	
}
