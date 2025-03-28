package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v126.storage.model.AttributionReportingTriggerSpec;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;

public class BaseClassReal {

	// create object of file utility
	public DataBaseUtility dataBaseUtility = new DataBaseUtility();
	public FileUtility fileUtility = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	
   
	@BeforeSuite(groups= {"smokeTest","regrssionTest"})
	public void configBS() throws SQLException {
		System.out.println("===Connect to DB,Report Config===");
		dataBaseUtility.getDbconnection("jdbc:mysql:// 49.249.28.218.8333/ninza_hrm", "root", "root");
		
	}
    // @Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regrssionTest"})
	public void configBC() throws IOException {
		System.out.println("===lunch the Browser===");
       // String BROWSER=browser;
		String BROWSER = fileUtility.getDataFromPropertiesFile("browser");

		if (BROWSER.equals("chrome")) {

			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
	}

	@BeforeMethod(groups= {"smokeTest","regrssionTest"})
	public void configBM() throws IOException {
		System.out.println("===Login===");

		LoginPage lp = new LoginPage(driver);

		String URL = fileUtility.getDataFromPropertiesFile("url");
		String USERNAME = fileUtility.getDataFromPropertiesFile("username");
		String PASSWORD = fileUtility.getDataFromPropertiesFile("password");

		lp.LoginToApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups= {"smokeTest","regrssionTest"})
	public void configAM() {
		System.out.println("===Logout===  ");
		HomePage hPage = new HomePage(driver);
		hPage.Logout();
	}

	@AfterClass(groups= {"smokeTest","regrssionTest"})
	public void configAC() {
		System.out.println("===Close the BROWSER===");
		driver.close();
	}

	@AfterSuite(groups= {"smokeTest","regrssionTest"})
	public void configAS() throws SQLException {
		System.out.println("===Close BD,Report backUP===");
		dataBaseUtility.closeDbconnection();
	}

}
