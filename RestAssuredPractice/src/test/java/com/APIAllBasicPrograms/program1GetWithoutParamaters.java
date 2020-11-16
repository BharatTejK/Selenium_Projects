package com.APIAllBasicPrograms;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class program1GetWithoutParamaters 
{
public static void main(String[] args) //MANOJ SIR VIDEO API-12.mp4
{
	// GET,given(),when()
// first we need to set up the BASEURI as a first step for that we have a static vairable called baseURI in RestAssured class
	RestAssured.baseURI="https://reqres.in/";
	
//	the baseURI is by default taken by given() method then we should pass to it the header, authentication, parameter and inputbody (in general)
	RequestSpecification req = RestAssured.given().headers("Content-Type","application/json");
	
//	The method when() using which we pass request type(here 'Get()') and resource/endpoint is not present in RestAssured class but it is present in RequestSpecification Interface
	Response response = req.when().get("/api/users?page=2");
	
/*	
    we can also pass when() part as this way( the return type of when will be a Response so we are using that)
	Response response = RestAssured.given().headers("Content-Type","application/json").when().get("/api/users?page=2");
*/	

	// response code
//	The method getStatusCode() is used to retrieve the status code form the response object
	int statuscode = response.getStatusCode();
	System.out.println("Response Code: "+statuscode);
	
	// response body
//	The method getBody() is used to retrieve the status code form the response object	
	ResponseBody body = response.getBody();
	//if it is a file/string then you can use toString() but it is coming in a JSON file Object so we should use asString().
	String respbodyjson = body.asString();
	System.out.println(respbodyjson);
}
	
}
