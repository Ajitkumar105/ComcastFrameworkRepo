package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgLookUpPage {

	
WebDriver driver;
	


	public OrgLookUpPage(WebDriver driver) {
			
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchTF;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement SearchBtn;



	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	
	
	
}
