package com.dhl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dhl.base.WebDriverKeywords;

public class LoginPage extends WebDriverKeywords{
	
	private By usernameLocator=By.name("username");
	private By passwordLocator=By.name("password");
	private By loginLocator=By.xpath("//button[normalize-space()='Login']");
	private By errorLocator=By.xpath("//p[contains(normalize-space(),'Invalid')]");
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void enterUsername(String username)
	{
		//driver.findElement(By.name("username")).sendKeys("Admin");
		super.TypeOnElement(usernameLocator, username);
	}
	
	//create a method for entering password
	//method for clickOnLogin()
	public void enterPassword(String password)
	{
	//driver.findElement(By.name("password")).sendKeys("admin123");
		TypeOnElement(passwordLocator, password);
	}
	
	public void clickOnLogin()
	{
		//driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		clickOnElement(loginLocator);
	}
	
	public String getInvalidErrorMessage()
	{
		//return driver.findElement(By.xpath("//p[contains(normalize-space(), 'Invalid')]")).getText();
		return super.getTextFromElement(errorLocator);
	}
	
	public String getUsernamePlaceholder()
	{
		//return driver.findElement(By.name("username")).getAttribute("placeholder");
		return super.getAttributeValue(usernameLocator, "placeholder");
	}
	
	public String getPasswordPlaceholder()
	{
		//return driver.findElement(By.name("password")).getAttribute("placeholder");
		return super.getAttributeValue(passwordLocator, "placeholder");
	}

}
