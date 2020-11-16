package com.adactinhotelapp.junit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import com.adactinhotelapp.baseclass.AdactinBaseClass;
import com.adactinhotelapp.locatorspojo.AdactinAccountHomePage;
import com.adactinhotelapp.locatorspojo.AdactinBookedItinerary;
import com.adactinhotelapp.locatorspojo.AdactinBookingConfirmationPage;
import com.adactinhotelapp.locatorspojo.AdactinBookingPaymentPage;
import com.adactinhotelapp.locatorspojo.AdactinLoginPageLocators;
import com.adactinhotelapp.locatorspojo.AdactinSelectFromAvailablePage;

public class AHAdeleteBooked extends AdactinBaseClass
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
	
//	@Ignore
	@Test
	public void bookOneIDandDeleteIt() throws InterruptedException 
	{
		System.err.println("==================================TestCase2-bookOneIDandDeleteIt==================================");
		AdactinAccountHomePage ahp = new AdactinAccountHomePage(driver);
		System.out.println("The logged in username displayed on the home page is: "+ahp.getAccountLoggedinName().getAttribute("value"));
		btnClicking(ahp.getSearchHotel());
		
		dropDownSelect(ahp.getLocation(), "Adelaide");
		dropDownSelect(ahp.getHotels(), "Hotel Sunshine");
		dropDownSelect(ahp.getRoomType(), "Deluxe");
		dropDownSelect(ahp.getNumberofRooms(), "3 - Three");
		clearWebElementFieldOnBrowser(ahp.getCheckInDate());
		typeOnBrowserAtElement(ahp.getCheckInDate(),"20/12/2020");
		clearWebElementFieldOnBrowser(ahp.getCheckOutDate());
		typeOnBrowserAtElement(ahp.getCheckOutDate(),"25/12/2020");
		dropDownSelect(ahp.getAdultsperRoom(), "2 - Two");
		dropDownSelect(ahp.getChildrenperRoom(), "1 - One");
		btnClicking(ahp.getSearch());
		
		AdactinSelectFromAvailablePage sfap = new AdactinSelectFromAvailablePage(driver);
		btnClicking(sfap.getRadioBtn());
		btnClicking(sfap.getContinueWithSelected());
		
		
		AdactinBookingPaymentPage bpp = new AdactinBookingPaymentPage(driver);
		typeOnBrowserAtElement(bpp.getFirstName(),"PKBT");
		typeOnBrowserAtElement(bpp.getLastName(),"BTPK");
		typeOnBrowserAtElement(bpp.getBillingAddress(),"007 Some St., Some City, Some Country -007007007");
		typeOnBrowserAtElement(bpp.getCreditCardNo(),"6543210987654321");
		dropDownSelect(bpp.getCreditCardType(), "VISA");
		dropDownSelect(bpp.getCreditCardExpMonth(), "June");
		dropDownSelect(bpp.getCreditCardExpYear(), "2022");
		typeOnBrowserAtElement(bpp.getCvvNo(),"007");
		btnClicking(bpp.getBookNow());

		AdactinBookingConfirmationPage bcp = new AdactinBookingConfirmationPage(driver);
		String bookedID = getAttributeElement(bcp.getBookingID());
		System.err.println("The BookingID of the hotel just booked is: " +bookedID);
		btnClicking(bcp.getMyItinerary());

		AdactinBookedItinerary bi = new AdactinBookedItinerary(driver);
		btnClicking(bi.getBookedItinerary());
		bi.deleteBookedOneSelected(bookedID);
		Thread.sleep(2000);
		
	}

	@Test
	public void bookFewIDsandDeleteThem()
	{
		System.err.println("==================================TestCase3-bookFewIDsandDeleteThem==================================");
		AdactinBookedItinerary abi = new AdactinBookedItinerary(driver); 
		List<String> bookedIDs = new ArrayList<>();
		for(int i=0; i<5; i++)
		{
			AdactinAccountHomePage ahp = new AdactinAccountHomePage(driver);
			
			if(i==0)
			{
				System.out.println("The logged in username displayed on the home page is: "+ahp.getAccountLoggedinName().getAttribute("value"));
			}
			//HomePage after Logging in.
			btnClicking(ahp.getSearchHotel());
			dropDownSelect(ahp.getLocation(), "Adelaide");
			dropDownSelect(ahp.getHotels(), "Hotel Sunshine");
			dropDownSelect(ahp.getRoomType(), "Deluxe");
			dropDownSelect(ahp.getNumberofRooms(), "3 - Three");
			ahp.getCheckInDate().clear();
			typeOnBrowserAtElement(ahp.getCheckInDate(),"20/12/2020");
			ahp.getCheckOutDate().clear();
			typeOnBrowserAtElement(ahp.getCheckOutDate(),"25/12/2020");
			dropDownSelect(ahp.getAdultsperRoom(), "2 - Two");
			dropDownSelect(ahp.getChildrenperRoom(), "1 - One");
			btnClicking(ahp.getSearch());
			//Continue with selected page
			AdactinSelectFromAvailablePage sfap = new AdactinSelectFromAvailablePage(driver);
			btnClicking(sfap.getRadioBtn());
			btnClicking(sfap.getContinueWithSelected());
			//Payment Page
			AdactinBookingPaymentPage bpp = new AdactinBookingPaymentPage(driver);
			typeOnBrowserAtElement(bpp.getFirstName(),"PKBT");
			typeOnBrowserAtElement(bpp.getLastName(),"BTPK");
			typeOnBrowserAtElement(bpp.getBillingAddress(),"007 Some St., Some City, Some Country -007007007");
			typeOnBrowserAtElement(bpp.getCreditCardNo(),"6543210987654321");
			dropDownSelect(bpp.getCreditCardType(), "VISA");
			dropDownSelect(bpp.getCreditCardExpMonth(), "June");
			dropDownSelect(bpp.getCreditCardExpYear(), "2022");
			typeOnBrowserAtElement(bpp.getCvvNo(),"007");
			btnClicking(bpp.getBookNow());
			//Confirmation Page
			AdactinBookingConfirmationPage bcp = new AdactinBookingConfirmationPage(driver);
			String bookedID = getAttributeElement(bcp.getBookingID());
			System.err.println("The BookingID of the hotel just booked is: " +bookedID);
			bookedIDs.add(bookedID);
			btnClicking(bcp.getMyItinerary());
					
		}
		btnClicking(abi.getBookedItinerary());
		
		List<String> bkdid = new ArrayList<>();
		bkdid.add(bookedIDs.get(0));
		bkdid.add(bookedIDs.get(1));
		bkdid.add(bookedIDs.get(4));
		
		System.out.println("Booked 5 IDs:" +bookedIDs);
		System.out.println("Booked 3 IDs to be deleted:" +bkdid);
		
		abi.deleteBookedMultipleSelected(bookedIDs,bkdid);
	}
	
	@Test
	public void deleteAllBookedTransactions()
	{
		System.err.println("==================================TestCase4-deleteAllBookedTransactions==================================");
		AdactinBookedItinerary abi = new AdactinBookedItinerary(driver); 
		abi.deleteBookedAllSelected();
	}
}

