package com.comcast.crm.orgtest;

import java.io.IOException;

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

public class CreateOrgWithPhonenumber {

	public static void main(String[] args) throws InterruptedException, IOException {

		// create the object of file utility

		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");

		// System.out.println(BROWSER);
		// 2.Generate the random Number

		// 3.read the data from excel
		String orgName = elib.getDataFromExcel("org", 5, 2) + jlib.getRandomNumber();
		String phoneNumber = elib.getDataFromExcel("org", 5, 3);

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

		//driver.get(URL);
		// 1.Object of Loginpage

		LoginPage lp = new LoginPage(driver);

		lp.LoginToApp(URL,USERNAME, PASSWORD);

		// 2.navigate to organization module
		HomePage homePage = new HomePage(driver);
		homePage.getOrglink().click();

		// 3.click on create organization button

		OrganizationsPage organizationsPage = new OrganizationsPage(driver);

		organizationsPage.getCreateNewOrgButton().click();

		// 4.Enter all the details &create new Organization

		CreateNewOrganizationPage createNewOrganizationPage = new CreateNewOrganizationPage(driver);

		createNewOrganizationPage.createOrgWithPhone(orgName, phoneNumber);

		Thread.sleep(2000);
		// 1.Verify the header message Expected result

		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
		String actOrgName = organizationInfoPage.getHeadermsg().getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + "is verified==pass");
		} else {
			System.out.println(orgName + "is not verified==fail");
		}

		// 2.verify the header orgName info expected result
		Thread.sleep(3000);

		String act_Phone = organizationInfoPage.getPhoneNumber().getText();

		if (act_Phone.trim().contains(phoneNumber)) {
			System.out.println(phoneNumber + "is verified==pass");
		} else {
			System.out.println(phoneNumber + "is not verified==fail");
		}
		
		//logout
		 homePage.Logout();
	}
}
