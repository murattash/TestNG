package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class DataProviderDemo extends CommonMethods {

	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}
	
	
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
	
	
	@Test (dataProvider = "getData")
	public void LoginFunctionality(String username, String password) {
		
		WebElement usernameTxt = driver.findElement(By.id("txtUsername"));
		sendText(usernameTxt, username);
		
		WebElement passwordTxt = driver.findElement(By.id("txtPassword"));
		sendText(passwordTxt, password);
		
		wait(1);
		driver.findElement(By.id("btnLogin")).click();
			
		// We didn't do any assertion, that's why the test will always pass
		
	}
	
	
	@DataProvider
	public Object[][] getData() {
		//The number of rows tells how many times the test will run
		Object[][] credetials = { { "Admin", "admins123"}, {"Flori", "EdiRama123"}, {"Komron", "horosho123"} };
	
		return credetials;
	}
	
	
}
