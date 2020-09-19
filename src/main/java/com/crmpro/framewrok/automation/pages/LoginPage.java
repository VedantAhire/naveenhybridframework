package com.crmpro.framewrok.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmpro.framework.automation.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(name = "username") WebElement user;
	
	@FindBy(name= "password") WebElement pass;
	
	@FindBy(xpath= "//input[@value='Login']")WebElement loginBtn;
	
	@FindBy(xpath= "//div[@id='navbar-collapse']//ul//li[2]")WebElement signUp;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")WebElement logo;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle()
	{
		return driver.getTitle();
		
	}
	
	public boolean validateLogo()
	{
	   return	logo.isDisplayed();
		
	}
	
	public HomePage login(String un, String up)
	{
		user.sendKeys(un);
		pass.sendKeys(up);
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", loginBtn);
		
		return new HomePage();
	}
	
	
	
}
