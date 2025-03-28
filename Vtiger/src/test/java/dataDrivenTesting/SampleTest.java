package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class SampleTest {
@Test
public void a() throws IOException {
	 FileInputStream fis = new FileInputStream("./src/main/resources/info/Data.properties");
     

     Properties pObj = new Properties();
     pObj.load(fis);

     String BROWSER = pObj.getProperty("browser");
     String URL = pObj.getProperty("url");
     String USERNAME = pObj.getProperty("username");
     String PASSWORD = pObj.getProperty("password");
}
}
