package com.adactinhotelapp.locatorspojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactinhotelapp.baseclass.AdactinBaseClass;

public class AdactinLoginPageLocators extends AdactinBaseClass
{
	@SuppressWarnings("unchecked")
	public AdactinLoginPageLocators(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy (id="username")
	private WebElement userName;
	
	@FindBy (id="password")
	private WebElement password;
	
	@FindBy (id="login")
	private WebElement btntoclick;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getBtntoclick() {
		return btntoclick;
	}


}
