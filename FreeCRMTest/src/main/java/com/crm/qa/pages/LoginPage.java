package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import free.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Object Repository or Page Factory
	
	@FindBy(xpath = "//input[contains(@name, 'email')]")  //name = "email" is the Object Property
	WebElement email;
	
	@FindBy(name = "password")  //name = "password" is the Object Property
	WebElement password;
	
	@FindBy(xpath = "//div[@class = 'ui fluid large blue submit button']")
	WebElement LoginButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
	WebElement SignUpButton;
	
	//@FindBy(xpath = "//span[@class = 'icon icon-xs mdi-chart-bar']")
	//WebElement LOGINButton;
	
//Initialize the Page Factory or Object Repository	
	public LoginPage()     //LoginPage Constructor is created
	{
		PageFactory.initElements(driver, this);  //Initialize Page Factory or Object Repository
	} //"This" means pointing to the current Class Object.
	
//Different Methods or Actions
	
	
	//Method1 or Action1
	public String validateLoginPageTitle() {
		 return driver.getTitle();
	}
	

	//Method2 or Action2
	public HomePage Login(String em, String pwd)
	{
		//LOGINButton.click();
		email.sendKeys(em);
		password.sendKeys(pwd);
		LoginButton.click();
		
		//HomePage() homepage = new HomePage();
		return  new HomePage();  //After clicking on "click" button we will navigate to HomePage() - as per the diagram. We need to add "new" before 
		//HomePage() because we already have a HomePage()
		}
	
	public SignUpPage SignUp()
	{
		SignUpButton.click();
		
		return new SignUpPage();
	}
}
