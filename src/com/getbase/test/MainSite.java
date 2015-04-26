package com.getbase.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainSite {

	@Test
	public void firstTest() {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();

		// Open Base site
		driver.get("https://getbase.com/");

		Assert.assertEquals(
				"Intelligent Sales Productivity Platform | Base CRM",
				driver.getTitle());

		// Close the browser
		driver.quit();
	}
}
