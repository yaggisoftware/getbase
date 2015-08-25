package test.java.com.getbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage {

	private WebDriver driver;
	private static final String PAGE_TITLE = "All-in-one Sales Platform | Base CRM Base";
	
	@FindBy(linkText = "Log In")
	private WebElement loginButton;
	
	public StartPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals(PAGE_TITLE)) {
			throw new IllegalStateException(
					"This is not sign in page, current page is: "
							+ driver.getCurrentUrl());
		}
	}

	/**
	 * Open login page
	 *
	 * @return
	 */
	public LoginPage openLoginPage() {
		loginButton.click();

		return new LoginPage(driver);
	}

}
