package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class HomePageVerification {
	
	String expectedPage="Home";
	@Test
	
	public void homePage()
	{
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://49.249.28.218:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
         driver.findElement(By.id("submitButton")).click();
        String actTitle= driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
        
        if (actTitle.trim().equals(expectedPage)) 
        {
        	System.out.println(expectedPage+ "Page is verified");
        	
        }
        else {
        	System.out.println(expectedPage+ "Page is not  verified");
		}
			
		}
	
	 @Test
	public void verifyHomePageTest()
	{
		
		
	}

}
