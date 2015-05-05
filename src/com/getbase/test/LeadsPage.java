package com.getbase.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadsPage {

	private WebDriver driver;
	private static final String LEAD_PAGE_URL = "https://app.futuresimple.com/leads";
	private static final String NEW_LEAD_PAGE_URL = "https://app.futuresimple.com/leads/new";
	private static final String NEW_LEAD_BUTTON_TEXT = "Lead";
	private static final String SUBMIT_NEW_LEAD_FIRST_NAME = "lead-first-name";
	private static final String SUBMIT_NEW_LEAD_LAST_NAME = "lead-last-name";
	private static final String SUBMIT_NEW_LEAD_SAVE_BUTTON_TEXT = "save";
	private static final String LEAD_STATUS_CLASS_NAME = "lead-status";

	public LeadsPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getCurrentUrl().equals(LEAD_PAGE_URL)) {
			throw new IllegalStateException(
					"This is not Leads page, current page is: "
							+ driver.getCurrentUrl());
		}
	}

	/**
	 * Open page to create new Lead
	 */
	public void createNewLead() {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.presenceOfElementLocated(By.linkText(NEW_LEAD_BUTTON_TEXT)));
		driver.findElement(By.linkText(NEW_LEAD_BUTTON_TEXT)).click();
		driver.getCurrentUrl().equals(NEW_LEAD_PAGE_URL);
	}

	/**
	 * Fill first name and last name for lead and submit
	 *
	 * @param firstName
	 * @param lastName
	 */
	public void fillAndSubmitNewLead(String firstName, String lastName) {
		driver.findElement(By.id(SUBMIT_NEW_LEAD_FIRST_NAME)).sendKeys(
				firstName);
		driver.findElement(By.id(SUBMIT_NEW_LEAD_LAST_NAME)).sendKeys(lastName);
		driver.findElement(By.className(SUBMIT_NEW_LEAD_SAVE_BUTTON_TEXT))
				.click();
	}

	/**
	 * Open test lead with requested name
	 *
	 * @param leadName
	 */
	public void openTestLead(String leadName) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.presenceOfElementLocated(By.linkText(leadName)));
		driver.findElement(By.linkText(leadName)).click();
	}

	/**
	 * Check lead status and return it as String
	 *
	 * @return
	 */
	public String checkLeadStatus() {
		return driver.findElement(By.className(LEAD_STATUS_CLASS_NAME))
				.getText();
	}

}
