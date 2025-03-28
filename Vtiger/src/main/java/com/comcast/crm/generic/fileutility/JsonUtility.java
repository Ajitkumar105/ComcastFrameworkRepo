package com.comcast.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	public  String getDataFromJsonFile(String key, Object data) throws IOException, ParseException {
		
		FileReader fileR=new FileReader("./sam/co mmonData.json");
		JSONParser   parser= new JSONParser();
		 Object obj=parser.parse(fileR);
		 JSONObject map= (JSONObject)obj;
		 System.out.println(map.get("url"));
		return (String) (data=map.get(key));
		
	}
 
}
