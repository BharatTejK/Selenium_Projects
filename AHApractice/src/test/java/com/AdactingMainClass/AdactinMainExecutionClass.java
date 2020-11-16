package com.AdactingMainClass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.adactinhotelapp.baseclass.AdactinBaseClass;
import com.adactinhotelapp.locatorspojo.AdactinAccountHomePage;
import com.adactinhotelapp.locatorspojo.AdactinBookingConfirmationPage;
import com.adactinhotelapp.locatorspojo.AdactinBookingPaymentPage;
import com.adactinhotelapp.locatorspojo.AdactinLoginPageLocators;
import com.adactinhotelapp.locatorspojo.AdactinSelectFromAvailablePage;

public class AdactinMainExecutionClass extends AdactinBaseClass
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = gettingDriver();
		loadingURL("http://adactinhotelapp.com/");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//Logging into adactin account
		AdactinLoginPageLocators lpl = new AdactinLoginPageLocators(driver);
		typeOnBrowserAtElement(lpl.getUserName(),"PawanKalyanBharatTej");
		typeOnBrowserAtElement(lpl.getPassword(),"Qwerty123$");
		btnClicking(lpl.getBtntoclick());

		//Searching for hotel rooms based on our needs
		AdactinAccountHomePage ahp = new AdactinAccountHomePage(driver);
		System.out.println("The logged in username displayed on the home page is: "+ahp.getAccountLoggedinName().getAttribute("value"));
		btnClicking(ahp.getSearchHotel());
		
		dropDownSelect(ahp.getLocation(), "Adelaide");
		dropDownSelect(ahp.getHotels(), "Hotel Sunshine");
		dropDownSelect(ahp.getRoomType(), "Deluxe");
		dropDownSelect(ahp.getNumberofRooms(), "3 - Three");
		typeOnBrowserAtElement(ahp.getCheckInDate(),"20/12/2020");
		typeOnBrowserAtElement(ahp.getCheckOutDate(),"25/12/2020");
		dropDownSelect(ahp.getAdultsperRoom(), "2 - Two");
		dropDownSelect(ahp.getChildrenperRoom(), "1 - One");
		btnClicking(ahp.getSearch());

		//Selecting the hotel and clicking continue
		AdactinSelectFromAvailablePage sfap = new AdactinSelectFromAvailablePage(driver);
		btnClicking(sfap.getRadioBtn());
		btnClicking(sfap.getContinueWithSelected());
		
		//Entering info on payment page to book the selected hotel
		AdactinBookingPaymentPage bpp = new AdactinBookingPaymentPage(driver);
		typeOnBrowserAtElement(bpp.getFirstName(),"Pawan Kalyan");
		typeOnBrowserAtElement(bpp.getLastName(),"Bharat Tej");
		typeOnBrowserAtElement(bpp.getBillingAddress(),"Visakhapatnam, Andhra Pradesh, India.");
		typeOnBrowserAtElement(bpp.getCreditCardNo(),"1234567890123456");
		dropDownSelect(bpp.getCreditCardType(), "VISA");
		dropDownSelect(bpp.getCreditCardExpMonth(), "December");
		dropDownSelect(bpp.getCreditCardExpYear(), "2022");
		typeOnBrowserAtElement(bpp.getCvvNo(),"007");
		btnClicking(bpp.getBookNow());

		Thread.sleep(10000);
		//Booking confirmation page to get the BookingID
		AdactinBookingConfirmationPage bcp = new AdactinBookingConfirmationPage(driver);
		System.out.println("The Booking is now completed and the BookingID is: "+bcp.getBookingID().getAttribute("value"));

		//Logout of Adactin hotel application
		btnClicking(bcp.getLogoutBtn());
		
		closeBrowser();
		
	}

}
