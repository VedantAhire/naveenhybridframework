package com.crmpro.framewrok.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crmpro.framework.automation.base.TestBase;

public class ContactPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")WebElement contactLabel;
	
	@FindBy(name="title") WebElement tit;
	
	@FindBy(name="first_name")WebElement ftName;
	
	@FindBy(name="surname")WebElement ltName;
	
	@FindBy(name="client_lookup")WebElement comp;
	
	@FindBy(name="company_position")WebElement pos;
	
	@FindBy(name="department")WebElement dept;
	
	@FindBy(name="category")WebElement cateG;
	
	@FindBy(name="mobile")WebElement mobi;
	
	@FindBy(name="source")WebElement src;
	
	@FindBy(xpath="//*[@type='submit' and @value='Save']")WebElement saveBtn;
	
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactlabel()
	{
		return contactLabel.isDisplayed();
	}
	
	public void selectContact(String name) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title,String firstName, String lastName, String company,
			String position, String department, String category,String mobile, String source )
	{
		Select select = new Select(tit);
		select.selectByVisibleText(title);
		ftName.sendKeys(firstName);
		ltName.sendKeys(lastName);
		comp.sendKeys(company);
		pos.sendKeys(position);
		dept.sendKeys(department);
		Select select1= new Select(cateG);
		select1.selectByVisibleText(category);
		mobi.sendKeys(mobile);
		Select select2= new Select(src);
		select2.selectByVisibleText(source);
		saveBtn.click();
		
	}
	

}
