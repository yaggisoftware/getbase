package com.getbase.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage {

	private WebDriver driver;
	private static final String PAGE_URL = "https://app.futuresimple.com/settings/profile";
	private static final String LEADS_SETTINGS_LINK_TEXT = "Leads";
	private static final String LEAD_STATUSES_SETTINGS_LINK_TEXT = "Lead Statuses";

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getCurrentUrl().equals(PAGE_URL)) {
			throw new IllegalStateException(
					"This is not dashboard page, current page is: "
							+ driver.getCurrentUrl());
		}
	}

	public void openLeadsSettings() {
		driver.findElement(By.linkText(LEADS_SETTINGS_LINK_TEXT)).click();
	}

	public void openLeadsStatusSettings() {
		driver.findElement(By.linkText(LEAD_STATUSES_SETTINGS_LINK_TEXT))
				.click();
	}
}
