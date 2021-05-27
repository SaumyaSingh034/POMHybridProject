package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class HomePage extends Base {
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement userDisplay;
	
	@FindBy(xpath="//a[@href='/home']")
	WebElement home;
	
	@FindBy(xpath="//a[@href='/calendar']")
	WebElement calendar;
	
	@FindBy(xpath="//a[@href='/contacts']")
	WebElement contacts;
	
	@FindBy(xpath="//a[@href='/companies']")
	WebElement companies;
	
	@FindBy(xpath="//a[@href='/deals']")
	WebElement deals;
	
	@FindBy(xpath="//a[@href='/tasks']")
	WebElement tasks;
	
	@FindBy(xpath="//a[@href='/cases']")
	WebElement cases;
	
	@FindBy(xpath="//a[@href='/calls']")
	WebElement calls;
	
	@FindBy(xpath="//a[@href='/documents']")
	WebElement documents;
	
	@FindBy(xpath="//a[@href='/email']")
	WebElement email;
	
	@FindBy(xpath="//a[@href='/campaigns']")
	WebElement campaigns;
	
	@FindBy(xpath="//a[@href='/forms']")
	WebElement forms;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Actions--->
	 * @return 
	 */
	
	public String getTitleofPage()
	{
		return driver.getTitle();
	}
	
	public boolean validateUser()
	{
		return userDisplay.isDisplayed();
	}
	public void validateHomePage()
	{
		home.isDisplayed();
		calendar.isDisplayed();
		contacts.isDisplayed();

		companies.isDisplayed();

		deals.isDisplayed();

		tasks.isDisplayed();

		cases.isDisplayed();
		calls.isDisplayed();

		documents.isDisplayed();

		email.isDisplayed();
		campaigns.isDisplayed();

		forms.isDisplayed();
		System.out.println("All webelemnts are displayed");
	}
	
	public ContactPage clickOnContacts()
	{

		contacts.click();
		return new ContactPage();
	}
	
	public DealPage clickOnDeals()
	{
		deals.click();
		return new DealPage();
	}

}
