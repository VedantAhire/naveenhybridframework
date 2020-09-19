package com.crmpro.framework.automation.testcases;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crmpro.framework.automation.base.TestBase;
import com.crmpro.framework.automation.utils.TestUtil;
import com.crmpro.framewrok.automation.pages.ContactPage;
import com.crmpro.framewrok.automation.pages.HomePage;
import com.crmpro.framewrok.automation.pages.LoginPage;

public class ContactPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactPage;
	
	public ContactPageTest()
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
		testUtil.switchToFrame();
	}

	
	@Test(priority=2)
	public void verifyContactLabelTest() {
		Assert.assertTrue(contactPage.verifyContactlabel());
	}
//	
//	@Test(priority=2)
//	public void selectContactTest()
//	{
//		
//		homePage.clickOnContactPage();
//	    try {
//			contactPage.selectContact("Dick Henry");
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test(priority=3)
//	public void selectMultipleContactPageTest() 
//	{
//		homePage.clickOnContactPage();
//		try {
//			contactPage.selectContact("John Carlton");
//			contactPage.selectContact("John Peter");
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	
//	}
//	
//	@Test(priority=4)
//	public void createNewContactTest()
//	{
//		homePage.clickOnNewContact();
//		contactPage.createNewContact("Mr.", "Steve", "Jordan", "Google", "CEO", "Management", "Lead", "9988776688", "Ad");
//	}
//	
	
	@DataProvider
	public Object[][] getCRMData()
	{
		Object[][] data= TestUtil.getCRMData("contacts");
		return data;
	}
	
	@Test(priority=1,dataProvider="getCRMData")
	public void getCRMTestData(String title,String firstName, String lastName, String company, String position,
			String department, String category, String mobile, String source)
	{
		
		homePage.clickOnNewContact();
		contactPage.createNewContact(title, firstName, lastName, company, position, department, category, mobile, source);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
