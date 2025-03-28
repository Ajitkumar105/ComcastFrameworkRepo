package com.comcast.crm.objectrepositoryUtility;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
WebDriver driver;
	
	public OrganizationInfoPage(WebDriver driver) {
		
		this.driver=driver;
		
	
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headermsg;
	
	@FindBy(id="dtlview_Phone")
	private WebElement PhoneNumber;
	
	@FindBy(id="dtlview_Industry")
	private WebElement idustrtydropdown;
	
	@FindBy(id="dtlview_Type")
	private WebElement typedropdown;
	
	public WebElement getLastName() {
		return LastName;
	}

	@FindBy(id="dtlview_Last Name")
	private WebElement LastName;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement SupportStartDate;
	

	public WebElement getSupportStartDate() {
		return SupportStartDate;
	}


	public WebElement getSupportEndDate() {
		return SupportEndDate;
	}

	@FindBy(id="dtlview_Support End Date")
	private WebElement SupportEndDate;


public WebElement getIdustrtydropdown() {
		return idustrtydropdown;
	}


	public WebElement getTypedropdown() {
		return typedropdown;
	}


public WebDriver getDriver() {
		return driver;
	}


	public WebElement getPhoneNumber() {
		return PhoneNumber;
	}


public WebElement getHeadermsg() {
	return headermsg;
}



}
