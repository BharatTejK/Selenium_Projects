package com.adactinhotelapp.junit;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import com.adactinhotelapp.baseclass.AdactinBaseClass;
import com.adactinhotelapp.locatorspojo.AdactinAccountHomePage;
import com.adactinhotelapp.locatorspojo.AdactinLoginPageLocators;

public class AHAsearchpage extends AdactinBaseClass
{
	
	@Before
	public void loadingRequiredURL() 
	{
		gettingDriver();
		System.out.println("---TestCase Starts here---");
		loadingURL("http://adactinhotelapp.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Date d = new Date();
		System.out.println("Start Time : " + d);
		AdactinLoginPageLocators lpl = new AdactinLoginPageLocators(driver);
		typeOnBrowserAtElement(lpl.getUserName(), "PawanKalyanBharatTej");
		typeOnBrowserAtElement(lpl.getPassword(), "Qwerty123$");
		btnClicking(lpl.getBtntoclick());
	}

	@After
	public void atAfter() throws InterruptedException 
	{
		System.out.println("---TestCase Ends here---");
		Date d = new Date();
		System.out.println("End Time : " + d);
//		closeBrowser();
	}

	
	@Test
	public void testSearchPageFields() 
	{
		AdactinAccountHomePage ahp = new AdactinAccountHomePage(driver);
		
		System.out.println("The logged in username displayed on the home page is: "+ahp.getAccountLoggedinName().getAttribute("value"));
		Assert.assertEquals(getAttributeElement(ahp.getAccountLoggedinName()), "Hello PawanKalyanBharatTej!");
		
		btnClicking(ahp.getSearchHotel());
		
		dropDownSelect(ahp.getLocation(), "Adelaide");
		String getLocationSelected = getDropDownSelectedValue(ahp.getLocation());
		String getLocationExpected = getAllDropDownOptionValues(ahp.getLocation(),4);
		System.out.println("Selected Location: "+getLocationSelected);
		System.out.println("Expected Location: "+getLocationExpected);
		Assert.assertTrue("Failed getLocation...",getLocationSelected.equals(getLocationExpected));
		
		dropDownSelect(ahp.getHotels(), "Hotel Sunshine");
		String getHotelsSelected = getDropDownSelectedValue(ahp.getHotels());
		String getHotelsExpected = getAllDropDownOptionValues(ahp.getHotels(),2);
		System.out.println("Selected Hotels: "+getHotelsSelected);
		System.out.println("Expected Hotels: "+getHotelsExpected);
		Assert.assertTrue("Failed getHotels...",getHotelsSelected.equals(getHotelsExpected));
		
		dropDownSelect(ahp.getRoomType(), "Deluxe");
		String getRoomTypeSelected = getDropDownSelectedValue(ahp.getRoomType());
		String getRoomTypeExpected = getAllDropDownOptionValues(ahp.getRoomType(),3);
		System.out.println("Selected RoomType: "+getRoomTypeSelected);
		System.out.println("Expected RoomType: "+getRoomTypeExpected);
		Assert.assertTrue("Failed getRoomType...",getRoomTypeSelected.equals(getRoomTypeExpected));
		
		dropDownSelect(ahp.getNumberofRooms(), "3 - Three");		
		String getNumberofRoomsSelected = getDropDownSelectedValue(ahp.getNumberofRooms());
		String getNumberofRoomsExpected = getAllDropDownOptionValues(ahp.getNumberofRooms(),3);
		System.out.println("Selected NumberofRooms: "+getNumberofRoomsSelected);
		System.out.println("Expected NumberofRooms: "+getNumberofRoomsExpected);
		Assert.assertTrue("Failed getNumberofRooms...",getNumberofRoomsSelected.equals(getNumberofRoomsExpected));
		
		clearWebElementFieldOnBrowser(ahp.getCheckInDate());
		typeOnBrowserAtElement(ahp.getCheckInDate(), "17/01/2021");		
		String getCheckInDateExpected = getAttributeElement(ahp.getCheckInDate());
		System.out.println("Expected getCheckInDate: "+getCheckInDateExpected);
		Assert.assertTrue("Failed getCheckInDate...",getCheckInDateExpected.equals("17/01/2021"));
		
		clearWebElementFieldOnBrowser(ahp.getCheckOutDate());
		typeOnBrowserAtElement(ahp.getCheckOutDate(), "18/02/2021");		
		String getCheckOutDateExpected = getAttributeElement(ahp.getCheckOutDate());
		System.out.println("Expected getCheckOutDate: "+getCheckOutDateExpected);
		Assert.assertTrue("Failed getCheckOutDate...",getCheckOutDateExpected.equals("18/02/2021"));
		
		dropDownSelect(ahp.getAdultsperRoom(), "2 - Two");
		String getAdultsperRoomSelected = getDropDownSelectedValue(ahp.getAdultsperRoom());
		String getAdultsperRoomExpected = getAllDropDownOptionValues(ahp.getAdultsperRoom(),2);
		System.out.println("Selected AdultsperRoom: "+getAdultsperRoomSelected);
		System.out.println("Expected AdultsperRoom: "+getAdultsperRoomExpected);
		Assert.assertTrue("Failed getAdultsperRoom...",getAdultsperRoomSelected.equals(getAdultsperRoomExpected));
		
		dropDownSelect(ahp.getChildrenperRoom(), "1 - One");
		String getChildrenperRoomSelected = getDropDownSelectedValue(ahp.getChildrenperRoom());
		String getChildrenperRoomExpected = getAllDropDownOptionValues(ahp.getChildrenperRoom(),1);
		System.out.println("Selected ChildrenperRoom: "+getChildrenperRoomSelected);
		System.out.println("Expected ChildrenperRoom: "+getChildrenperRoomExpected);
		Assert.assertTrue("Failed getAdultsperRoom...",getChildrenperRoomSelected.equals(getChildrenperRoomExpected));
		
		btnClicking(ahp.getSearch());
		
		
		
		
	}

}
