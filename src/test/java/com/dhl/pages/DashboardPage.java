package com.dhl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dhl.base.WebDriverKeywords;

public class DashboardPage extends WebDriverKeywords {
	
	private By dashboardHeaderLocator=By.xpath("//h6[contains(normalize-space(),'Dash')]");
	
	public DashboardPage(WebDriver driver)
	{
		super(driver);
	}
	
	public String getDashboardHeader()
	{
//		return driver.findElement(dashboardHeaderLocator).getText();
		return super.getTextFromElement(dashboardHeaderLocator);
	}

	
}