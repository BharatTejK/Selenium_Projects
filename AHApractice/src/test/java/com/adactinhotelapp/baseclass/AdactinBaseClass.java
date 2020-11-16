package com.adactinhotelapp.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AdactinBaseClass 
{
	public static WebDriver driver;
	
	//To get the webdriver.
	public static WebDriver gettingDriver() 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\bhara\\BharatTej_COREJAVA_workspace\\AHApractice\\Drivers\\chromedriver.exe");
		return driver = new ChromeDriver();
	}
	
	//To load the page we wanted to open via driver.
	public static void loadingURL(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}

	//sending data(passed as parameter) into the particular element(passed as parameter) like textbox element.
	public static void typeOnBrowserAtElement(WebElement element,String value) 
	{
		element.sendKeys(value);
	}
	
	// Clicking the button element that is passed as a parameter.
	public static void btnClicking(WebElement element) 
	{
		element.click();
	}
	
	//closing the browser
	public static void closeBrowser() throws InterruptedException
	{
		Thread.sleep(10000);
		driver.quit();
	}
	
	// getting data at the element that is passed as the parameter.
	public static String getTextFromElement(WebElement element)
	{
		String text = element.getText();
		return text;
	}
	
	public static String getAttributeElement(WebElement element)
	{
		String text = element.getAttribute("value");
		return text;
	}
	
	// getting URL of the page that we are currently in.
	public static String getCurrentPageURL()
	{
		return driver.getCurrentUrl();
	}
	
	public static void dropDownSelect(WebElement element, String value)
	{
		Select locationDropDown = new Select(element);
		locationDropDown.selectByVisibleText(value);
	}

	
	
	
	
	
}
