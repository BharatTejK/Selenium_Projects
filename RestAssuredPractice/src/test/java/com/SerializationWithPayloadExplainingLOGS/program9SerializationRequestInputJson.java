package com.SerializationWithPayloadExplainingLOGS;

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
											.log().all()//At given(), i.e. ".log().all()" to log the input JSON at request part IS WHAT WE WANTED TO SEE.
											.header("Content-Type","application/json")
											.auth()
											.preemptive()
											.basic("bharattejprogrammer@gmail.com", "34KGbXOzFSiLv2dBbrUVE155")
											.body(program9PayLoad.createIssue())					
											.expect()
											.defaultParser(Parser.JSON)
										.when()
											.post("rest/api/2/issue/")
										.then()
											.log().all()//At then(), i.e. ".log().all()" to log the output JSON at response part IS WHAT WE WANTED TO SEE.
											.statusCode(201).extract().response();
		
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
