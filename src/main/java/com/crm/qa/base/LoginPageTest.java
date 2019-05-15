package com.crm.qa.base;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		intialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageValidateTitleTest() {
		log.info("Validate Login page Logo TC1");
		String title = loginPage.validateLoginPage();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void crmLogoImgageTest() {
		log.info("Validate Login page Image TC2");
		boolean crmimg = loginPage.validateCRMImage();
		Assert.assertTrue(crmimg);
	}

	@Test(priority = 3)
	public void loginTest() throws InterruptedException {
		log.info("Validate Login to CRM application is scuccessful TC3");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() throws IOException {
		log.info("Close the Browser ");
		driver.quit();
		//Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
		
	}
}
