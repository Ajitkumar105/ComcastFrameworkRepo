package dataDrivenTesting;

import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest 
{
	public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
	
	
	
//Step1 : parse json physical file in to Java object using parse class 
	
 JSONParser   parser= new JSONParser();
 
 
 
Object obj=parser.parse(new FileReader("./sam/CommonData.json"));

//2.Convert java object in to jasonObject using down casting

JSONObject map= (JSONObject)obj;
//3 get the vale from json using key
System.out.println(map.get("url"));
System.out.println(map.get("browser"));
System.out.println(map.get("username"));
System.out.println(map.get("password"));
System.out.println(map.get("timeout"));


   
	}
	

}
