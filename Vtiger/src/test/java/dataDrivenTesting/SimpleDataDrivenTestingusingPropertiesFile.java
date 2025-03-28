package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SimpleDataDrivenTestingusingPropertiesFile {

	

	public static <WebDriver> void main(String[] args) throws IOException {
	//1.create the object of input file stream	
		FileInputStream fis=new FileInputStream("C:\\Users\\Ajit\\Desktop\\New folder\\commandata.properties.txt");
		
	//2.using properties class load all the key
		
		Properties pObj=new Properties();
		
	            pObj.load(fis);
	            
	   //3.Get the value based on key
	            
	           String  URL=  pObj.getProperty("url");
	           String BROWSER= pObj.getProperty("broswer");
	           String USERNAME= pObj.getProperty("Username");
	           String PASSWORD= pObj.getProperty("Password");
	        		System.out.println(URL);
	            System.out.println(BROWSER);
	            System.out.println(USERNAME);
	            System.out.println(PASSWORD);
	            

}}
