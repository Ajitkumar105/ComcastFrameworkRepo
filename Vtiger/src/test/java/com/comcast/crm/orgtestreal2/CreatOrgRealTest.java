package com.comcast.crm.orgtestreal2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import com.comcast.crm.objectrepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;
@Listeners(com.comcast.crm.listenerutility.ListenerImplementationClass.class)
public class CreatOrgRealTest extends BaseClassReal {
	@Test(groups="smokeTest")
	public void CreateOrgTest() throws IOException {

		// reading the data from utility
		
		UtilityClassObject.getTest().log(Status.INFO,"reading the data from utility");
		String orgName = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();

		// step : 2 navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO,"navigate to organization module");
		
		HomePage homePage = new HomePage(driver);
		homePage.getOrglink().click();

		// Step :3 click on create organization button
		
		UtilityClassObject.getTest().log(Status.INFO,"click on create organization button");

		OrganizationsPage organizationsPage = new OrganizationsPage(driver);

		organizationsPage.getCreateNewOrgButton().click();

		// step : 4 Enter all the details &create new Organization
		UtilityClassObject.getTest().log(Status.INFO," Enter all the details &create new Organization");
		CreateNewOrganizationPage createNewOrganizationPage = new CreateNewOrganizationPage(driver);
		createNewOrganizationPage.createOrgWithOrgName(orgName);

		// 1.Verify the header message Expected result
		OrganizationInfoPage organizationInfoPage = new OrganizationInfoPage(driver);
		String actOrgName = organizationInfoPage.getHeadermsg().getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + "is verified==pass");
		} else {
			System.out.println(orgName + "is not verified==fail");
		}

	}
	
	@Test(groups="regressionTest")
	public void CreateOrgWithPhoneNumber() throws InterruptedException, IOException {

		

		// Utili
		UtilityClassObject.getTest().log(Status.INFO,"read the data from excel");
		String orgName = elib.getDataFromExcel("org", 5, 2) + jlib.getRandomNumber();
		String phoneNumber = elib.getDataFromExcel("org", 5, 3);

		
		// 2.navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO,"navigate to organization module");
		HomePage homePage = new HomePage(driver);
		homePage.getOrglink().click();

		// 3.click on create organization button
		
		UtilityClassObject.getTest().log(Status.INFO,"click on create organization button");

		OrganizationsPage organizationsPage = new OrganizationsPage(driver);

		organizationsPage.getCreateNewOrgButton().click();

		// 4.Enter all the details &create new Organization
		
		UtilityClassObject.getTest().log(Status.INFO,"Enter all the details &create new Organization");

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
		
		
	}
	
	@Test(groups="regressionTest")
	public void CreateOraganizationWithIndustriesTest ()throws IOException, InterruptedException {

		

		// 3.read the data from excel

		String orgName = elib.getDataFromExcel("org", 3, 2) + jlib.getRandomNumber();
		String industryDrp = elib.getDataFromExcel("org", 3, 3);
		String TypeDrp = elib.getDataFromExcel("org", 3, 4);

		
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

		OrganizationInfoPage organizationInfoPage=new OrganizationInfoPage(driver);
		String act_industryDrp=organizationInfoPage.getIdustrtydropdown().getText();
		String act_typeDrp=organizationInfoPage.getTypedropdown().getText();
	//System.out.println( act_typeDrp);
	//System.out.println( TypeDrp);
		
		
		if (act_industryDrp.equals(industryDrp)) {
			System.out.println(industryDrp+ "information is verified =pass");
		} else {
			System.out.println(industryDrp + "information is not verified=fail");
		}
		// 2.verify typeDrp dropdown
            Thread.sleep(3000);
		if (act_typeDrp.equals(TypeDrp)) {
			System.out.println(TypeDrp + "information is verified =pass");
		} else {
			UtilityClassObject.getTest().log(Status.FAIL,TypeDrp + "is not verified==fail");
		}



}
}
