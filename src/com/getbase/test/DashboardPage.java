package com.getbase.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

	private WebDriver driver;
	// private static final String ACTIVE_ELEMENT = "Dashboard";
	private static final String PAGE_URL = "https://app.futuresimple.com/sales";

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		// if (!driver.findElement(By.className("span12")).getText()
		// .equals(ACTIVE_ELEMENT)) {
		if (!driver.getCurrentUrl().equals(PAGE_URL)) {
			throw new IllegalStateException(
					"This is not dashboard page, current page is: "
							+ driver.getCurrentUrl());
		}
	}

	public void switchToLead() {
		driver.findElement(By.id("nav-leads")).click();
	}

}
