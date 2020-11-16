package com.APIChaining;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.response.Response;

public class program7reusablemethodsLibGlobal 
{
	public static int statusCode(Response response)
	{
		return response.getStatusCode();
	}
	
	public static String responseBody(Response response)
	{
		return response.getBody().asString();
	}
	
	public static String getValue(Response response,String idorkey) throws ParseException
	{
		//Passing to JSONParser itself means we want to convert a JSON that is present in String/file format.
		  String responseBody = response.getBody().asString();
		  JSONParser p = new JSONParser();
		  Object obj = p.parse(responseBody);
		  JSONObject jo = (JSONObject)obj;
		  Object obj2 = jo.get(idorkey);
		  String issuekey = obj2.toString();
//		  System.out.println(issuekey);
		  return issuekey;
	}
	
}
