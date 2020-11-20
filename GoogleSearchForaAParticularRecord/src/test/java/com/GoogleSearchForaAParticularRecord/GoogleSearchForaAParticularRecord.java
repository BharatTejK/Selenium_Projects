package com.GoogleSearchForaAParticularRecord;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchForaAParticularRecord 
{
	static WebDriver driver;
	static WebElement element;
	public static WebDriver driverSetup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\bhara\\BharatTej_COREJAVA_workspace\\GoogleSearchForaAParticularRecord\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public static void openBrowserAndGoToURL(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static WebElement findElement(String selector)
	{
		element = driver.findElement(By.cssSelector(selector));
		return element;
	}
	
	public static void sendDataToTheGoogleSearchField(WebElement element, String text)
	{
		element.sendKeys(text);
	}
	
	public static void clickIt(WebElement element)
	{
		element.click();
	}
	
	
	
	public static void main(String[] args) throws InterruptedException 
	{
			String website_url = "https://www.google.com/";
			String search_string = "selenium demo";
			String googleSearchField = "#tsf > div:nth-child(2) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input";
			String googleSearchFourthdropdownoption = "#tsf > div:nth-child(2) > div.A8SBwf.emcav > div.UUbT9 > div.aajZCb > ul > li:nth-child(4) > div > div.sbtc > div.sbl1 > span";
			String searchListfourthElement = "#rso > div:nth-child(4) > div > div.yuRUbf > a > h3 > span";
			driverSetup();
			openBrowserAndGoToURL(website_url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			sendDataToTheGoogleSearchField(findElement(googleSearchField),search_string);
			clickIt(findElement(googleSearchFourthdropdownoption));
			clickIt(findElement(searchListfourthElement));
			Thread.sleep(5000);
			driver.close();
		
	}

}
