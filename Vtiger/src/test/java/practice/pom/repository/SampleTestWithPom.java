package practice.pom.repository;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class SampleTestWithPom {
	@FindBy(name="user_name")     WebElement e1;
	@FindBy(name="user_password") WebElement e2;
	@FindAll({@FindBy(id="submitButton") ,@FindBy(xpath = "//input[@value='Login']" )})  WebElement el3;
	
	@Test
	public void Sampletest()
	{
		EdgeDriver driver=new EdgeDriver();
		
		 driver.get("http://49.249.28.218:8888/");
		 
	SampleTestWithPom sm	 =PageFactory.initElements(driver, SampleTestWithPom.class);

	                      sm.e1.sendKeys("admin");
	                      sm.e2.sendKeys("admin");
	                      sm.el3.click();
	
	                driver.navigate().refresh();
	                
	                sm.e1.sendKeys("admin");
                    sm.e2.sendKeys("admin");
                    sm.el3.click();
		
		
	}

}
