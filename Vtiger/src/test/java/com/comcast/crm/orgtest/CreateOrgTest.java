package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;
import java.util.Base64;

import org.apache.poi.hpsf.HPSFException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;

public class CreateOrgTest {
	public static void main(String[] args) throws IOException { 
		
		//create the object
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		
        //1read the data from properties file
        

        String BROWSER = flib.getDataFromPropertiesFile("browser"); 
        String URL = flib.getDataFromPropertiesFile("url");
        String USERNAME = flib.getDataFromPropertiesFile("username");
        String PASSWORD = flib.getDataFromPropertiesFile("password");

        System.out.println(BROWSER);
        //2.Generate the random Number

       
        //3.read the data from excel
        //reading the data from utility
       String orgName =elib.getDataFromExcel("org", 1, 2)+jlib.getRandomNumber();

     

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

        //1.Login to app
        wlib.waitForPageLoad(driver);
        
        // driver.get(URL);
         // Object of Loginpage
         
         LoginPage lp=new LoginPage(driver);
       
                 lp.LoginToApp(URL,USERNAME, PASSWORD);        
        //step : 2 navigate to organization module
                 HomePage homePage=new  HomePage(driver);
                 homePage.getOrglink().click();
     

        //Step  :3 click on create organization button
                 
                 OrganizationsPage organizationsPage=new OrganizationsPage(driver);
                		 
                 organizationsPage.getCreateNewOrgButton().click();



        //step : 4 Enter all the details &create new Organization
          CreateNewOrganizationPage createNewOrganizationPage=new CreateNewOrganizationPage(driver);
          createNewOrganizationPage.createOrgWithOrgName(orgName);
        
          
      

   


       //1.Verify the header message Expected result
      OrganizationInfoPage organizationInfoPage=new OrganizationInfoPage(driver);
        		String actOrgName=organizationInfoPage.getHeadermsg().getText();
        		 if (actOrgName.contains(orgName)) {
        	            System.out.println(orgName + "is verified==pass");
        	        } else {
        	            System.out.println(orgName + "is not verified==fail");
        	        }
        		 
        		 //5.Logout
        		 
        		
        		 homePage.Logout();
             //driver.quit();
    }

}
