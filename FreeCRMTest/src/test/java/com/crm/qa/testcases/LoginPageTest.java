package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import free.crm.qa.base.TestBase;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();  //We have to call the "super" class because we want to call the properties from "TestBase" Constructor from SuperClass or "TestBase.java"
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initialization();  //We have to call the "initialization" method from "TestBase.java", to get all the @before method properties from initialization method
		 loginpage = new LoginPage();  //Creating LoginPage() Class Method from "LoginPage.java"
		 //The reason we have created the loginpage method is to call every Method/functions from "LoginPage.java"
	} 
	
	@Test(priority =1)
	public void ValidateLoginPageTitleTest()
	{
		String title = loginpage.validateLoginPageTitle();  //We are calling "validateLoginPageTitle" method from "LoginPage.java"
		Assert.assertEquals(title, "Cogmento CRM");
		
	}
	
	
	
	@Test (priority =2)
	public void LoginTest()
	{
		homepage = loginpage.Login(prop.getProperty("email"), prop.getProperty("password"));  //The reason we are able to use "prop.getProperty(), because the prop is available in "TestBase.java" which we are inherting
		//The reason we are giving O/P as "homepage" bcz we have used "return  new HomePage()" as O/P for "Login()" method. Hence we are returning the Object Property of HomePage() Class
	}
	
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}

}
