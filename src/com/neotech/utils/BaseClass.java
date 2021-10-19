package com.neotech.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	public static WebDriver driver;
	
	/**
	 * This method will create the driver and return it 
	 * 
	 * 
	 * @return
	 */
	
	@BeforeMethod
	public static WebDriver setUp(){
		ConfigsReader.readProperty(Constants.CONFIGURATION_FILEPATH);		
		
		if(ConfigsReader.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVE_PATH);
			driver = new ChromeDriver();
		} else if (ConfigsReader.getProperty("browser").equals("firefox")) {
			System.out.println("I want to open firefox browser");
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVE_PATH);
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		//driver.manage().window().fullscreen();
		driver.get(ConfigsReader.getProperty("url"));
		return driver;
	}
	
	
	/**
	 * This method will quit the browser
	 */
	
	@AfterMethod
	public static void tearDown(){
		if (driver != null) {
			driver.quit();	
		}
		
	}
	
}
