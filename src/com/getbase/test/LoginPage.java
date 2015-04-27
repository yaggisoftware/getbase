package com.getbase.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private static final String PAGE_TITLE = "Login to Base";

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals(PAGE_TITLE)) {
			throw new IllegalStateException(
					"This is not sign in page, current page is: "
							+ driver.getCurrentUrl());
		}
	}

	public void enterLoginCredentials(String user, String password) {
		driver.findElement(By.name("user[email]")).sendKeys(user);
		driver.findElement(By.name("user[password]")).sendKeys(password);
	}
}
