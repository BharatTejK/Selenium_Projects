package com.APIChaining;

public class program5Payload 
{
 public static String createUser()
 {
	 return "{\r\n" + 
	 		"    \"name\": \"morpheus\",\r\n" + 
	 		"    \"job\": \"leader\"\r\n" + 
	 		"}";
 }
 
 public static String updateUser(String value)
 {
	 return "{\r\n" + 
	 		"    \"name\": \""+value+"\",\r\n" + 
	 		"    \"job\": \"zion resident\"\r\n" + 
	 		"}";
 }
 
}
