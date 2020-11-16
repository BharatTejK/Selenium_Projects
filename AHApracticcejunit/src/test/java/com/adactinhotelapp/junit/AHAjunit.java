package com.adactinhotelapp.junit;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.adactinhotelapp.baseclass.AdactinBaseClass;
import com.adactinhotelapp.locatorspojo.AdactinLoginPageLocators;

public class AHAjunit extends AdactinBaseClass 
{

	@Before
	public void loadingRequiredURL() 
	{
		gettingDriver();
		System.out.println("---TestCase Starts here---");
		loadingURL("http://adactinhotelapp.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Date d = new Date();
		System.out.println("Start Time : " + d);
	}

	@After
	public void atAfter() throws InterruptedException 
	{
		System.out.println("---TestCase Ends here---");
		Date d = new Date();
		System.out.println("End Time : " + d);
//		closeBrowser();
	}


	@Test
	public void loginPageUserNameNull() 
	{
		System.out.println("---Validate login page when username is not entered---");
		AdactinLoginPageLocators lpl = new AdactinLoginPageLocators(driver);
		String usernameexpected = "PawanKalyanBharatTej";
		typeOnBrowserAtElement(lpl.getUserName(), "");
		String usernameactual = getAttributeElement(lpl.getUserName());
		System.out.println("UserName retrieved from the browser: " + usernameactual);
		Assert.assertNotEquals(usernameexpected, usernameactual);
	}

	@Test
	public void loginPageUserNameEnteredWrong() 
	{
		System.out.println("---Validate login page when username is entered wrongly---");
		AdactinLoginPageLocators lpl = new AdactinLoginPageLocators(driver);
		String usernameexpected = "PawanKalyanBharatTej";
		typeOnBrowserAtElement(lpl.getUserName(), "PawanKalyan");
		String usernameactual = getAttributeElement(lpl.getUserName());
		System.out.println("UserName retrieved from the browser: " + usernameactual);
		Assert.assertNotEquals(usernameexpected, usernameactual);
	}
	
	@Test
	public void loginPageUserNameEnteredCorrect() 
	{
		System.out.println("---Validate login page when username is entered correctly---");
		AdactinLoginPageLocators lpl = new AdactinLoginPageLocators(driver);
		String usernameexpected = "PawanKalyanBharatTej";
		typeOnBrowserAtElement(lpl.getUserName(), "PawanKalyanBharatTej");
		String usernameactual = getAttributeElement(lpl.getUserName());
		System.out.println("UserName retrieved from the browser: " + usernameactual);
		Assert.assertEquals(usernameexpected, usernameactual);
	}
	
	@Test
	public void loginPagePasswordNull() 
	{
		System.out.println("---Validate login page when password is not entered---");
		AdactinLoginPageLocators lpl = new AdactinLoginPageLocators(driver);
		String passwordexpected = "PawanKalyanBharatTej";
		typeOnBrowserAtElement(lpl.getPassword(), "");
		String passwordactual = getAttributeElement(lpl.getPassword());
		System.out.println("UserName retrieved from the browser: " + passwordactual);
		Assert.assertNotEquals(passwordexpected, passwordactual);
	}

	@Test
	public void loginPagePasswordWrong() 
	{
		System.out.println("---Validate login page when password is entered wrongly---");
		AdactinLoginPageLocators lpl = new AdactinLoginPageLocators(driver);
		String passwordexpected = "Qwerty123$";
		typeOnBrowserAtElement(lpl.getPassword(), "Qwerty1");
		String passwordactual = getAttributeElement(lpl.getPassword());
		System.out.println("UserName retrieved from the browser: " + passwordactual);
		Assert.assertNotEquals(passwordexpected, passwordactual);
	}
	
	@Test
	public void loginPagePasswordCorrect() 
	{
		System.out.println("---Validate login page when password is entered correctly---");
		AdactinLoginPageLocators lpl = new AdactinLoginPageLocators(driver);
		String passwordexpected = "Qwerty123$";
		typeOnBrowserAtElement(lpl.getPassword(), "Qwerty123$");
		String passwordactual = getAttributeElement(lpl.getPassword());
		System.out.println("UserName retrieved from the browser: " + passwordactual);
		Assert.assertEquals(passwordexpected, passwordactual);
	}


	@Test
	public void loginPageUserNameAndPassswordCorrect() 
	{
		System.out.println("---Validate login page when username and password are entered correctly---");
		System.out.println("The current page URL is: "+getCurrentPageURL());
		AdactinLoginPageLocators lpl = new AdactinLoginPageLocators(driver);
		typeOnBrowserAtElement(lpl.getUserName(), "PawanKalyanBharatTej");
		typeOnBrowserAtElement(lpl.getPassword(), "Qwerty123$");
		String usernameactual = getAttributeElement(lpl.getUserName());
		String passwordactual = getAttributeElement(lpl.getPassword());
		btnClicking(lpl.getBtntoclick());
		System.out.println("UserName retrieved from the browser: " + usernameactual);
		System.out.println("Password retrieved from the browser: " + passwordactual);
		System.out.println("The current page URL is: "+getCurrentPageURL());
		String expectedURL = "http://adactinhotelapp.com/SearchHotel.php";
		System.out.println("The expected page URL is: "+expectedURL);
		Assert.assertTrue("Failed...",getCurrentPageURL().trim().equals(expectedURL.trim()));
//		Assert.assertEquals(getCurrentPageURL(), "http://adactinhotelapp.com/SearchHotel.php");

	}

}
