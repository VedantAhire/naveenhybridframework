package com.crmpro.framework.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmpro.framework.automation.base.TestBase;
import com.crmpro.framework.automation.utils.TestUtil;
import com.crmpro.framewrok.automation.pages.ContactPage;
import com.crmpro.framewrok.automation.pages.HomePage;
import com.crmpro.framewrok.automation.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactPage;
	
	public HomePageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		startApplication();
		testUtil = new TestUtil();
		loginPage= new LoginPage();
		homePage= loginPage.login(pro.getProperty("username"), pro.getProperty("password"));
		contactPage = new ContactPage();
	}

	@Test(priority=1)
	public void verifyhomePageTitleTest() {
		String homePageTitle =homePage.verifyHomePageTitle();
		System.out.println(homePageTitle);
	    Assert.assertEquals(homePageTitle, "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyUsernameLabelTest()
	{
		testUtil.switchToFrame();
		boolean label =homePage.verifyUsernameLabel();
		System.out.println("Result of label test:"+label);
		Assert.assertTrue(label);
	}
	
	@Test(priority=3)
	public void clickOnContactLinkTest()
	{
		testUtil.switchToFrame();
		homePage.clickOnContactPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
