	package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import free.crm.qa.base.TestBase;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	
	public HomePageTest()  //Creating HomePageTest Constructor
	{
		super();  //To call superClass "TestBase", Constructor
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		 loginpage = new LoginPage();
		 homepage = loginpage.Login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void validateHomePageTitleTest() throws InterruptedException
	{
		String homepagetitle = homepage.validateHomePageTitle();
		Assert.assertEquals(homepagetitle, "Cogmento CRM", "HomePage Title is not matching stupid");
		Thread.sleep(3000);
	}
	
	@Test(priority =2)
	public void validateUserNameLabelTest()
	{
		homepage.validateUserNameLabel();
		Assert.assertTrue(homepage.validateUserNameLabel(), "Incorrect Label name stupid");
	}
	
	@Test(priority =3)
	public void clickOnContactsLinkTest() throws InterruptedException
	{
	    contactspage = homepage.clickOnContactsLink();
		Thread.sleep(3000);
	}
	
	@Test(priority = 4)
	public void clickOnDealsLinkTest() throws InterruptedException
	{
		dealspage =homepage.clickOnDealsLink();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
