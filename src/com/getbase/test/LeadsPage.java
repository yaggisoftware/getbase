package com.getbase.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadsPage {

	private WebDriver driver;
	private static final String LEAD_PAGE_URL = "https://app.futuresimple.com/leads";
	private static final String NEW_LEAD_PAGE_URL = "https://app.futuresimple.com/leads/new";

	// private static final String ACTIVE_ELEMENT = "Leads";

	public LeadsPage(WebDriver driver) {
		this.driver = driver;
		// if (!driver.findElement(By.className("span4")).getText()
		// .equals(ACTIVE_ELEMENT)) {
		if (!driver.getCurrentUrl().equals(LEAD_PAGE_URL)) {
			throw new IllegalStateException(
					"This is not Leads page, current page is: "
							+ driver.getCurrentUrl());
		}
	}

	public void createNewLead() {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.presenceOfElementLocated(By.linkText("Lead")));
		driver.findElement(By.linkText("Lead")).click();
	}

	public void checkNewLeadPage() {
		driver.getCurrentUrl().equals(NEW_LEAD_PAGE_URL);
	}

	public void fillAndSubmitNewLead(String firstName, String lastName) {
		driver.findElement(By.id("lead-first-name")).sendKeys(firstName);
		driver.findElement(By.id("lead-last-name")).sendKeys(lastName);
		driver.findElement(By.className("save")).click();
	}

	public void openTestLead(String leadName) {
		driver.findElement(By.linkText(leadName)).click();
	}

	public String checkLeadStatus(String leadName) {
		return driver.findElement(By.className("lead-status")).getText();
	}
}
