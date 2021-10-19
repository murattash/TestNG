package com.neotech.lesson04;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.ExcelUtility;

public class Homework1 extends CommonMethods {

	@BeforeMethod (alwaysRun = true)
	public void beforeMethod() {
		setUp();
	}

	@AfterMethod (alwaysRun = true)
	public void afterMethod() {
		tearDown();
	}


	@Test(dataProvider = "getData", groups = {"homeowrk", "regression"})
	public void test(String firstName, String lastName, String username, String password) {

		// Login
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));

		click(driver.findElement(By.id("btnLogin")));
		
		wait(2);

		// navigate to PIM

		click(driver.findElement(By.id("menu_pim_viewPimModule")));

		// click on add
		click(driver.findElement(By.id("btnAdd")));

		// fill out the employee info
		sendText(driver.findElement(By.id("firstName")), firstName);
		sendText(driver.findElement(By.id("lastName")), lastName);

		// get empId for validation
		String empID = driver.findElement(By.id("employeeId")).getAttribute("value");

		click(driver.findElement(By.id("chkLogin")));

		sendText(driver.findElement(By.id("user_name")), username);
		sendText(driver.findElement(By.id("user_password")), password);
		sendText(driver.findElement(By.id("re_password")), password);

		click(driver.findElement(By.id("btnSave")));
		
		//validation
		
		waitForVisibility(driver.findElement(By.id("pdMainContainer")));
		
		String actualId = driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
		
		Assert.assertEquals(actualId, empID, "Employee ID's do not match");
		
		
		//take a screenshot
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(source, new File("screenshot/" + firstName + "_" + lastName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	
	
	
	@DataProvider(name = "getData")
	public Object[][] getData() {
		
		Object[][] data = { {"jeff", "jeff", "jeff2021", "jeffjeff@123"}, {"sam", "sam", "sam2021", "samsam@123"}, {"Mary", "Jane", "mary2021", "maryjane@123"} };
		
		return data;
		
	}
	
	
	
	public Object[][] getExcelData(){
		
		return ExcelUtility.excelIntoArray(System.getProperty("user.dir") + "/testData.Excel.xlsx", "Employee");
	}
	
	
	
	
	
	
	
	
}
