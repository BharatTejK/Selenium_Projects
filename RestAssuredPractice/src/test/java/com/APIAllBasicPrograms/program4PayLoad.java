package com.APIAllBasicPrograms;

public class program4PayLoad 
{

	public static String createIssue()
	{
		String postorcreate = "{\r\n" + 
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
				"}";
		return postorcreate;
	}
	
	public static String updateIssue()
	{
		return "{\r\n" + 
				"    \"fields\" : {\r\n" + 
				"        \"summary\": \"THIS PART IS UPDATED - This is created via REST ASSURED\",\r\n" + 
				"        \"description\": \"THIS PART IS UPDATED - This is created via REST ASSURED. To practice so I have created this.\"\r\n" + 
				"    }\r\n" + 
				"}";
	}
	
}
