package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import free.crm.qa.base.TestBase;

public class DealsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	DealsPage dealspage;
	
	
	
	public DealsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		LoginPage loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("email"), prop.getProperty("password"));
		dealspage = homepage.clickOnDealsLink();
	}
	
	@Test(priority = 1)
	public void ValidateDealsPageLogoTest()
	{
		dealspage.ValidateDealsPageLogo();
		Assert.assertTrue(true, "inCorrect Logo");
	}
	
	@Test(priority = 2)
	public void AddNewDealsTest() throws InterruptedException
	{
		dealspage.AddNewDeals();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
