package org.test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class RestAPItest {
	public static void main(String[] args) 
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/";
		
		Response response = RestAssured
		.given().log().all().header("Content-Type","application/json").expect()
			.defaultParser(Parser.JSON)
		.when()
			.get("api/v1/employee/2")
		.then().log().all().extract().response();
		
		int statusCode = response.getStatusCode();
		System.out.println("response code is : " +statusCode);
		ResponseBody body = response.getBody();
		String bodyjson = body.asString();
		System.out.println("body is : "+bodyjson);
		
	}

}
