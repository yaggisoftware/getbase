package com.getbase.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainSite {

	public static void main(String[] args) {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();

		// Open Base site
		driver.get("https://getbase.com/");

		// Close the browser
		driver.quit();
	}
}
