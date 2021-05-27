package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.Base;

public class ContactPage extends Base {
	
	@FindBy(xpath="(//*[text()='Contacts'])[2]")
	WebElement contactpageValidate;
	
	@FindBy(xpath="//*[text()='Show Filters']")
	WebElement hideFilters;
	
	@FindBy(xpath="//*[text()='Export']")
	WebElement export;
	
	@FindBy(xpath="(//button[@class='ui linkedin button'])[3]")
	WebElement create;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lasName;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	@FindBy(xpath="//textarea[@name='description']")
	WebElement description;
	
	

	
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitePage()
	{
		return driver.getTitle();
	}
	
	public void validateContactPage()
	{
		contactpageValidate.isDisplayed();
		hideFilters.isDisplayed();
		export.isDisplayed();
		create.isDisplayed();
		System.out.println("----------All elements are displayed-----");
		
	}
//	public void clickOnAnyExistingContact(String name)
//	{
//		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td")).click();
//	}
	
	public void clickOnCreateContact(String fName, String lastName, String des) 
	{
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		create.click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		firstName.sendKeys(fName);
		lasName.sendKeys(lastName);
		description.sendKeys(des);
		
		
		saveBtn.click();
		
		


	}
	
	

}
