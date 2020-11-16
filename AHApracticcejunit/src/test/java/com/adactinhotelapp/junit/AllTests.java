package com.adactinhotelapp.junit;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.adactinhotelapp.baseclass.AdactinBaseClass;

@RunWith(Suite.class)
@SuiteClasses({AHAbookingTest.class, AHAjunit.class, AHAsearchpage.class, AHAdeleteBooked.class })
public class AllTests extends AdactinBaseClass
{
	@BeforeClass
	public static void SetUpClass() {
		System.out.println("---VALIDATION STARTS HERE---");
		Date d = new Date();
		System.out.println("Start Time - when entire testcases execution started: " + d);
	}
	
	@AfterClass
	public static void closeClass() throws InterruptedException 
	{
		quitDriver();
		Date d = new Date();
		System.out.println("End Time - when entire testcases execution ended: " + d);
		System.out.println("---VALIDATION ENDS HERE---");
	}
	
	
}
