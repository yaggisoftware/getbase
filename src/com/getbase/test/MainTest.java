package com.getbase.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainTest {

	private static final long IMPLICIT_TIMEOUT = 10;
	private static final String BASE_URL = "https://getbase.com/";
	private static final String TEST_LOGIN = "michal.jagoda@gmail.com";
	private static final String TEST_PASSWORD = "getbasetest";
	private static final String TEST_LEAD_FIRST_NAME = "Test";
	private static final String TEST_LEAD_LAST_NAME = String.valueOf(System
			.currentTimeMillis());
	private static final String TEST_LEAD_NEW_STATUS = "New";
	private static final String CHANGED_TEST_LEAD_NEW_STATUS = "TestNew";

	@Test
	public void firstTest() {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts()
				.implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);

		// Open Base site
		driver.get(BASE_URL);

		// Open Login Page
		StartPage startPage = new StartPage(driver);
		startPage.openLoginPage();

		// Check Login Page and enter credentials
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterLoginCredentials(TEST_LOGIN, TEST_PASSWORD);

		// Check Dashboard page and switch to Leads
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.switchToLead();

		// Check Leads page
		LeadsPage leads = new LeadsPage(driver);
		leads.createNewLead();
		leads.checkNewLeadPage();

		// Fill and submit lead
		leads.fillAndSubmitNewLead(TEST_LEAD_FIRST_NAME, TEST_LEAD_LAST_NAME);

		// Open lead and check status
		leads.openTestLead(TEST_LEAD_FIRST_NAME + " " + TEST_LEAD_LAST_NAME);
		Assert.assertEquals(TEST_LEAD_NEW_STATUS, leads.checkLeadStatus());

		// Start settings
		leads.switchToSettings();
		SettingsPage settings = new SettingsPage(driver);

		// Open settings leads and
		settings.openLeadsSettings();
		Assert.assertEquals("https://app.futuresimple.com/settings/leads",
				driver.getCurrentUrl());

		// Open lead statuses
		settings.openLeadsStatusSettings();
		settings.editLeadStatus(CHANGED_TEST_LEAD_NEW_STATUS);

		// Open lead and check changed status
		dashboard.switchToLead();
		leads.openTestLead(TEST_LEAD_FIRST_NAME + " " + TEST_LEAD_LAST_NAME);
		Assert.assertEquals(CHANGED_TEST_LEAD_NEW_STATUS,
				leads.checkLeadStatus());

		// Close the browser
		driver.quit();
	}
}
