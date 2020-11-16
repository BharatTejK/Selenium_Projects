package org.test;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSON 
{
	public static void main(String[] args) throws IOException, ParseException {
		readjson();
	}
	
	public static void readjson() throws IOException, ParseException
	{
	//file location 
	FileReader r = new FileReader("C:\\Users\\bhara\\BharatTej_COREJAVA_workspace\\APITestingPractice\\src\\test\\resources\\sample.json");
	//create the json parser
	JSONParser p=new JSONParser();
	Object o = p.parse(r);
	//JSONObject
	//typecasting
	JSONObject j = (JSONObject)o;
	
	Object o1 = j.get("Browsername");
	Object o2 = j.get("Username");
	Object o3 = j.get("Password");

	System.out.println(o1.toString());
	System.out.println(o3.toString());
	System.out.println(o2.toString());
	  
	}
}


