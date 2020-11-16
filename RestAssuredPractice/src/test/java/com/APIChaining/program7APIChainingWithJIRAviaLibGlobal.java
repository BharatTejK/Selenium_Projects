package com.APIChaining;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


public class program7APIChainingWithJIRAviaLibGlobal extends program7reusablemethodsLibGlobal
{

@Test
public void test1() throws ParseException 
	{
	  RestAssured.baseURI="https://amazonkbt.atlassian.net/";
	 
	  //POST
	  Response createRequest = RestAssured.given()
	  			 .header("Content-Type","application/json")
	  			 .auth()
	  			 .preemptive()
	  			 .basic("bharattejprogrammer@gmail.com", "veeqrNWC4aZhLnCVsBJf158B")
	  			 .body(program6PayLoad.createIssue())
	  			 .when().post("rest/api/2/issue");
	
	  System.out.println("Response code of create request is : "+statusCode(createRequest));
	  System.out.println("Response body of create request is : \n"+responseBody(createRequest));
//	Assertion
	  Assert.assertEquals("Status code should be 201: ",201, statusCode(createRequest));
	  	  
	  String issuekey = getValue(createRequest,"key");
	  System.out.println(issuekey);
	  
	  Assert.assertTrue("Status code should be : ", issuekey.contains("PROJ"));
	  Assert.assertTrue("Status body should contain project name : ", getValue(createRequest,"self").contains("amazonkbt"));

	
	  //PUT
	  Response updateRequest = RestAssured.given()
	  			 .header("Content-Type","application/json")
	  			 .auth()
	  			 .preemptive()
	  			 .basic("bharattejprogrammer@gmail.com", "veeqrNWC4aZhLnCVsBJf158B")
	  			 .body(program6PayLoad.updateIssue(issuekey))
	  			 .when().put("rest/api/2/issue/"+issuekey);
	  
	  System.out.println("Response code of update request is : "+statusCode(updateRequest));
	  System.out.println("Response body of update request is : \n"+responseBody(updateRequest));
	  
	  Assert.assertEquals("Status code should be 204: ",204, statusCode(updateRequest));
	  	  
	  //DELETE
	  Response deleteRequest = RestAssured.given()
	  .header("Content-Type","application/json")
	  .auth()
	  .preemptive()
	  .basic("bharattejprogrammer@gmail.com", "veeqrNWC4aZhLnCVsBJf158B")
	  .when().delete("/rest/api/3/issue/"+issuekey);
	  
	  System.out.println("Response code of delete request is : "+statusCode(deleteRequest));
	  System.out.println("Response body of delete request is : \n"+responseBody(deleteRequest));

	  Assert.assertEquals("Status code should be 204: ",204, statusCode(deleteRequest));

	}
}
