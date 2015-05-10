package test.java.com.getbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeadsNewPage {

	private WebDriver driver;
	private static final String NEW_LEAD_PAGE_URL = "https://app.futuresimple.com/leads/new";
	private static final String SUBMIT_NEW_LEAD_FIRST_NAME = "lead-first-name";
	private static final String SUBMIT_NEW_LEAD_LAST_NAME = "lead-last-name";
	private static final String SUBMIT_NEW_LEAD_SAVE_BUTTON_TEXT = "save";

	public LeadsNewPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getCurrentUrl().equals(NEW_LEAD_PAGE_URL)) {
			throw new IllegalStateException(
					"This is not Leads page, current page is: "
							+ driver.getCurrentUrl());
		}
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
}
