package com.Deserialization;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class program8DeserializationResponse {

	public static void main(String[] args) 
	{
		
		RestAssured.baseURI="https://reqres.in/";
		
		Response response = RestAssured.given()
					.header("Content-Type","application/json")
					.expect()
					.defaultParser(Parser.JSON)
					.when()
					.get("api/users");
		
		int statusCode = response.getStatusCode();
		System.out.println("The Status code of the response is : "+statusCode);

		ResponseBody body = response.getBody();
		String asString = body.asString();
		System.out.println("The Response Body of the response is : \n"+asString);
		
		program8DeserializationResponsePojoFULL responseBodyToObj = response.as(program8DeserializationResponsePojoFULL.class);
		
		System.out.println(responseBodyToObj.getPage());
		System.out.println(responseBodyToObj.getPer_page());
		System.out.println(responseBodyToObj.getTotal());
		System.out.println(responseBodyToObj.getTotal_pages());
		
		List<program8DeserializationResponsePojoDATA> data = responseBodyToObj.getData();
		for(program8DeserializationResponsePojoDATA eachdata : data)
		{
			System.out.println(eachdata.getId());
			System.out.println(eachdata.getFirst_name());
			System.out.println(eachdata.getLast_name());
			System.out.println(eachdata.getEmail());
			System.out.println(eachdata.getAvatar());
		}
		
		program8DeserializationResponsePojoAD ad = responseBodyToObj.getAd();
		System.out.println(ad.getCompany());
		System.out.println(ad.getUrl());
		System.out.println(ad.getText());
	}

}
