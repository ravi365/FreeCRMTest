package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;

import free.crm.qa.base.TestBase;

public class SignUpPageTest extends TestBase {
	
	SignUpPage signuppage;
	LoginPage loginpage;
	
	public SignUpPageTest()
	{
		super();
		
	}
	
	@BeforeMethod()
	public void SetUp()
	{
		initialization();
		loginpage = new LoginPage();
		signuppage = loginpage.SignUp();
	}
	
	@Test (priority =2)
	public void RegisterLogoTest()
	{
	signuppage.RegisterLogoMethod();
	Assert.assertTrue(signuppage.RegisterLogoMethod(), "Wrong");
	}
	
	@Test (priority = 1)
	public void EnterDetailsTest() {
	signuppage.SignUpPageDetails("abcd", "9897464616");
	}
	
	

	@AfterMethod
	public void TearDown()
	{
		driver.quit();
		
	}
}
