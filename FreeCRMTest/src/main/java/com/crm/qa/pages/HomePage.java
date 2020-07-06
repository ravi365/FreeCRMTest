package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import free.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Creating Page Factory or OR
	
	@FindBy(xpath = "//span[contains(text(), 'Ravi Rulez')]")
	WebElement UserNameLabel;
	
	@FindBy(xpath = "//span[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//span[contains(text(), 'Deals')]")
	WebElement dealsLink;
	 
	public HomePage(){   //Creating "HomePage" class Constructor
		PageFactory.initElements(driver, this);    //Initialize the PageFactory/OR Elements/Page Objects
	}
	
	//Creating Methods or Actions
	//Method1/Action1
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	//Method2/Action2
	public boolean validateUserNameLabel()
	{
		return UserNameLabel.isDisplayed();
	}
	
	
	//Method3/Action3
	public ContactsPage clickOnContactsLink() // "clickOnContactsLink()" method is returning "ContactsPage" Object 
	{
		contactsLink.click();
		return new ContactsPage();  //Return Contacts Page Objects
	}
	//NOTE: IF WE ARE USING ANY METHOD, AND USING "CLICK" AND IF IT IS GOING TO ANOTHER PAGE, THEN WE SHOULD CREATE THAT METHOD OBJECT
	
	//Method4/Action4
	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();    //Return Deals Page Objects
	}
	

}
