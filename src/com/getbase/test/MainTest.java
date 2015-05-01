package com.getbase.test;

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

		// Open Login Page
		StartPage startPage = new StartPage(driver);
		startPage.openLoginPage();

		// Check Login Page and enter credentials
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterLoginCredentials("michal.jagoda@gmail.com",
				"getbasetest");

		// Check Dashboard page and switch to Leads
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.switchToLead();

		// Check Leads page
		LeadsPage leads = new LeadsPage(driver);

		// Close the browser
		driver.quit();
	}
}
