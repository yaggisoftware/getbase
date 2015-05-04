package com.getbase.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage {

	private WebDriver driver;
	private static final String PAGE_TITLE = "Intelligent Sales Productivity Platform | Base CRM";
	private static final String LOGIN_BUTTON_LINK_TEXT = "LOGIN";

	// Check main if main page is opened and have proper title in constructor
	public StartPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals(PAGE_TITLE)) {
			throw new IllegalStateException(
					"This is not sign in page, current page is: "
							+ driver.getCurrentUrl());
		}
	}

	// Open login page
	public LoginPage openLoginPage() {
		driver.findElement(By.linkText(LOGIN_BUTTON_LINK_TEXT)).click();

		return new LoginPage(driver);
	}

}