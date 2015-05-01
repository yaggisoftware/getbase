package com.getbase.test;

import org.openqa.selenium.WebDriver;

public class LeadsPage {

	private WebDriver driver;
	private static final String PAGE_URL = "https://app.futuresimple.com/leads";

	// private static final String ACTIVE_ELEMENT = "Leads";

	public LeadsPage(WebDriver driver) {
		this.driver = driver;
		// if (!driver.findElement(By.className("span4")).getText()
		// .equals(ACTIVE_ELEMENT)) {
		if (!driver.getCurrentUrl().equals(PAGE_URL)) {
			throw new IllegalStateException(
					"This is not Leads page, current page is: "
							+ driver.getCurrentUrl());
		}
	}

}
