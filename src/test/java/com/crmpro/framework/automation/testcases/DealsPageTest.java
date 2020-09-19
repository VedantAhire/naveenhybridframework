package com.crmpro.framework.automation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crmpro.framework.automation.base.TestBase;
import com.crmpro.framework.automation.utils.TestUtil;
import com.crmpro.framewrok.automation.pages.ContactPage;
import com.crmpro.framewrok.automation.pages.DealsPage;
import com.crmpro.framewrok.automation.pages.HomePage;
import com.crmpro.framewrok.automation.pages.LoginPage;

public class DealsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage dealsPage;
	
	public DealsPageTest()
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
		dealsPage = new DealsPage();
		testUtil.switchToFrame();
		
	}
	
	@DataProvider
	public Object[][] getCRMDealsDataTest()
	{
		Object[][] data = TestUtil.getCRMData("deals");
		return data;
	}
	
	
	
	@Test(priority=1)
	public void verifyDealTitleTest()
	{
		dealsPage.verifyDealTitle();
	}
	
	@Test(priority=2,dataProvider="getCRMDealsDataTest")
	public void createNewDealTest(String title, String company, String primecontact, String amount,
			String probability, String commission,String quantity, String source )
	{
		homePage.clickOnNewDeal();
	
		dealsPage.createNewDeal(title, company, primecontact, amount, probability, commission, quantity, source);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
