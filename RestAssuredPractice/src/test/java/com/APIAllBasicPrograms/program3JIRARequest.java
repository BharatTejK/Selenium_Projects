package com.APIAllBasicPrograms;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class program3JIRARequest 
{
	public static void main(String[] args) 
	{
		
	RestAssured.baseURI="https://amazonkbt.atlassian.net/";
	
		//GET
	Response getResponse = RestAssured.given().header("Content-Type","application/json").auth().preemptive()
						.basic("bharattejprogrammer@gmail.com", "QNJY8kCJDuo0jdnINl9b3DF3")
						.when().get("rest/api/2/search");
	
	int getstatuscode = getResponse.getStatusCode();
	System.out.println("GET Response Code: "+getstatuscode);
		
	String getBody = getResponse.getBody().asString();
	System.out.println("GET Response Body: \n"+getBody);
	
		//POST
	Response  postResponse = RestAssured.given()
										.header("Content-Type","application/json")
										.auth()
										.preemptive()
										.basic("bharattejprogrammer@gmail.com", "QNJY8kCJDuo0jdnINl9b3DF3")
										.body("{\r\n" + 
												"    \"fields\": {\r\n" + 
												"       \"project\":\r\n" + 
												"       {\r\n" + 
												"          \"key\": \"PROJ\"\r\n" + 
												"       },\r\n" + 
												"       \"summary\": \"This is created via REST ASSURED.\",\r\n" + 
												"       \"description\": \"This is created via REST ASSURED. To practice so I have created this.\",\r\n" + 
												"       \"issuetype\": {\r\n" + 
												"          \"name\": \"Bug\"\r\n" + 
												"       }\r\n" + 
												"   }\r\n" + 
												"}")
										.when()
										.post("rest/api/2/issue/");
	
	int postStatusCode = postResponse.getStatusCode();
	System.out.println("POST Response Code: "+postStatusCode);
	
	String postBody = postResponse.getBody().asString();
	System.out.println("POST Response Body: \n"+postBody);					
							
					
		//PUT		
	Response putResponse = RestAssured.given()
				.header("Content-Type","application/json")
				.auth()
				.preemptive()
				.basic("bharattejprogrammer@gmail.com", "QNJY8kCJDuo0jdnINl9b3DF3")
				.body("{\r\n" + 
						"    \"fields\" : {\r\n" + 
						"        \"summary\": \"THIS PART IS UPDATED - This is created via REST ASSURED\",\r\n" + 
						"        \"description\": \"THIS PART IS UPDATED - This is created via REST ASSURED. To practice so I have created this.\"\r\n" + 
						"    }\r\n" + 
						"}")
				.when()
				.put("rest/api/2/issue/PROJ-12");
					
					int putstatusCode = putResponse.getStatusCode();
					System.out.println("PUT Response Code: "+putstatusCode);
					
					ResponseBody body = putResponse.getBody();
					String putBody = body.asString();
					System.out.println(putBody);
				    System.out.println("The variable 'putBody'='"+putBody+"' i.e. is NULL because PUT request has nothing to return." );					

					
		//DELETE				
     Response deleteResponse = RestAssured.given()
		  								.header("Content-Type","application/json")
		  								.auth()
		  								.preemptive()
		  								.basic("bharattejprogrammer@gmail.com", "QNJY8kCJDuo0jdnINl9b3DF3")
		  								.when()
		  								.delete("rest/api/3/issue/PROJ-15");
  
     int deletestatuscode = deleteResponse.getStatusCode();
     System.out.println("DELETE Response Code: "+deletestatuscode);
						
     String deleteBody = deleteResponse.getBody().asString();
     System.out.println("DELETE Response Body: \n"+deleteBody);					
     System.out.println("The variable 'deleteBody'='"+deleteBody+"' i.e. is NULL because DELETE request does not return any body." );					

					
					
	}
	

}
