package com.crmpro.framewrok.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crmpro.framework.automation.base.TestBase;

public class DealsPage extends TestBase{

   @FindBy(xpath="//a[contains(text(),'Deals')]")WebElement dealsLabel;
	
	@FindBy(xpath="//input[@name='title']")WebElement tiT;
	
	@FindBy(xpath = "//input[@name='client_lookup']")WebElement comp;
	
	@FindBy(xpath= "//input[@name='contact_lookup']")WebElement primConct;
	
	@FindBy(xpath= "//input[@name='amount']")WebElement amt;
	
	@FindBy(xpath= "//input[@name='probability']")WebElement prob;
	
	@FindBy(xpath="//input[@name='commission']")WebElement commisn;
	
	@FindBy(xpath="//input[@name='quantity']")WebElement Qty;
	
	@FindBy(xpath="//select[@name='source']")WebElement src;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")WebElement saveBtn;
	
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDealTitle()
	{ 
		
		return dealsLabel.isDisplayed();
	}
	
	public void createNewDeal(String title, String company, String primecontact, String amount,
			String probability, String commission,String quantity, String source )
	{
		tiT.sendKeys(title);
		comp.sendKeys(company);
		primConct.sendKeys(primecontact);
		amt.sendKeys(amount);
		prob.sendKeys(probability);
		commisn.sendKeys(commission);
		Qty.sendKeys(quantity);
		Select select = new Select(src);
		select.selectByVisibleText(source);
		
		saveBtn.click();
	}
	
	
	
}
