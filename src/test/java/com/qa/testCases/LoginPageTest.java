package com.qa.testCases;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.HomePage;
import com.qa.pages.LandingPage;
import com.qa.pages.LoginPage;
import com.qa.utilities.TimeUtils;

public class LoginPageTest extends Base {
	LandingPage landingPage;
	LoginPage lp;
	HomePage hp;
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest()
	{
		super();
		log.warn("********************Hey thisis just a warning******************");
	}
	
	@BeforeMethod
	public void setUp()
	{
		initializeBrowser();
		landingPage = new LandingPage();
		lp = landingPage.clickOnLoginBtn();
	}
	
	@Test
	public void validateTitle()
	{
		String actualTitle_LOGIN_PAGE = lp.getTitleofLoginPage();
		Assert.assertEquals(actualTitle_LOGIN_PAGE, TimeUtils.expectedTitile_PAGE);
		System.out.println("A");
		
	}
	
	@Test(priority=1)
	public void forgetLink()
	{
		lp.forgetPasswordLink();
		System.out.println("B");
	}
	
	@Test(priority=2)
	public void enterCredentials()
	{
		hp = lp.enterLoginCredentials(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("C");
	}
	@Test(priority=-1)
	public void demo()
	{
		System.out.println("D");
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
