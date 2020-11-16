package com.SerializationWithPayload;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class program9SerializationRequestInputJson 
{
	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://amazonkbt.atlassian.net/";
		

			
		Response response = RestAssured.given()
											.header("Content-Type","application/json")
											.auth()
											.preemptive()
											.basic("bharattejprogrammer@gmail.com", "34KGbXOzFSiLv2dBbrUVE155")
											.body(program9PayLoad.createIssue())					
											.expect()
											.defaultParser(Parser.JSON)
										.when()
											.post("rest/api/2/issue/");
		
		System.out.println("The Status code of the response is : "+response.getStatusCode());
		
		ResponseBody body = response.getBody();
		String bodyStr = body.asString();
		System.out.println("The body of the response is : \n"+bodyStr);
		
		program9SerializationRequestDeserializingItsResponse respDeserialise = response.as(program9SerializationRequestDeserializingItsResponse.class);
		System.out.println("The response body has 'id' value : "+respDeserialise.getId());
		System.out.println("The response body has 'key' value : "+respDeserialise.getKey());
		System.out.println("The response body has 'self' value : "+respDeserialise.getSelf());


		
		
					
	}
	
}
