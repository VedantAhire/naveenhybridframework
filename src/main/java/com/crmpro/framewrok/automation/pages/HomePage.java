package com.crmpro.framewrok.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmpro.framework.automation.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'CRMPRO')]")WebElement Logo;
	
	@FindBy(xpath="//td[contains(text(),'User: Mayuri Deshmukh')]")WebElement usernameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'New Deal')]")WebElement newDealLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyLogo()
	{
		return Logo.isDisplayed();
	}
	
	public boolean verifyUsernameLabel()
	{
		return usernameLabel.isDisplayed();
	}
			
	public ContactPage clickOnContactPage()
	{
		contactsLink.click();
		
		return new ContactPage();
	}
	public DealsPage clickOnDealsPage()
	{
		dealsLink.click();
		
		return new DealsPage();
	}
	public TasksPage clickOnTasksPage()
	{
		tasksLink.click();
		
		return new TasksPage();
	}
	public void clickOnNewContact()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
	public void clickOnNewDeal()
	{
		Actions action = new Actions(driver);
		action.moveToElement(dealsLink).build().perform();
		newDealLink.click();
	}
}
