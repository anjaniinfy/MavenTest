package com.crm.qa.base;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class ContactPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	TestUtil testUtil;
	String sheetName = "Contacts";

	public ContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		intialization();
		loginPage = new LoginPage();
		contactPage = new ContactPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactPage = homePage.clickingOnContactLink();
	}

	@Test(priority = 1)
	public void verifyContactLevelTest() {
		log.info("**********************Contact Label TestCase TC7*****************************");
		Assert.assertTrue(contactPage.verifyContactLabel(), "contact label is missing on the page");
	}

	
	@Test(priority = 2)
	public void selectsingleContactTest() {
		log.info("********************** select single Contact TC8 *****************************");
		contactPage.selectContactByName(52681854);
	}

	@Test(priority = 3)
	public void selectMultipleContactTest() {
		log.info("********************** select Multiple Contact TC9 *****************************");
		contactPage.selectContactByName(52681854);
		contactPage.selectContactByName(52681858);
	}

	@DataProvider
	public Object[][] getDataFromDataSheet() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider = "getDataFromDataSheet")
	public void validateCreateNewContact(String title, String firstName, String lastName, String Company) {
		log.info("**********************Validate Creat New Contact TC10/TC11*****************************");
		homePage.clickOnNewContactLink();
		// contactPage.createNewContact("Mr.", "Ram", "Kumar", "Google");
		contactPage.createNewContact(title, firstName, lastName, Company);
	}

	@AfterMethod
	public void tearDown() throws IOException {
		log.info("Browser is getting closed");
		driver.quit();
		//Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
	}

}
