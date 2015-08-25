package test.java.com.getbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadsPage {

	private WebDriver driver;
	private static final String LEAD_PAGE_URL = "https://app.futuresimple.com/leads";
	@FindBy(linkText = "Lead")
	private WebElement newLeadButton;
	@FindBy(className = "lead-status")
	private WebElement leadStatus;

	public LeadsPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getCurrentUrl().equals(LEAD_PAGE_URL)) {
			throw new IllegalStateException(
					"This is not Leads page, current page is: "
							+ driver.getCurrentUrl());
		}
	}

	public String getLeadsURL(){
		return LEAD_PAGE_URL;
	}

	/**
	 * Open page to create new Lead
	 */
	public LeadsNewPage createNewLead() {
		new WebDriverWait(driver, 30).until(ExpectedConditions
				.elementToBeClickable(newLeadButton));
		newLeadButton.click();

		return new LeadsNewPage(driver);
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
		return leadStatus.getText();
	}

}
