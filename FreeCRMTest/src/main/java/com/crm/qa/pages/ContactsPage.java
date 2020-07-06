package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import free.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	
	//PageFactory/OR
	@FindBy(xpath = "//button[contains(text(), 'New')]")
	WebElement newButton;
	
	@FindBy(name = "first_name")
	WebElement firstName;
	
	@FindBy(name = "last_name")
	WebElement lastName;
	
	@FindBy(xpath = "//button[contains(text(), 'Save')]")
	WebElement saveButton;
	
	@FindBy (xpath = "//div[@class  = 'ui header item mb5 light-black']")
	WebElement PageText;
	
	
	
	
	public ContactsPage()  //Creating Constructor
	{
		PageFactory.initElements(driver, this);
	}
	
	//Method1/Action1
	
	public Boolean ValidateContactsPageText()  
	{
		return PageText.isEnabled();
	}
	
	
	//Method2/Action2
	public void AddNewContacts(String fn, String ln) throws InterruptedException
	{
		
		newButton.click();
		
		Thread.sleep(3000);
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		Thread.sleep(2000);
		saveButton.click();
	}

}
