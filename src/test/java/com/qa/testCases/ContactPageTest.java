package com.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.ContactPage;
import com.qa.pages.HomePage;
import com.qa.pages.LandingPage;
import com.qa.pages.LoginPage;
import com.qa.utilities.TimeUtils;

public class ContactPageTest extends Base {
	
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	String sheetName = "contactUs";
	
	public ContactPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initializeBrowser();
		landingPage = new LandingPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		
		loginPage = landingPage.clickOnLoginBtn();
		homePage = loginPage.enterLoginCredentials(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homePage.clickOnContacts();
	}
	
	@Test(priority=1)
	public void validateTitle()
	{
		String actualTitle_CONTACT_PAGE = contactPage.validateTitePage();
		Assert.assertEquals(actualTitle_CONTACT_PAGE, TimeUtils.expectedTitile_PAGE);
	}
	
	@Test(priority=2)
	public void validateContactPageFully()
	{
		contactPage.validateContactPage();
	}
	
	@Test(priority=3, dataProvider = "getData")
	public void createContactForm(String firstName, String lastName, String description) throws InterruptedException
	{
		contactPage.clickOnCreateContact(firstName, lastName, description);
	}
	
//	@Test(priority=3)
//	public void clickOnContact()
//	{
//		contactPage.clickOnAnyExistingContact(TimeUtils.name);
//	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object data[][] = TimeUtils.getTestData(sheetName);
		return data;
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
