package com.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginSteps 
{
	WebDriver driver;

	@Given("connect to the chrome driver and go to the AHA website")
	public void connect_to_the_chrome_driver_and_go_to_the_AHA_website() 
	{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\bhara\\BharatTej_COREJAVA_workspace\\AHApracticeCucumber\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
	}

	@When("The credentials of a user are entered")
	public void the_credentials_of_a_user_are_entered() 
	{
		WebElement txtuserename = driver.findElement(By.id("username"));
		txtuserename.sendKeys("BharatTejPawanKalyan");

		WebElement txtpassword = driver.findElement(By.id("password"));
		txtpassword.sendKeys("Qwerty123$");
	}

	@When("Click the login button")
	public void click_the_login_button() 
	{
		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();

	}

	@Then("User must navigate to the login page")
	public void user_must_navigate_to_the_login_page() 
	{
		System.err.println("We should be in AHA homepage");
		
	}

	
}
