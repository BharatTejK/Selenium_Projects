package com.adactinhotelapp.baseclass;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AdactinBaseClass 
{
	public static WebDriver driver;
	public static Select select;
	
	//To get the webdriver.(Also, includes Singleton - single object creation for WebDriver interface by child ChromeDriver() class)
	public static WebDriver gettingDriver() 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\bhara\\BharatTej_COREJAVA_workspace\\AHApracticcejunit\\Drivers\\chromedriver.exe");
		if(driver==null)
			driver = new ChromeDriver();
		return driver;
	}
	
//	//Singleton - single object creation for Select class  --- IN CURRENT SCENARIO SINGLETON WONT WORK SO COMMENTING
//	public static Select getSingleObject(WebElement element)
//	{
//		if(select==null)
//			select = new Select(element);
//		return select;
//	}
	
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
	public static void closeBrowser() 
	{
	//The below  method is used to close the browser which is currently in focus.if there is only one browser window open and you use the driver.close(), it will quit the webdriver session. The webdriver will not stay active.
		driver.close();
	}
	
	public static void quitDriver() throws InterruptedException
	{
	//The below method is used to end the running WebDriver instance. By calling this method, it closes all the active browser windows(which were initiated by the current driver instance) and the active session ends.
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
		select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public static String getDropDownSelectedValue(WebElement element)
	{
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public static void clearWebElementFieldOnBrowser(WebElement element)
	{
		element.clear();
	}
	
	public static void answerYesOnConfirmAlert()
	{
	Alert alert = driver.switchTo().alert();
	String alertquestion = alert.getText();
	System.out.println(alertquestion);
	alert.accept();
	}
	
	public static String getAllDropDownOptionValues(WebElement element, int index)
	{
		select = new Select(element);
		List<WebElement> li=select.getOptions();
		return li.get(index).getText();
	}

//	FIRST WAY: ForEach() (Explanation only)
//	Select select = new Select(ahp.getNumberofRooms());
//	List<WebElement> li=select.getOptions();
//	for(WebElement keka : li)
//	{
//		System.out.println(keka.getText());
//	}
//	SECOND WAY: ForEach() with lambda expressions (Explanation only)
//	li.forEach((n) -> System.out.println(n.getText())); 
	
	
	
}
