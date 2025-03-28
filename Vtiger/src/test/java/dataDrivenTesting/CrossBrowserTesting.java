package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserTesting {

	public static void main(String[] args) throws IOException {
		
		
		FileInputStream fis= new FileInputStream("./sam/CommonData.properties");

        Properties pobj=new Properties();

        pobj.load(fis);

        String URL=pobj.getProperty("url");
        String BROWSER =pobj.getProperty("edge");
        String  USERNAME = pobj.getProperty("username");
        String  PASSWORD = pobj.getProperty("password");

       /* Scanner s= new Scanner(System.in);
        System.out.println("enter the browser");
        String browser=s.next();
*/
        WebDriver driver =null;

        if(BROWSER.equals("chrome"))
        {
            driver =new ChromeDriver();
        } else if (BROWSER.equals("firefox")) {
            driver=new FirefoxDriver();
        } else if (BROWSER.equals("edge")) {
            driver=new EdgeDriver();

        }
        else {
            driver=new ChromeDriver();

            driver.get(URL);
        }

        driver.get(URL);
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("//input[@id='submitButton']")).click();
        driver .findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();

        driver.quit();
    }
	}


