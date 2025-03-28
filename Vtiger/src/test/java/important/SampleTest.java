package important;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SampleTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new EdgeDriver();
	
		
		driver.get("https://demoapps.qspiders.com/ui/browser/multipleWindow?sublist=2");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@id='browserButton3']")).click();
		
	            Set<String>windowId	=driver.getWindowHandles();
	                        
	      Iterator<String>   it    = windowId.iterator();
	      
	         String pwdID  = it.next();
	         
	         String chilID=it.next();
	         
	         
	         
	         
	        // driver.manage().window().
		
		
		//driver
	

	}

}
