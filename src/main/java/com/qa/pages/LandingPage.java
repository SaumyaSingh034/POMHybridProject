package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class LandingPage extends Base {
	
	
	
	/**
	 * 1 - Create Onject Repositories (Collection of Web Loactors/web elements)
	 */
	//Click on SignInBtn
	@FindBy(xpath="//a[contains(@class,'btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left')]")
	WebElement loginBtn;
	
	//SignUpBtn
	@FindBy(xpath="//*[text()=' sign up']")
	WebElement SignUpBtn;
	
	//About
	@FindBy(xpath="//*[text()='About']")
	WebElement about;
	
	//FreeCRM
	@FindBy(xpath="//li[@class='rd-navbar--has-dropdown rd-navbar-submenu']/a")
	WebElement freeCRM;
	
	//Compare
	@FindBy(xpath="//*[text()='Compare']")
	WebElement compare;
	
	public LandingPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String pageTitleValidation()
	{
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	
	public LoginPage clickOnLoginBtn()
	{
		loginBtn.click();
		return new LoginPage();
	}
	
}
