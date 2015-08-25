package test.java.com.getbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	private WebDriver driver;
	private static final String PAGE_TITLE = "Login to Base";
	
	@FindBy(name = "user[email]")
	private WebElement loginFieldEmail;
	@FindBy(name = "user[password]")
	private WebElement loginFieldPassword;
	@FindBy(className = "btn")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals(PAGE_TITLE)) {
			throw new IllegalStateException(
					"This is not sign in page, current page is: "
							+ driver.getCurrentUrl());
		}
	}

	/**
	 * Fill login form by entering user and password and then submitting form
	 *
	 * @param user
	 * @param password
	 */
	public DashboardToolbarPage enterLoginCredentials(String user, String password) {
		loginFieldEmail.sendKeys(user);
		loginFieldPassword.sendKeys(password);
		loginButton.click();

		return new DashboardToolbarPage(driver);
	}
}
