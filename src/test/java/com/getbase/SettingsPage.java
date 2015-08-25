package test.java.com.getbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {

	private WebDriver driver;
	private static final String LEADS_URL = "https://app.futuresimple.com/settings/leads";
	
	@FindBy(linkText = "Leads")
	private WebElement leadsSettings; 
	@FindBy(linkText = "Lead Statuses")
	private WebElement leadsStatusesSettings;
	@FindBy(xpath = ".//*[@id='lead-status']/div[1]/span[1]/div/div/label/h4/../../div/div/button")
	private WebElement statusNewEditButton;
	@FindBy(xpath = ".//*[@id='lead-status']/div[1]/span[1]/div/div/form/fieldset/div[2]/div/input")
	private WebElement statusNewTextBox;
	@FindBy(xpath = ".//*[@id='lead-status']/div[1]/span[1]/div/div/form/fieldset/div[3]/div/button")
	private WebElement statusNewSaveButton;
	
	public SettingsPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @return Leads settings URL
	 */
	public String getLeadsSettingsURL(){
		return LEADS_URL;
	}

	/**
	 * Open Leads from settings menu
	 */
	public void openLeadsSettings() {
		leadsSettings.click();
	}

	/**
	 * Open Leads statuses from settings menu
	 */
	public void openLeadsStatusSettings() {
		leadsStatusesSettings.click();
	}

	/**
	 * Edit "New" Lead status. Find edit box, clear current status, fill text
	 * box with new status, submit
	 *
	 * @param newStatus
	 */
	public void editLeadStatusNew(String newStatus) {
		statusNewEditButton.click();

		new WebDriverWait(driver, 10).until(ExpectedConditions
				.presenceOfElementLocated(By.id("name")));

		statusNewTextBox.clear();
		statusNewTextBox.sendKeys(newStatus);
		statusNewSaveButton.click();
		/*
		 * Not very optimal solution right now, could take into consideration
		 * Making this function more flexible like below
		 * driver.findElements(By.id("name")).get(3).clear();
		 * driver.findElements(By.id("name")).get(3).sendKeys(newStatus);
		 * driver.findElements(By.linkText("Save")).get(0).click();
		 */
	}
}
