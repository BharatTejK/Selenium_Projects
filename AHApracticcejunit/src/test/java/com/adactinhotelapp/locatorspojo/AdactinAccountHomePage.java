package com.adactinhotelapp.locatorspojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactinhotelapp.baseclass.AdactinBaseClass;

public class AdactinAccountHomePage extends AdactinBaseClass
{
	@SuppressWarnings("unchecked")
	public AdactinAccountHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(id="username_show")
	private WebElement accountLoggedinName;
	
	@FindBy(xpath="//a[text()='Search Hotel']")
	private WebElement searchHotel;
	
	@FindBy(id="location")
	private WebElement location;
	
	@FindBy(id="hotels")
	private WebElement hotels;
	
	@FindBy(id="room_type")
	private WebElement roomType;
	
	@FindBy(id="room_nos")
	private WebElement numberofRooms;
	
	@FindBy(id="datepick_in")
	private WebElement checkInDate;
	
	@FindBy(id="datepick_out")
	private WebElement checkOutDate;
	
	@FindBy(id="adult_room")
	private WebElement adultsperRoom;
	
	@FindBy(id="child_room")
	private WebElement childrenperRoom;
	
	@FindBy(id="Submit")
	private WebElement search;
	
	@FindBy(id="Reset")
	private WebElement reset;
	
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement bookedItinerary;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;

	
	
	public WebElement getAccountLoggedinName() {
		return accountLoggedinName;
	}

	public WebElement getSearchHotel() {
		return searchHotel;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getNumberofRooms() {
		return numberofRooms;
	}

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	public WebElement getAdultsperRoom() {
		return adultsperRoom;
	}

	public WebElement getChildrenperRoom() {
		return childrenperRoom;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getReset() {
		return reset;
	}

	public WebElement getBookedItinerary() {
		return bookedItinerary;
	}

	public WebElement getLogout() {
		return logout;
	}
  
}
