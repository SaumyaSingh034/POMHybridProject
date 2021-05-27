
package com.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.ContactPage;
import com.qa.pages.DealPage;
import com.qa.pages.HomePage;
import com.qa.pages.LandingPage;
import com.qa.pages.LoginPage;
import com.qa.utilities.TimeUtils;

import junit.framework.Assert;

public class HomePageTest extends Base {
	
	Base base;
	LandingPage lanp;
	LoginPage lp;
	HomePage hp;
	ContactPage cp;
	DealPage dp;
	
	public HomePageTest()
	{
		super();

	}
	
	@BeforeMethod
	public void setUp()
	{
		initializeBrowser();
		lanp = new LandingPage();
		lp = new LoginPage();
		lp = lanp.clickOnLoginBtn();
		hp = lp.enterLoginCredentials(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateHomePage()
	{
		String actualTiltle_PAGE = hp.getTitleofPage();
		Assert.assertEquals(TimeUtils.expectedTitile_PAGE, actualTiltle_PAGE);
	}
	
	@Test(priority=2)
	public void validateUser()
	{
		Assert.assertTrue(hp.validateUser());
	}
	
	@Test(priority=3)
	public void validateHomePageFully()
	{
		hp.validateHomePage();
	}
	
	@Test(priority=4)
	public void contactPage()
	{
		cp = hp.clickOnContacts();
	}
	
	@Test(priority=5)
	public void dealPage()
	{
		dp= hp.clickOnDeals();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
