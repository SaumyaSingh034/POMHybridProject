package com.qa.testCases;

import org.apache.log4j.Logger;
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
	
	Logger log = Logger.getLogger(LandingPageTest.class);
	
	public LandingPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		log.info("****************************** Starting test cases execution  *****************************************");
		log.info("launching chrome broswer");
		initializeBrowser();
		page = new LandingPage();
	}
	
	@Test(priority=1)
	public void validateTitle()
	{
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** ValidatingfreeCrmTitleTest *****************************************");
		String actual  = page.pageTitleValidation();
		
		Assert.assertEquals(TimeUtils.expectedTitle_LANDING_PAGE, actual);
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
	}
	
	@Test(priority=2)
	public void clickOnLoginBtn()
	{
		log.info("****************************** starting second test case *****************************************");
		log.info("****************************** VClicking on Login Button *****************************************");
		lp = page.clickOnLoginBtn();
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		log.info("****************************** Browser is closed *****************************************");
	}

}
