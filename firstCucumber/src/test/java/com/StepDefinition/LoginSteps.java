package com.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginSteps 
{
	WebDriver driver;
	
	@Given("The user in facebook page")
	public void the_user_in_facebook_page() 
	{   
		System.setProperty("webdriver.chrome.driver","C:\\Users\\bhara\\BharatTej_COREJAVA_workspace\\firstCucumber\\Drivers\\latestversion\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}

	@When("The user has to fill username and password in textbox")
	public void the_user_has_to_fill_username_and_password_in_textbox() 
	{
		WebElement txtUsername = driver.findElement(By.id("email"));
		txtUsername.sendKeys("manoj");
		
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys("23456");
	}

	@When("The user click the login button")
	public void the_user_click_the_login_button() 
	{
		WebElement btnLogin = driver.findElement(By.name("login"));
		btnLogin.click();
	}

	@Then("The user navigate to home page")
	public void the_user_navigate_to_home_page() 
	{
		driver.quit();
		System.out.println("User has Successfully logged in.....");
	}
}
 