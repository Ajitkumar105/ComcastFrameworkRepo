package practice;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
public ExtentReports report;

	@BeforeSuite
	public void comfigBS() {
		// 1.spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdavaceReport/report.html");
		spark.config().setDocumentTitle("CRM  Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// 2.add envirnment information and create test

		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "edge");
	}

	@AfterSuite
	public void fongigAS() {
		report.flush();
	}

	@Test
	public void createContactTest() {
		
		WebDriver driver=new EdgeDriver();
		driver.get("http://49.249.28.218:8888/");
		TakesScreenshot tS=(TakesScreenshot)driver;
		String filepath=tS.getScreenshotAs(OutputType.BASE64);

		ExtentTest test = report.createTest("createContactTest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDEC".equals("HDFC")) {
			test.log(Status.PASS, " contact is craeted");
		} else {
             test.addScreenCaptureFromPath(filepath, "ErrorFile");
			//test.addScreenCaptureFromBase64String(" ErrorFile");
		}
		
		//driver.close();
		//report.flush();
		//System.out.println("login to app");

	}
	
}
