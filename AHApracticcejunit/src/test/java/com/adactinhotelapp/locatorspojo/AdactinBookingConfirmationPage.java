package com.adactinhotelapp.locatorspojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactinhotelapp.baseclass.AdactinBaseClass;

public class AdactinBookingConfirmationPage extends AdactinBaseClass
{
	@SuppressWarnings("unchecked")
	public AdactinBookingConfirmationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(id="order_no")
	private WebElement bookingID;
	
	@FindBy(id="logout")
	private WebElement logoutBtn;
	
	@FindBy(id="my_itinerary")
	private WebElement myItinerary;
	

	

	public WebElement getBookingID() {
		return bookingID;
	}
	
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	public WebElement getMyItinerary() {
		return myItinerary;
	}

}
