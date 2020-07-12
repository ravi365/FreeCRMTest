package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import free.crm.qa.base.TestBase;

public class SignUpPage extends TestBase{
	
	//Object Repository or Page Factory
	
			
	@FindBy(xpath = "//h2[contains(text(), Register)]")
	WebElement RegisterLogo;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "phone")
	WebElement phone;
	
	public SignUpPage(){
	PageFactory.initElements(driver, this);
	}
	
	//Methods
	
	
	public boolean RegisterLogoMethod()
	{
		return RegisterLogo.isDisplayed();
	}
	
	public void SignUpPageDetails(String em, String ph)
	{
		email.sendKeys(em);
		phone.sendKeys(ph);
		
	}

}
