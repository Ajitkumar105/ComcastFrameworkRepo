package testngpractice;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;





public class GetProductInfoTest {
	@Test
	public void getDataProductInfoTest(String brandName,String productName)
	{
		WebDriver driver =new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://amazon.com");
		
		//1.Search the product
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		//2.capture the product Info
		
		//String x="pan[text"
	}
	
	//public Object[][] getData()
	{
}

}
