package com.getbase.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {

	private WebDriver driver;
	private static final String PAGE_URL = "https://app.futuresimple.com/settings/profile";
	private static final String LEADS_SETTINGS_LINK_TEXT = "Leads";
	private static final String LEAD_STATUSES_SETTINGS_LINK_TEXT = "Lead Statuses";

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getCurrentUrl().equals(PAGE_URL)) {
			throw new IllegalStateException(
					"This is not dashboard page, current page is: "
							+ driver.getCurrentUrl());
		}
	}

	public void openLeadsSettings() {
		driver.findElement(By.linkText(LEADS_SETTINGS_LINK_TEXT)).click();
	}

	public void openLeadsStatusSettings() {
		driver.findElement(By.linkText(LEAD_STATUSES_SETTINGS_LINK_TEXT))
				.click();
	}

	public void editLeadStatus(String newStatus) {
		driver.findElement(
				By.xpath(".//*[@id='lead-status']/div[1]/span[1]/div/div/label/h4/../../div/div/button"))
				.click();

		new WebDriverWait(driver, 10).until(ExpectedConditions
				.presenceOfElementLocated(By.id("name")));

		driver.findElement(
				By.xpath(".//*[@id='lead-status']/div[1]/span[1]/div/div/form/fieldset/div[2]/div/input"))
				.clear();
		driver.findElement(
				By.xpath(".//*[@id='lead-status']/div[1]/span[1]/div/div/form/fieldset/div[2]/div/input"))
				.sendKeys(newStatus);

		driver.findElement(
				By.xpath(".//*[@id='lead-status']/div[1]/span[1]/div/div/form/fieldset/div[3]/div/button"))
				.click();

		/*
		 * Not very elegant solution right now, could take into consideration
		 * Making this function more flexible like below
		 * driver.findElements(By.id("name")).get(3).clear();
		 * driver.findElements(By.id("name")).get(3).sendKeys(newStatus);
		 * driver.findElements(By.linkText("Save")).get(0).click();
		 */
	}
}
