package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import free.crm.qa.base.TestBase;

public class ContactsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	String sheetName = "contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("email"), prop.getProperty("password"));
		contactspage = new ContactsPage();
		contactspage = homepage.clickOnContactsLink();
		//Thread.sleep(3000);
		
	}
	
	@Test(priority = 1)	
	public void ValidateContactsPageTextTest() throws InterruptedException
	{
		Thread.sleep(3000);
		Boolean pagetext = contactspage.ValidateContactsPageText();
		Assert.assertTrue(pagetext, "Contacts Word is displayed");
	}
	
	@DataProvider
    public Object[][] getTestData()
    {
		Object[][] testData = TestUtil.getTestData(sheetName);                    //I will have to create the Sheet name
        return testData;
    
    }
	
	@Test(priority = 2, dataProvider = "getTestData")
	public void AddNewContactsTest(String firstName, String lastName) throws InterruptedException
	{
		
		Thread.sleep(3000);
		contactspage.AddNewContacts(firstName, lastName);
		
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
}
