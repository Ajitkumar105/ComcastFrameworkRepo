package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

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

public class CreateContactwithSupportDate {
	public static void main(String[] args) throws IOException {

		// create the object of file utility

		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		// 1read the data from properties file

		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");

		// System.out.println(BROWSER);
		// 2.Generate the random Number

		// 3.read the data from excel"

		String lastName = elib.getDataFromExcel("contact", 3, 2) + jlib.getRandomNumber();

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

		// 1.Login to app
		wlib.waitForPageLoad(driver);

		// driver.get(URL);

		LoginPage lp = new LoginPage(driver);

		lp.LoginToApp(URL, USERNAME, PASSWORD);

		// 2.navigate to contact module

		HomePage homePage = new HomePage(driver);
		homePage.getContactslink().click();

		// 3.click on create organization button

		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		organizationsPage.getCreateNewOrgButton().click();

		// 4.Enter all the details &create new Organization

		String startDate = jlib.getSystemDataYYYYDDMM();
		String endDate = jlib.getRequiredDateYYYYDDMM(30);

		CreateNewOrganizationPage createNewOrganizationPage = new CreateNewOrganizationPage(driver);
		createNewOrganizationPage.createContactWithSupporteDate(lastName, startDate, endDate);

		// 1.Verify the start Date

		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
		String act_StartDate = organizationInfoPage.getSupportStartDate().getText();

		if (act_StartDate.equals(startDate)) {
			System.out.println(startDate + "is verified==pass");
		} else {
			System.out.println(startDate + "is not verified==fail");
		}
		// 2.Verify the end date

		String act_EndDate = organizationInfoPage.getSupportEndDate().getText();

		if (act_EndDate.equals(endDate)) {
			System.out.println(endDate + "is verified==pass");
		} else {
			System.out.println(endDate + "is not verified==fail");
		}
		// logout

		homePage.Logout();

	}

}
