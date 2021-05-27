package com.qa.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.LandingPage;
import com.qa.pages.LoginPage;
import com.qa.utilities.TimeUtils;

import junit.framework.Assert;

public class LandingPageTest extends Base{
	

	LandingPage page ;
	LoginPage lp;
	
	public LandingPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initializeBrowser();
		page = new LandingPage();
	}
	
	@Test(priority=1)
	public void validateTitle()
	{
		String actual  = page.pageTitleValidation();
		
		Assert.assertEquals(TimeUtils.expectedTitle_LANDING_PAGE, actual);
	}
	
	@Test(priority=2)
	public void clickOnLoginBtn()
	{
		lp = page.clickOnLoginBtn();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
