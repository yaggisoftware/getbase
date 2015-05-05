package com.getbase.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardToolbarPage {

	private WebDriver driver;
	private static final String PAGE_URL = "https://app.futuresimple.com/sales";
	private static final String LEADS_PAGE_BUTTON_ID = "nav-leads";
	private static final String SETTINGS_PAGE_BUTTON_CLASS = "icon-cogs";
	private static final String SETTINGS_PAGE_BUTTON_LINK_TEXT = "Settings";

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
	public void switchToLead() {
		driver.findElement(By.id(LEADS_PAGE_BUTTON_ID)).click();
	}

	/**
	 * Open settings page
	 */
	public void switchToSettings() {
		driver.findElement(By.className(SETTINGS_PAGE_BUTTON_CLASS)).click();
		driver.findElement(By.linkText(SETTINGS_PAGE_BUTTON_LINK_TEXT)).click();
	}

}
