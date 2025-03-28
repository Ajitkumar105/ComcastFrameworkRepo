package com.comcast.crm.contacttest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.ContactPage;
import com.comcast.crm.objectrepositoryUtility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;
import com.comcast.crm.objectrepositoryUtility.OrgLookUpPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws IOException {
		// 1read the data from properties file

		// creating the object of uitility
		
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		FileUtility flib = new FileUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");

		System.out.println(BROWSER);
		// 2.Generate the random Number

		// 3.read the data from excel

		String orgName = elib.getDataFromExcel("contact", 5, 2) + jlib.getRandomNumber();

		String contactLastName = elib.getDataFromExcel("contact", 5, 3);
		
		
		//---------------------------------------------------------------

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
		createNewOrganizationPage.createOrgWithOrgName(orgName);

		// 1.Verify the header message Expected result
		OrganizationInfoPage organizationInfoPage=new OrganizationInfoPage(driver);
		String actOrgName=organizationInfoPage.getHeadermsg().getText();
		//String act_OrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		//System.out.println(act_OrgName);
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + "is created==pass");
		} else {
			System.out.println(orgName + "is not created==fail");
		}

		// 5.navigate to contact oranization module
		
		
		homePage.getContactslink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactsOrgButton().click();
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.getLastNameEdt().sendKeys(contactLastName);
		cncp.getOrgLookImg().click();
		
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();

			driver.switchTo().window(windowID);

			String actURL = driver.getCurrentUrl();
			if (actURL.contains("module=Accounts")) {

				break;	}
		}
		
		
		OrgLookUpPage olp = new OrgLookUpPage(driver);
		olp.getSearchTF().sendKeys(orgName);
		olp.getSearchBtn().click();
		
		driver.findElement(By.xpath("//a[text()='" + orgName + "'] ")).click();
		
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();
		while (it1.hasNext()) {
			String windowID = it1.next();

			driver.switchTo().window(windowID);

			String actURL = driver.getCurrentUrl();
			if (actURL.contains("Contacts&action")) {

				break;

			}
		}
		
		cncp.getSaveBtn().click();

		
		// verify header contactLastName
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerinfo.contains(contactLastName)) {
			System.out.println(contactLastName + "is verified==pass");
		} else {
			System.out.println(contactLastName + "is not verifird==fail");

		}

		// in contact modiule page verify the orgname

		String actorgName = driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();
		System.out.println(actorgName);
		if (headerinfo.contains(orgName)) {
			System.out.println(orgName + "is verified==pass");
		} else {
			System.out.println(orgName + "is not verified==fail");
		}

		driver.quit();
		
	}

}
