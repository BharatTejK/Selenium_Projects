package com.APIChaining;

public class program6PayLoad 
{
	public static String createIssue()
	{
		return "{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \"project\":\r\n" + 
				"       {\r\n" + 
				"          \"key\": \"PROJ\"\r\n" + 
				"       },\r\n" + 
				"       \"summary\": \"THIS is created to learn API CHAINING VIA JIRA.\",\r\n" + 
				"       \"description\": \"I am creating this because I want to learn API CHAINING VIA JIRA\",\r\n" + 
				"       \"issuetype\": {\r\n" + 
				"          \"name\": \"Bug\"\r\n" + 
				"       }\r\n" + 
				"   }\r\n" + 
				"}";
	}
	
	
	public static String updateIssue(String value)
	{
		return "{\r\n" + 
				"    \"fields\" : {\r\n" + 
				"        \"summary\": \"The same issue created via POST which is "+value+" is updated via PUT request\",\r\n" + 
				"        \"description\": \"Description\"\r\n" + 
				"    }\r\n" + 
				"}";
		
	}
}
