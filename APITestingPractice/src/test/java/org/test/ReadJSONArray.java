package org.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONArray 
{

	public static void main(String[] args) throws IOException, ParseException 
	{
		jsonread();
	}
	
	public static void jsonread() throws IOException, ParseException
	{
//File Reader reads the JSON file via its file location.
		FileReader f = new FileReader("C:\\Users\\bhara\\BharatTej_COREJAVA_workspace\\APITestingPractice\\src\\test\\resources\\EmpMgr.json");
//		System.out.println(f.toString());
//JSON parser class has parse() method which parses the FileReader object when passed to it.
		JSONParser p = new JSONParser();
		Object o = p.parse(f);
		System.out.println("After PARSING the FileReader object into an object: \n" +"                  "+o.toString());
		
//JSONObject - Typecast
		JSONObject jo = (JSONObject)o;
		System.out.println("After TYPECASTING the above object into JSONObject object: \n" +"                  "+jo.toString());

//Get Employee key value
		Object o1 = jo.get("employee");
		System.out.println("Getting the value of EMPLOYEE key that has Array of data which inturn has key-value pairs : \n" +"                  "+o1.toString());
		
//JSONArray
		JSONArray ja = (JSONArray)o1;
		System.out.println("Same EMPLOYEE key that has Array of data which inturn has key-value pairs is PUSHED to JSONArray : \n" +"                  "+ja.toString());

		Object o2 = ja.get(0);
		System.out.println("Getting the value at 0th index of EMPLOYEE key Array which inturn has key-value pairs : \n" +"                  "+o2.toString());
		
//JSONObject - Typecast
		JSONObject o3 = (JSONObject)o2;
		Object o4 = o3.get("eFirstName");
		System.out.println("Getting the value of 'eFirstName' key : \n" +"                  "+o4.toString());

//Get Manager key value
		Object jo1 = jo.get("manager");
		System.out.println("Getting the value of MANAGER key that has Array of data which inturn has key-value pairs : \n" +"                  "+jo1.toString());

//JSONArray		
		JSONArray ja1 = (JSONArray)jo1;
		System.out.println("Same MANAGER key that has Array of data which inturn has key-value pairs is PUSHED to JSONArray : \n" +"                  "+ja1.toString());

		Object o5 = ja1.get(0);
		System.out.println("Getting the value at 0th index of MANAGER key Array which inturn has key-value pairs : \n" +"                  "+o5.toString());

//JSONObject - Typecast
		JSONObject o6 = (JSONObject)o5;
		Object o7 = o6.get("mLastName");
		System.out.println("Getting the value of 'mLastName' key : \n" +"                  "+o7.toString());

	}
	
	
}
