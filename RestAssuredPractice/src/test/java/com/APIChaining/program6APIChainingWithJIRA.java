package com.APIChaining;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class program6APIChainingWithJIRA 
{
public static void main(String[] args) throws ParseException 
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
	
	  int createstatusCode = createRequest.getStatusCode();
	  System.out.println("Response code of create request is : "+createstatusCode);
	  
	  ResponseBody createResponseBody = createRequest.getBody();
	  String createBody = createResponseBody.asString();
	  System.out.println("Response body of create request is : \n"+createBody);
	
	  JSONParser p = new JSONParser();
	  Object obj = p.parse(createBody);
	  JSONObject jo = (JSONObject)obj;
	  Object obj2 = jo.get("key");
	  String issuekey = obj2.toString();
	  System.out.println(issuekey);
	
	  //PUT
	  Response updateRequest = RestAssured.given()
	  			 .header("Content-Type","application/json")
	  			 .auth()
	  			 .preemptive()
	  			 .basic("bharattejprogrammer@gmail.com", "veeqrNWC4aZhLnCVsBJf158B")
	  			 .body(program6PayLoad.updateIssue(issuekey))
	  			 .when().put("rest/api/2/issue/"+issuekey);
	  
	  int putStatusCode = updateRequest.getStatusCode();
	  System.out.println("Response code of update request is : "+putStatusCode);
	  
	  ResponseBody updateBody = updateRequest.getBody();
	  String body = updateBody.asString();
	  System.out.println("Response body of update request is : \n"+body);
	  
	  //DELETE
	  Response deleteRequest = RestAssured.given()
	  .header("Content-Type","application/json")
	  .auth()
	  .preemptive()
	  .basic("bharattejprogrammer@gmail.com", "veeqrNWC4aZhLnCVsBJf158B")
	  .when().delete("/rest/api/3/issue/"+issuekey);
	  
	  int deleteStatusCode = deleteRequest.getStatusCode();
	  System.out.println("Response code of delete request is : "+deleteStatusCode);
	  
	  ResponseBody deleteResponseBody = deleteRequest.getBody();
	  String deleteBody = deleteResponseBody.asString();
	  System.out.println("Response body of delete request is : \n"+deleteBody);

	}
}
