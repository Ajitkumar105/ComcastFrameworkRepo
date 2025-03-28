package com.comcast.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class CreateOraganizationWithIndustriesTest {
	public static void main(String[] args) throws IOException, InterruptedException {

		// Ctreate object of utility class

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

		// 3.read the data from excel

		String orgName = elib.getDataFromExcel("org", 3, 2) + jlib.getRandomNumber();
		String industryDrp = elib.getDataFromExcel("org", 3, 3);
		String TypeDrp = elib.getDataFromExcel("org", 3, 4);

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

		// 2.navigate to organization module

		HomePage homePage = new HomePage(driver);
		homePage.getOrglink().click();

		// 3.click on create organization button
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		organizationsPage.getCreateNewOrgButton().click();

		// 4.Enter all the details &create new Organization
		CreateNewOrganizationPage createNewOrganizationPage = new CreateNewOrganizationPage(driver);
		createNewOrganizationPage.createOrgWithIndustry(orgName, industryDrp, TypeDrp);

		// .1.Verify industrydDrp

		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
		String act_industryDrp = organizationInfoPage.getIdustrtydropdown().getText();
		String act_typeDrp = organizationInfoPage.getTypedropdown().getText();
		// System.out.println( act_typeDrp);
		// System.out.println( TypeDrp);

		if (act_industryDrp.equals(industryDrp)) {
			System.out.println(industryDrp + "information is verified =pass");
		} else {
			System.out.println(industryDrp + "information is not verified=fail");
		}
		// 2.verify typeDrp dropdown
		Thread.sleep(3000);
		if (act_typeDrp.equals(TypeDrp)) {
			System.out.println(TypeDrp + "information is verified =pass");
		} else {
			System.out.println(TypeDrp + "information is verified=fail");
		}

		// logout
		homePage.Logout();
	}

}
