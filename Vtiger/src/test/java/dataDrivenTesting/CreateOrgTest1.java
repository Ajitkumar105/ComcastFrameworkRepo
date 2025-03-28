package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateOrgTest1 {

	public static void main(String[] args) throws IOException, Exception {
		 FileInputStream fis= new FileInputStream("C:\\Users\\Ajit\\eclipse-workspace\\Vtiger\\src\\main\\resources\\info\\Data.properties");




	        Properties pobj=new Properties();

	        pobj.load(fis);

	        String URL=pobj.getProperty("url");
	        String BROWSER =pobj.getProperty("browser");
	        String  USERNAME = pobj.getProperty("Username");
	        String  PASSWORD = pobj.getProperty("Password");

	        WebDriver driver =new EdgeDriver();

	        driver.get(URL);
	        Thread.sleep(3000);
	        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	        driver.findElement(By.xpath("//input[@id='submitButton']")).click();

	         driver .findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();

	         driver.quit();

		}
	}


