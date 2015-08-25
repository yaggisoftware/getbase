package test.java.com.getbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadsNewPage {

	private static final String NEW_LEAD_PAGE_URL = "https://app.futuresimple.com/leads/new";
	
	@FindBy(id = "lead-first-name")
	private WebElement leadFirstName;
	@FindBy(id = "lead-last-name")
	private WebElement leadLastName;
	@FindBy(className = "save")
	private WebElement leadSaveButton;

	public LeadsNewPage(WebDriver driver) {
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
		leadFirstName.sendKeys(firstName);
		leadLastName.sendKeys(lastName);
		leadSaveButton.click();
	}
}
