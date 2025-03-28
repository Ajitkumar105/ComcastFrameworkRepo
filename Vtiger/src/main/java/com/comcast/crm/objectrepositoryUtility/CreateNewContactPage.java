package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	
	WebDriver driver;
	


	public CreateNewContactPage(WebDriver driver) {
			
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}

	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgLookImg;



	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgLookImg() {
		return orgLookImg;
	}
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;



	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
}
