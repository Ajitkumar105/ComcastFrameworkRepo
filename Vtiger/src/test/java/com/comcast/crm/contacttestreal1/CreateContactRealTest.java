package com.comcast.crm.contacttestreal1;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClassReal;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.listenerutility.ListenerImplementationClass;
import com.comcast.crm.objectrepositoryUtility.ContactPage;
import com.comcast.crm.objectrepositoryUtility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;
import com.comcast.crm.objectrepositoryUtility.OrgLookUpPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;

@Listeners(com.comcast.crm.listenerutility.ListenerImplementationClass.class)
public class CreateContactRealTest extends BaseClassReal {
	@Test(groups = "smokeTest")
	public void CreateContactTest() throws IOException {

		// .read the data from excel
		UtilityClassObject.getTest().log(Status.INFO,"read the data from excel");
		String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

		// 2.navigate to contact module
       
		UtilityClassObject.getTest().log(Status.INFO,"navigate to contact module");
		
		HomePage homePage = new HomePage(driver);
		homePage.getContactslink().click();

		// 3.click on create organization button

		UtilityClassObject.getTest().log(Status.INFO,"click on create organization button");
		
		ContactPage cp = new ContactPage(driver);

		cp.getCreateNewContactsOrgButton().click();
		// 4.Enter all the details &create new Organization
		
		UtilityClassObject.getTest().log(Status.INFO,"Enter all the details &create new Organization");

		CreateNewOrganizationPage createNewOrganizationPage = new CreateNewOrganizationPage(driver);
		createNewOrganizationPage.createContactOrgWithLastName(lastName);

		// .verify the header lastname info expected result
		UtilityClassObject.getTest().log(Status.INFO,"verify the header lastname info expected result");
		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
		String act_lastName = organizationInfoPage.getLastName().getText();
		
      Assert.assertEquals(true, act_lastName.equals(lastName));
		/*if (act_lastName.equals(lastName)) {
			UtilityClassObject.getTest().log(Status.PASS,lastName + "is verified==pass");
		} else {
			UtilityClassObject.getTest().log(Status.FAIL,lastName + "is not verifird==fail");
		}*/

	}

	@Test(groups = "regressionTest")
	public void CreateContactWithSupportDate() throws IOException {

		// System.out.println(BROWSER);
		// 2.Generate the random Number

		// 3.read the data from excel"
  
		String lastName = elib.getDataFromExcel("contact", 3, 2) + jlib.getRandomNumber();

		// 2.navigate to contact module

		HomePage homePage = new HomePage(driver);
		homePage.getContactslink().click();

		// 3.click on create organization button

		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactsOrgButton().click();

		// 4.Enter all the details &create new Organization

		String startDate = jlib.getSystemDataYYYYDDMM();
		String endDate = jlib.getRequiredDateYYYYDDMM(30);

		CreateNewOrganizationPage createNewOrganizationPage = new CreateNewOrganizationPage(driver);
		createNewOrganizationPage.createContactWithSupporteDate(lastName, startDate, endDate);

		// 1.Verify the start Date

		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
		String act_StartDate = organizationInfoPage.getSupportStartDate().getText();
		Assert.assertEquals(true,act_StartDate.equals(startDate));
		
		/*if (act_StartDate.equals(startDate)) {
			ListenerImplementationClass.test.log(Status.PASS,startDate + "is verified==pass");
		} else {
			UtilityClassObject.getTest().log(Status.FAIL,startDate + "is not verified==fail");
		}*/
		// 2.Verify the end date

		String act_EndDate = organizationInfoPage.getSupportEndDate().getText();
		
		Assert.assertEquals(true,act_EndDate.contains(endDate));

		/*if (act_EndDate.equals(endDate)) {
			ListenerImplementationClass.test.log(Status.PASS,endDate + "is verified==pass");
		} else {
			UtilityClassObject.getTest().log(Status.FAIL,endDate + "is not verified==fail");
		}*/

	}

	@Test(groups = "regressionTest")
	public void CreateContactWithOrg() throws EncryptedDocumentException, IOException {
		// 1read the data from properties file

		// creating the object of uitility

		// 2.Generate the random Number

		// 3.read the data from excel

		String orgName = elib.getDataFromExcel("contact", 5, 2) + jlib.getRandomNumber();

		String contactLastName = elib.getDataFromExcel("contact", 5, 3);

		// ---------------------------------------------------------------

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
		//OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
		//String headerinfo=organizationInfoPage.getHeadermsg().getText();
		
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(headerInfo);
		Assert.assertEquals(true,headerInfo.contains(orgName));
		/*if (headerInfo.contains(orgName)) {
			UtilityClassObject.getTest().log(Status.PASS,orgName + "is created==pass");
		} else {
			UtilityClassObject.getTest().log(Status.FAIL,orgName + "is not created==fail");
		}*/

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

				break;
			}
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

		// 1.verify header contactLastName
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertEquals(true,headerinfo.contains(contactLastName) );
	/*	if (headerinfo.contains(contactLastName)) {
			UtilityClassObject.getTest().log(Status.PASS,contactLastName + "is verified==pass");
		} else {
			UtilityClassObject.getTest().log(Status.FAIL,contactLastName + "is not verifird==fail");

		}*/

		// in contact modiule page verify the orgname

		String actorgName = driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();
		System.out.println(actorgName);
		
		Assert.assertEquals(true,actorgName.contains(orgName) );
		/*if (actorgName.contains(orgName)) {
			UtilityClassObject.getTest().log(Status.PASS,orgName + "is verified==pass");
		} else {
			UtilityClassObject.getTest().log(Status.FAIL,orgName + "is not verified==fail");
		}*/

	}

}
