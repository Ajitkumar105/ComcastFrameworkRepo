package com.comcast.crm.contacttest;

import java.io.IOException;

import java.util.Random;

import org.apache.poi.hpsf.HPSFException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;

public class CreateContactTest {

	public static void main(String[] args) throws IOException {

		// create object of file utility
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		// 1read the data from properties file

		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");

		System.out.println(BROWSER);

		// 3.read the data from excel

		String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {

			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		// 1.Login to App
		wlib.waitForPageLoad(driver);

		driver.get(URL);

		LoginPage lp = new LoginPage(driver);

		lp.LoginToApp(URL, USERNAME, PASSWORD);

		// 2.navigate to contact module

		HomePage homePage = new HomePage(driver);
		homePage.getContactslink().click();

		// 3.click on create organization button

		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		organizationsPage.getCreateNewOrgButton().click();

		// 4.Enter all the details &create new Organization

		CreateNewOrganizationPage createNewOrganizationPage = new CreateNewOrganizationPage(driver);
		createNewOrganizationPage.createContactOrgWithLastName(lastName);

		// .verify the header lastname info expected result
		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
		String act_lastName = organizationInfoPage.getLastName().getText();

		if (act_lastName.equals(lastName)) {
			System.out.println(lastName + "is verified==pass");
		} else {
			System.out.println(lastName + "is not verifird==fail");
		}
		// logout
		homePage.Logout();

	}
}
