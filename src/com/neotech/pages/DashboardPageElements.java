package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods{

	@FindBy(id = "welcome")
	public WebElement welcome;
	
	
	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement PIM;
	

	public DashboardPageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
