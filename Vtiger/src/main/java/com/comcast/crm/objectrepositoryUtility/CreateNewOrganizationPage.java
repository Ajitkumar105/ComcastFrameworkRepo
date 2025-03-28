package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewOrganizationPage {

	WebDriverUtility wlib = new WebDriverUtility();
	WebDriver driver;

	public CreateNewOrganizationPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "accountname")
	private WebElement orgNameEdt;

	@FindBy(id = "phone")
	private WebElement phoneEdt;

	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

	@FindBy(xpath = "//select[@name='industry']")

	private WebElement industryDP;

	@FindBy(xpath = "//select[@name='accounttype']")

	private WebElement accounttypeDP;

	@FindBy(name = "support_start_date")
	private WebElement supportStartDateEdt;

	public WebDriverUtility getWlib() {
		return wlib;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSupportStartDateEdt() {
		return supportStartDateEdt;
	}

	public WebElement getSupportEndDateEdt() {
		return supportEndDateEdt;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	@FindBy(name = "support_end_date")
	private WebElement supportEndDateEdt;

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;

	public WebElement getIndustryDP() {
		return industryDP;
	}

	public WebElement getAccounttypeDP() {
		return accounttypeDP;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void createOrgWithOrgName(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveButton.click();
	}

	public void createOrgWithIndustry(String orgName, String industry, String tpye) {
		orgNameEdt.sendKeys(orgName);
		wlib.selectBytext(industryDP, industry);
		wlib.selectByValue(accounttypeDP, tpye);
		saveButton.click();
	}

	public void createOrgWithPhone(String orgName, String phoneNumber) {
		orgNameEdt.sendKeys(orgName);
		phoneEdt.sendKeys(phoneNumber);
		saveButton.click();
	}

	public void createContactOrgWithLastName(String lastName) {
		lastNameEdt.sendKeys(lastName);
		saveButton.click();
	}

	public void createContactWithSupporteDate(String lastName, String StartDate, String EndDate) {
		lastNameEdt.sendKeys(lastName);
		supportStartDateEdt.clear();
		supportStartDateEdt.sendKeys(StartDate);

		supportEndDateEdt.clear();
		supportEndDateEdt.sendKeys(EndDate);
		saveButton.click();
	}

}