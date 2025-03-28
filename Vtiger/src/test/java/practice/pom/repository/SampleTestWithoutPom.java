package practice.pom.repository;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;



public class SampleTestWithoutPom {

	public static void main(String[] args) {
		
		EdgeDriver driver=new EdgeDriver();
		  driver.get("http://49.249.28.218:8888/");
		  
		  
		WebElement e1=  driver.findElement(By.xpath("//input[@name='user_name']"));
		  
		WebElement e2= driver.findElement(By.xpath("//input[@name='user_password']"));
		  
		WebElement e3= driver.findElement(By.id("submitButton"));
		
		
		e1.sendKeys("admin");
		e2.sendKeys("admin");
		e3.click();
		
		driver.navigate().refresh();

		e1.sendKeys("admin");
		e2.sendKeys("admin");
		e3.click();
	}

}
