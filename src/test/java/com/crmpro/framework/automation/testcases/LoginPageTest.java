package com.crmpro.framework.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmpro.framework.automation.base.TestBase;
import com.crmpro.framewrok.automation.pages.HomePage;
import com.crmpro.framewrok.automation.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		startApplication();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void verifyTitleOfPageTest()
	{
		String title = loginPage.verifyPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void validateLogoTest()
	{
		boolean Logo = loginPage.validateLogo();
		Assert.assertTrue(Logo);
		System.out.println("Result of Logo Test:"+Logo);
	}
	
	@Test(priority=3)
	public void loginPageTest()
	{
		homePage =loginPage.login(pro.getProperty("username"), pro.getProperty("password"));
	}
	
	@AfterMethod
    public void tearDown()
    {
    	driver.quit();
    }
}
