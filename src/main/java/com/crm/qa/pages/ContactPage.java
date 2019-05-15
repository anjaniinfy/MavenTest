package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	//used to store value in cache memory so no need to go to UI again and again
	//@CacheLookup

	WebElement contactLable;

	@FindBy(xpath = "//input[@name='contact_id' and @value='52681725']")
	WebElement checkBoxcontact;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstname;

	@FindBy(xpath = "//input[@id='surname']")
	WebElement lastname;

	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement companyname;

	@FindBy(xpath = "//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	WebElement savebutn;
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactLabel() {
		return contactLable.isDisplayed();
	}

	public void selectContactByName(int i) {
		driver.findElement(By.xpath("//input[@name='contact_id' and @value='" + i + "']")).click();
	}// 52681725

	public void createNewContact(String title, String fstname, String lstname, String compy) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);

		firstname.sendKeys(fstname);
		lastname.sendKeys(lstname);
		companyname.sendKeys(compy);
		savebutn.click();

	}
}