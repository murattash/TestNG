package com.neotech.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class LoginTest extends CommonMethods{

	@Test
	public void validLogin() {
		
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		wait(1);
		
		sendText(login.password, ConfigsReader.getProperty("password"));
		wait(1);
		
		jsClick(login.button);
		wait(2);
		
		boolean welcomeDisplayed = dashboard.welcome.isDisplayed();
		
		//here we are doing the assertion
		Assert.assertTrue(welcomeDisplayed, "Welcome message is NOT displayed");
		
		
	}
}

