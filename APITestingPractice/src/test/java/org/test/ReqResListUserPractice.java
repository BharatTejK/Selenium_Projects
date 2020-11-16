package org.test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReqResListUserPractice 
{

public static void ReqResListUserJSONDiaplay() throws IOException, ParseException
{
	
	List<String> al = new ArrayList<String>();
	al.add(0, "page");
	al.add(1, "per_page");
	al.add(2, "total");
	al.add(3, "total_pages");
	al.add(4, "data");
	al.add(5, "ad");
	
	System.out.println("Data in ArrayList al: ");
	for(int i=0; i<al.size(); i++)
	{
	System.out.println(al.get(i));
	}
	
	List<String> al1 = new ArrayList<String>();
	al1.add(0, "id");
	al1.add(1, "email");
	al1.add(2, "first_name");
	al1.add(3, "last_name");
	al1.add(4, "avatar");
	
	System.out.println(" ");
	System.out.println("Data in ArrayList al1: ");	
	for(int i=0; i<al1.size(); i++)
	{
	System.out.println(al.get(i));
	}
	
	FileReader f = new FileReader("C:\\Users\\bhara\\BharatTej_COREJAVA_workspace\\APITestingPractice\\src\\test\\resources\\ReqResListUsersPractice.json");
	JSONParser jp = new JSONParser();
	Object o =jp.parse(f);
	System.out.println(" ");
	System.out.println("PARSED FILE: "+o.toString());

	JSONObject jo = (JSONObject)o;
	System.out.println(" ");
	System.out.println("PARSED FILE typecasted into JSONOBJECT: "+jo.toString());;
	System.out.println(" ");
	System.out.println("Data present in the PARSED FILE typecasted into JSONOBJECT (getting with keys): ");
	for(int i=0; i<al.size(); i++)
	{
	System.out.println("The value of the key '"+al.get(i)+"' is : "+jo.get(al.get(i)));
	}
	
	Object o1 = jo.get("data");
	JSONArray ja = (JSONArray)o1;
	System.out.println(" ");
	System.out.println("Data present in the key='data' of the PARSED FILE typecasted into JSONOBJECT which is inturn typecasted into JSONARRAY: ");	

	for(int j=0; j<ja.size(); j++)
	{
		System.out.println("The value present at '"+j+"' index of JSONARRAY which has values of the key 'data' is : "+ja.get(al.indexOf(al.get(j))));
	}
	
	for (int i = 0; i<ja.size(); i++)
	{
		System.out.println(" ");
		Object o2 = ja.get(i);
		JSONObject jo1 = (JSONObject)o2;
		System.out.println("Below is the data present at index '"+i+"' of the key='data' of the PARSED FILE typecasted into JSONOBJECT which is inturn typecasted into JSONARRAY: ");
		for (int j = 0; j<al1.size(); j++)
		{
			Object o3 = jo1.get(al1.get(j));
			System.out.println("The data of the key '"+ al1.get(j) +"' is : "+o3);
		}
	}
			
}
	
	public static void main(String[] args) throws IOException, ParseException 
	{
		ReqResListUserJSONDiaplay();

	}

}
