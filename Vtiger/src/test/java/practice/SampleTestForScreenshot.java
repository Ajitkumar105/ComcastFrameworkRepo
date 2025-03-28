package practice;






import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.Test;







public class SampleTestForScreenshot
{
	@Test
	public void amazonTest() throws IOException 
	{
		WebDriver driver=new EdgeDriver();
		driver.get("http://amazon.com");
		
		
		TakesScreenshot tS =(TakesScreenshot)driver;
		File srcFile=tS.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./screenshot./test.png"));
	}

}
