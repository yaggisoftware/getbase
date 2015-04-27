package com.getbase.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainTest {

	@Test
	public void firstTest() {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();

		// Open Base site
		driver.get("https://getbase.com/");

		// Check main if main page is opened and have proper title
		Assert.assertEquals(
				"Intelligent Sales Productivity Platform | Base CRM",
				driver.getTitle());

		// Open Login Page
		StartPage startPage = new StartPage(driver);
		startPage.openLoginPage();

		// Check Login Page
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterLoginCredentials("michal.jagoda@gmail.com",
				"getbasetest");

		// Close the browser
		driver.quit();
	}
}
