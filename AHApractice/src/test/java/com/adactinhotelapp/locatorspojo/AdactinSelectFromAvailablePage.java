package com.adactinhotelapp.locatorspojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactinhotelapp.baseclass.AdactinBaseClass;

public class AdactinSelectFromAvailablePage extends AdactinBaseClass
{
	@SuppressWarnings("unchecked")
	public AdactinSelectFromAvailablePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(id="radiobutton_0")
	private WebElement radioBtn;
	
	@FindBy(id="continue")
	private WebElement continueWithSelected;
	
	@FindBy(id="cancel")
	private WebElement cancelSelected;

	public WebElement getRadioBtn() {
		return radioBtn;
	}

	public WebElement getContinueWithSelected() {
		return continueWithSelected;
	}

	public WebElement getCancelSelected() {
		return cancelSelected;
	}

	

	
}
