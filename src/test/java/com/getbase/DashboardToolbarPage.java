package test.java.com.getbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardToolbarPage {
	

	private WebDriver driver;
	private static final String PAGE_URL = "https://app.futuresimple.com/sales";
	
	@FindBy(id = "nav-leads")
	private WebElement leadsSwitch;
	@FindBy(className = "user-avatar")
	private WebElement profileSwitch;
	@FindBy(linkText = "Settings")
	private WebElement settingsSwitch;
	
	public DashboardToolbarPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getCurrentUrl().equals(PAGE_URL)) {
			throw new IllegalStateException(
					"This is not dashboard page, current page is: "
							+ driver.getCurrentUrl());
		}
	}

	/**
	 * Click Leads on a toolbar
	 */
	public LeadsPage switchToLead() {
		leadsSwitch.click();

		return new LeadsPage(driver);
	}

	/**
	 * Open settings page
	 */
	public SettingsPage switchToSettings() {
		profileSwitch.click();
		settingsSwitch.click();

		return new SettingsPage(driver);
	}

}
