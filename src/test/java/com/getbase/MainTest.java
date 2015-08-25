package test.java.com.getbase;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class MainTest {

	private WebDriver driver;

	private static final long IMPLICIT_TIMEOUT = 10;
	private static final String BASE_URL = "https://getbase.com/";
	private static final String DASHBOARD_TOOLBAR_URL = "https://app.futuresimple.com/sales";
	private static final String TEST_LOGIN = "yaggisoftware@gmail.com";
	private static final String TEST_PASSWORD = "getbasetest";
	private static final String TEST_LEAD_FIRST_NAME = "Test";
	private static final String TEST_LEAD_LAST_NAME = String.valueOf(System
			.currentTimeMillis());
	private static final String TEST_LEAD_NEW_STATUS = "New";
	private static final String CHANGED_TEST_LEAD_NEW_STATUS = "TestNew";
	

	/**
	 * Do initialization before any test case is started. Create new instance of
	 * the Firefox, open browser, open main URL
	 */
	@Before
	public void Initialize() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		driver.manage().timeouts()
				.implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		
		// Open Base site
		driver.get(BASE_URL);
	}

	/**
	 * 1. Log into the Web version of Base. 2. Create a new Lead. 3. Check that
	 * its Lead status is "New" 4. Go into Settings / Leads / Lead statuses and
	 * change the name of the "New" status to a different name. 5. Go back to
	 * the Lead to check if the name change is reflected.
	 */
	@Test
	public void firstTest() {
		// Open Login Page
		StartPage startPage = PageFactory.initElements(driver, StartPage.class);
		startPage.openLoginPage();

		// Check Login Page and enter credentials
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterLoginCredentials(TEST_LOGIN, TEST_PASSWORD);
		
		// Check Dashboard page and switch to Leads
		DashboardToolbarPage dashboard = PageFactory.initElements(driver, DashboardToolbarPage.class);
		dashboard.switchToLead();

		// Check Leads page and create new lead
		LeadsPage leads = PageFactory.initElements(driver, LeadsPage.class);
		leads.createNewLead();

		// Fill and submit lead
		LeadsNewPage newlead = PageFactory.initElements(driver, LeadsNewPage.class);
		newlead.fillAndSubmitNewLead(TEST_LEAD_FIRST_NAME, TEST_LEAD_LAST_NAME);

		// Open lead and check status
		leads.openTestLead(TEST_LEAD_FIRST_NAME + " " + TEST_LEAD_LAST_NAME);
		Assert.assertEquals(TEST_LEAD_NEW_STATUS, leads.checkLeadStatus());

		// Open settings
		dashboard.switchToSettings();

		// Open settings leads
		SettingsPage settings = PageFactory.initElements(driver, SettingsPage.class);
		settings.openLeadsSettings();
		Assert.assertEquals(settings.getLeadsSettingsURL(), driver.getCurrentUrl());

		// Open lead statuses
		settings.openLeadsStatusSettings();
		settings.editLeadStatusNew(CHANGED_TEST_LEAD_NEW_STATUS);

		// Open lead and check changed status
		dashboard.switchToLead();
		Assert.assertEquals(leads.getLeadsURL(), driver.getCurrentUrl());
		leads.openTestLead(TEST_LEAD_FIRST_NAME + " " + TEST_LEAD_LAST_NAME);
		Assert.assertEquals(CHANGED_TEST_LEAD_NEW_STATUS,
				leads.checkLeadStatus());
	}

	@After
	public void Teardown() {
		// Start cleanup from main page
		driver.get(DASHBOARD_TOOLBAR_URL);

		// Open settings
		DashboardToolbarPage dashboard = PageFactory.initElements(driver, DashboardToolbarPage.class);
		dashboard.switchToSettings();

		// Check settings page and open leads settings
		SettingsPage settings = PageFactory.initElements(driver, SettingsPage.class);
		settings.openLeadsSettings();
		Assert.assertEquals(settings.getLeadsSettingsURL(), driver.getCurrentUrl());

		// Open lead statuses and bring back Lead status to "New"
		settings.openLeadsStatusSettings();
		settings.editLeadStatusNew(TEST_LEAD_NEW_STATUS);

		// Close the browser
		driver.quit();
	}
}
