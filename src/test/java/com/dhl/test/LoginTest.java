package com.dhl.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dhl.base.AutomationWrapper;
import com.dhl.pages.DashboardPage;
import com.dhl.pages.LoginPage;
import com.dhl.utils.DataUtils;

public class LoginTest extends AutomationWrapper {

	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
	public void validLoginTest(String username, String password, String expectedHeader)
	{
		LoginPage loginPage= new LoginPage(driver);
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLogin();
		
		//driver.findElement(By.name("username")).sendKeys("Admin");
		//driver.findElement(By.name("password")).sendKeys("admin123");
		//driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//String actualHeader= driver.findElement(By.xpath("//h6[contains(normalize-space(), 'Dash')]")).getText();
		
		DashboardPage dashboardPage= new DashboardPage(driver);
		String actualHeader= dashboardPage.getDashboardHeader();
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	
	@Test(dataProvider = "commonDataProvider",dataProviderClass= DataUtils.class)
	public void invalidLoginTest(String username, String password, String expectedError)
	{
		LoginPage loginPage= new LoginPage(driver);
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLogin();
		
		String actualError= loginPage.getInvalidErrorMessage();
		Assert.assertTrue(actualError.contains(expectedError)); 
		
		//driver.findElement(By.name("username")).sendKeys("john");
		//driver.findElement(By.name("password")).sendKeys("john123");
		//driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//Assert the error - Invalid credentials
		//String actualError=driver.findElement(By.xpath("//p[contains(normalize-space(), 'Invalid')]")).getText();
		
		//DashboardPage dashboardPage= new DashboardPage(driver);
		//String actualError= loginPage.getInvalidErrorMessage();
		
	}
}
