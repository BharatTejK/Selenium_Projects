package org.junittest;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleJunit 
{
	static WebDriver driver;
	@BeforeClass
	public static void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhara\\BharatTej_COREJAVA_workspace\\MavenProjectFirst\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.facebook.com/");
	}
	
	@AfterClass
	public static void afterClass()
	{
		driver.quit();
	}
	
	@Before
	public void before()
	{
		Date d = new Date();
		System.out.println("Start time :"+d);

	}
	
	@After
	public void after()
	{
		Date d = new Date();
		System.out.println("End time :"+d);
	}
	

	@Test //lets say, we are giving valid username and invalid password
	public void test1()
	{
		driver.get("http://www.facebook.com/");
		
		Assert.assertTrue("Verify Login URL", driver.getCurrentUrl().contains("facebook"));
		
		WebElement txtUsername = driver.findElement(By.id("email"));
		txtUsername.sendKeys("mano");
		String userValue = txtUsername.getAttribute("value");

		Assert.assertEquals("Verify username", "Mano", userValue);//purposefully given M to show failure
		
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys("3456");
		
		Assert.assertEquals("Verify password", "3456", txtPassword.getAttribute("value"));
		
//		WebElement btnLogin = driver.findElement(By.name("login"));
//		btnLogin.click();
		
		System.out.println("Test1");
	}
	
	
	@Test //lets say, we are giving invalid username and invalid password
	public void test2()
	{
		driver.get("http://www.facebook.com/");
		WebElement txtUsername = driver.findElement(By.id("email"));
		txtUsername.sendKeys("kumar");
		
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys("345678");
		
		WebElement btnLogin = driver.findElement(By.name("login"));
		btnLogin.click();
		
		System.out.println("Test2");

	}
}
