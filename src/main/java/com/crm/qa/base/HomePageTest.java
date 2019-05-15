package com.crm.qa.base;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	TestUtil testUtil;

	public HomePageTest() {
		super();
	}

	// test case should be executed--independent with each other
	// before each test case -- launch the browser and login application
	// @Test--Execute test cases
	// after each test case close the browser
	@BeforeMethod
	public void setup() throws InterruptedException {
		intialization();
		loginPage = new LoginPage();
		contactPage = new ContactPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		log.info("Validate Homepage Logo TC4");
		String hometitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(hometitle, "CRMPRO", "Home Page title not matching");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		log.info("Validate UserName  TC5");
		testUtil.switchToFrame();
		boolean name = homePage.verifyUserName();
		Assert.assertTrue(name);
	}

	@Test(priority = 3)
	public void verifyContactLinkTest() {
		log.info("Validate contact link is working TC6");
		testUtil.switchToFrame();
		contactPage = homePage.clickingOnContactLink();
	}

	@AfterMethod
	public void tearDown() throws IOException {
		log.info("Close the Brower");
		driver.quit();
		//Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");

	}
}
