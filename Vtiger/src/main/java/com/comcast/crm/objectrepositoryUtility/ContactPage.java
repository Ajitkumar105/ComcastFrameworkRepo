package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	WebDriver driver;
	


public ContactPage(WebDriver driver) {
		
		this.driver=driver;
		
	
		
		PageFactory.initElements(driver, this);
		

}

	@FindBy(xpath = "//img[@alt='Create Contact...']")

	private WebElement createNewContactsOrgButton;
	
	
	public WebElement getCreateNewContactsOrgButton() {
		return createNewContactsOrgButton;
	}
}
