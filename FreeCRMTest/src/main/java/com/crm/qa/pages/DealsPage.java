package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import free.crm.qa.base.TestBase;

public class DealsPage extends TestBase {
	
	@FindBy(xpath = "//div[(@class = 'ui header item mb5 light-black')]")
	WebElement DealsLogo;
	
	@FindBy(xpath = "//button[contains(text(), 'New')]")
	WebElement NewButton;
	
	@FindBy(name = "title")
	WebElement Title;
	
	@FindBy(xpath = "//div[@Class = 'ui fluid selection dropdown']")
	WebElement AssignedTo;
	
	@FindBy(xpath = "//button[@class = 'ui linkedin button']")
	WebElement Save;
	
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean ValidateDealsPageLogo()
	{
		return DealsLogo.isDisplayed();
		
	}
	
	public void AddNewDeals() throws InterruptedException
	{
		
		NewButton.click();
		Title.sendKeys("ftyfuiuuuifiuufu");
		AssignedTo.click();
		Save.click();
		Thread.sleep(3000);
	}
	
	

}
