package test.java.com.getbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {

	private WebDriver driver;
	private static final String PAGE_URL = "https://app.futuresimple.com/settings/profile";
	private static final String LEADS_SETTINGS_LINK_TEXT = "Leads";
	private static final String LEAD_STATUSES_SETTINGS_LINK_TEXT = "Lead Statuses";
	private static final String STATUS_NEW_EDIT_BUTTON_XPATH = ".//*[@id='lead-status']/div[1]/span[1]/div/div/label/h4/../../div/div/button";
	private static final String STATUS_NEW_TEXT_BOX_XPATH = ".//*[@id='lead-status']/div[1]/span[1]/div/div/form/fieldset/div[2]/div/input";
	private static final String STATUS_NEW_SAVE_BUTTON_XPATH = ".//*[@id='lead-status']/div[1]/span[1]/div/div/form/fieldset/div[3]/div/button";

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getCurrentUrl().equals(PAGE_URL)) {
			throw new IllegalStateException(
					"This is not dashboard page, current page is: "
							+ driver.getCurrentUrl());
		}
	}

	/**
	 * Open Leads from settings menu
	 */
	public void openLeadsSettings() {
		driver.findElement(By.linkText(LEADS_SETTINGS_LINK_TEXT)).click();
	}

	/**
	 * Open Leads statuses from settings menu
	 */
	public void openLeadsStatusSettings() {
		driver.findElement(By.linkText(LEAD_STATUSES_SETTINGS_LINK_TEXT))
				.click();
	}

	/**
	 * Edit "New" Lead status. Find edit box, clear current status, fill text
	 * box with new status, submit
	 *
	 * @param newStatus
	 */
	public void editLeadStatusNew(String newStatus) {
		driver.findElement(By.xpath(STATUS_NEW_EDIT_BUTTON_XPATH)).click();

		new WebDriverWait(driver, 10).until(ExpectedConditions
				.presenceOfElementLocated(By.id("name")));

		driver.findElement(By.xpath(STATUS_NEW_TEXT_BOX_XPATH)).clear();
		driver.findElement(By.xpath(STATUS_NEW_TEXT_BOX_XPATH)).sendKeys(
				newStatus);
		driver.findElement(By.xpath(STATUS_NEW_SAVE_BUTTON_XPATH)).click();
		/*
		 * Not very optimal solution right now, could take into consideration
		 * Making this function more flexible like below
		 * driver.findElements(By.id("name")).get(3).clear();
		 * driver.findElements(By.id("name")).get(3).sendKeys(newStatus);
		 * driver.findElements(By.linkText("Save")).get(0).click();
		 */
	}
}
