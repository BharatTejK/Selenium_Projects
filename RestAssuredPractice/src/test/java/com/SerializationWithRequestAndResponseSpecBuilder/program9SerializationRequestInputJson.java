package com.SerializationWithRequestAndResponseSpecBuilder;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class program9SerializationRequestInputJson 
{
	public static void main(String[] args) 
	{
		
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
			auth.setUserName("bharattejprogrammer@gmail.com");
			auth.setPassword("34KGbXOzFSiLv2dBbrUVE155");
//REQUEST SPEC BUILDER 
		RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();
		RequestSpecification ReqSpecPostAndPut = reqSpecBuilder.setBaseUri("https://amazonkbt.atlassian.net/")
															.setContentType(ContentType.JSON)
															.setAuth(auth)
															.build();
//TO SIMPLIFY THE ABOVE 2 STATEMENTS WE CAN GIVE AS BELOW:
//RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder().setBaseUri("https://amazonkbt.atlassian.net/").setContentType(ContentType.JSON).setAuth(auth).build();
		
//RESPONSE SPEC BUILDER 
		ResponseSpecBuilder resSpecBuilder = new ResponseSpecBuilder();
		
		//POST request
		ResponseSpecification ResSpecPost = resSpecBuilder.expectStatusCode(201).expectContentType(ContentType.JSON).build();
//TO SIMPLIFY THE ABOVE 2 STATEMENTS WE CAN GIVE AS BELOW:
//ResponseSpecification ResSpecPost = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		System.err.println("*****************************************************POST*****************************************************");
		Response resPOST = RestAssured.given()
											.log()
											.all()
											.spec(ReqSpecPostAndPut)//PASSING THE "ReqSpecPost" THAT WE CREATED ABOVE
											.body(program9PayLoad.createIssue())					
											.expect()
											.defaultParser(Parser.JSON)
										.when()
											.post("rest/api/2/issue/")
										.then()
											.spec(ResSpecPost)//PASSING THE "ResSpecPost" THAT WE CREATED ABOVE
											.log()
											.all()
//											.statusCode(201)
											.extract()
											.response();
		System.out.println("The Status code of the response is : "+resPOST.getStatusCode());
		ResponseBody bodypost = resPOST.getBody();
		String bodyStrpost = bodypost.asString();
		System.out.println("The body of the response is : \n"+bodyStrpost);

		program9SerializationRequestDeserializingResponsePOST respDeserialise = resPOST.as(program9SerializationRequestDeserializingResponsePOST.class);
		String keyOfPost = respDeserialise.getKey();
		
		System.out.println("The response body has 'id' value : "+respDeserialise.getId());
		System.out.println("The response body has 'key' value : "+respDeserialise.getKey());
		System.out.println("The response body has 'self' value : "+respDeserialise.getSelf());
		

		//PUT request
		ResponseSpecification ResSpecPut = resSpecBuilder.expectStatusCode(204).expectContentType(ContentType.JSON).build();
		System.err.println("*****************************************************PUT*****************************************************");
		Response resPUT = RestAssured.given()
											.log()
											.all()
											.spec(ReqSpecPostAndPut)
											.body(program9PayLoad.updateIssue(keyOfPost))
											.expect()
											.defaultParser(Parser.JSON)
									 .when()
									 		.put("rest/api/2/issue/"+keyOfPost) //COVERED API CHAINING ALSO JUST FOR PRACTICE
									 .then().spec(ResSpecPut)
									 		.log()
									 		.all()
//									 		.statusCode(204)
									 		.extract()
									 		.response();
		
		System.out.println("The Status code of the response is : "+resPUT.getStatusCode());
		ResponseBody bodyput = resPUT.getBody();
		String bodyStrput = bodyput.asString();
		int statusCode = resPUT.getStatusCode();
		if(statusCode!=204)
		{
		System.out.println("The body of the response is : \n"+bodyStrput);
		}			
	}
	
}
