package com.APIChaining;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class program5APIChaining 
{
public static void main(String[] args) throws ParseException 
{
	RestAssured.baseURI="https://reqres.in/";
	
	//Post
	Response resCreate = RestAssured.given().header("Content-Type","application/json").body(program5Payload.createUser())
			.when().post("api/users");
	
	int resCreateStatusCode = resCreate.getStatusCode();
	System.out.println("Response Code: "+resCreateStatusCode);
	
	String resCreateBody = resCreate.getBody().asString();
	System.out.println("Response Body: \n"+resCreateBody);

	//JSON Parser
	JSONParser p = new JSONParser();
	Object obj = p.parse(resCreateBody);
	
	JSONObject j = (JSONObject)obj;
	String namevar = j.get("name").toString();
	System.out.println(namevar);
	
	//put
	Response resUpdate = RestAssured.given().header("Content-Type","application/json").body(program5Payload.updateUser(namevar))
	.when().put("api/users/2"); 
	
	int resUpdateStatusCode = resUpdate.getStatusCode();
	System.out.println(resUpdateStatusCode);
	
	String resUpdateBody = resUpdate.getBody().asString();
	System.out.println(resUpdateBody);

	
}
}
