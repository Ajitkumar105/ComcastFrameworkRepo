package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		
	
		
		PageFactory.initElements(driver, this);
		

}
	@FindBy(linkText="Organizations")
	private WebElement orglink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactslink;
	
	@FindBy(linkText="Campaigns")
	private WebElement compaingnlink;
	
	@FindBy(linkText="More")
	private WebElement morelink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutlink;

	


	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactslink() {
		return contactslink;
	}
	public WebElement getCompaingnlink() {
		
		
		return compaingnlink;
	}
	
	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMorelink() {
		return morelink;
	}
	
	public void navigatecompaginPage()
	{
		Actions act=new Actions(driver);
		 act.moveToElement(morelink).perform();
		 compaingnlink.click();
		 
	
	}
	public void Logout()
	{
		Actions act =new Actions(driver);
		act.moveToElement(adminImg).perform();
		signOutlink.click();
	}

	

	}

