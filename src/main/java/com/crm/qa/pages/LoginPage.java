package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory-OR

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnLogin;

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement btnSignUp;

	@FindBy(xpath = "//img[@src='https://classic.crmpro.com/img/logo.png']")
	WebElement crmlogo;

	// Initializing the driver
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPage() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();
	}

	public HomePage login(String usn, String pswd) throws InterruptedException {
		username.sendKeys(usn);
		password.sendKeys(pswd);
		Thread.sleep(2000);
		btnLogin.click();
		return new HomePage();
	}
}
