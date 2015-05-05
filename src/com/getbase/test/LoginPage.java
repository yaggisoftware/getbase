package com.getbase.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private static final String PAGE_TITLE = "Login to Base";
	private static final String LOG_IN_EMAIL_NAME = "user[email]";
	private static final String LOG_IN_PASSWORD_NAME = "user[password]";
	private static final String LOG_IN_BUTTON_CLASS = "btn";

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals(PAGE_TITLE)) {
			throw new IllegalStateException(
					"This is not sign in page, current page is: "
							+ driver.getCurrentUrl());
		}
	}

	/**
	 * Fill login form by entering user and password and then submitting form
	 *
	 * @param user
	 * @param password
	 */
	public void enterLoginCredentials(String user, String password) {
		driver.findElement(By.name(LOG_IN_EMAIL_NAME)).sendKeys(user);
		driver.findElement(By.name(LOG_IN_PASSWORD_NAME)).sendKeys(password);
		driver.findElement(By.className(LOG_IN_BUTTON_CLASS)).click();
	}
}
