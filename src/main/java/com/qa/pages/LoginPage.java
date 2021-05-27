package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class LoginPage extends Base{
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//*[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[text()='Forgot your password?']")
	WebElement forgetPwd;
	
	@FindBy(xpath="//*[text()='Sign Up']")
	WebElement signUpLink;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getTitleofLoginPage()
	{
		return driver.getTitle();
	}
	
	public HomePage enterLoginCredentials(String userName, String pwd)
	{
		email.sendKeys(userName);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	

	
	public void forgetPasswordLink()
	{
		forgetPwd.click();
	}
	
	public SignUpPage signUpLink()
	{
		signUpLink.click();
		return new SignUpPage();
	}
	
	

}
