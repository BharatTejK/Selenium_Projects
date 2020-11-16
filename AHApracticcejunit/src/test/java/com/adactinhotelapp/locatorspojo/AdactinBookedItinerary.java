package com.adactinhotelapp.locatorspojo;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactinhotelapp.baseclass.AdactinBaseClass;

public class AdactinBookedItinerary extends AdactinBaseClass
{
	
	
	@SuppressWarnings("unchecked")
	public AdactinBookedItinerary(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(id="order_id_text")
	private WebElement searchOrderID;
	
	@FindBy(id="search_hotel_id")
	private WebElement go;

	@FindBy(xpath="//a[contains(text(),'Booked Itinerary')]")
	private WebElement bookedItinerary;

	@FindBy(xpath="//*[@id='booked_form']/table/tbody/tr[2]/td/table")
	private WebElement bookedTableList;
	
	@FindBy(tagName="tr")
	private List<WebElement> bookedTableRows;
	
	@FindBy(tagName="td")
	private List<WebElement> bookedTableData;
	
	@FindBy(xpath="//*[@id='booked_form']/table/tbody/tr[2]/td/table")
	private WebElement Bookedtable;
	
	@FindBy(xpath="//*[@id='booked_form']/table/tbody/tr[3]/td/input[1]")
	private WebElement cancelSelected;
	
	@FindBy(xpath="//*[@id='check_all']")
	private WebElement checkAllCheckBoxes;

	
	
	public WebElement getcheckAllCheckBoxes() {
		return checkAllCheckBoxes;
	}
	
	public WebElement getSearchOrderID() {
		return searchOrderID;
	}
	
	public WebElement getGo() {
		return go;
	}

	public WebElement getBookedItinerary() {
		return bookedItinerary;
	}
	
	public WebElement getBookedTableList() {
		return bookedTableList;
	}

	public List<WebElement> getBookedTableRows() {
		return bookedTableRows;
	}

	public List<WebElement> getBookedTableData() {
		return bookedTableData;
	}
	
	public WebElement getBookedtable() {
		return Bookedtable;
	}
	
	public WebElement getCancelSelected() {
		return cancelSelected;
	}
	
	
	
	public void traverseBookedItinerary()
	{
		WebElement Bookedtab =  getBookedtable();
		List<WebElement> Bookedtablerws=  Bookedtab.findElements(By.tagName("tr"));
		System.out.println("Total table rows are : "+Bookedtablerws.size());
		for(int i=0; i<Bookedtablerws.size(); i++)
		{
			int z=i+1;
			if (z>1)
			{
				WebElement trow = Bookedtablerws.get(i);
				String xpaty = "//*[@id='booked_form']/table/tbody/tr[2]/td/table/tbody/tr[" +z+ "]/td[1]/input";
				WebElement tdiele = trow.findElement(By.xpath(xpaty));
				System.out.println(i);
				System.out.println(z);
				System.out.println(getAttributeElement(tdiele));
				List<WebElement> Bookedtablecls=  trow.findElements(By.tagName("td"));
				System.out.println("Total table cols are : "+Bookedtablecls.size());
					for(int j=0; j<Bookedtablecls.size(); j++)
					{
						WebElement tcol = Bookedtablecls.get(j);
						String xpatyy = "//*[@id='booked_form']/table/tbody/tr[2]/td/table/tbody/tr[" +z+ "]/td[" + (j+1) + "]/input";
						WebElement tdielecol = tcol.findElement(By.xpath(xpatyy));
						System.out.println("           "+getAttributeElement(tdielecol));
						System.out.println("           "+(j+1));
					}
			}
			else
				continue;
		}
	
	
	}

	
	public void deleteBookedOneSelected(String booking_id) 
	{
		btnClicking(getBookedItinerary());
		typeOnBrowserAtElement(getSearchOrderID(),booking_id); //BookingID
		btnClicking(getGo());
		WebElement Bookedtab = getBookedtable();
		List<WebElement> Bookedtablerws=  Bookedtab.findElements(By.tagName("tr"));
		System.out.println("Total table rows are : "+Bookedtablerws.size());
		for(int i=0; i<Bookedtablerws.size(); i++)
		{
			int z=i+1;
			if (z>1)
			{
				WebElement trow = Bookedtablerws.get(i);
				String xpath1 = "//*[@id='booked_form']/table/tbody/tr[2]/td/table/tbody/tr[" +z+ "]/td[1]/input";
				WebElement tdiele1 = trow.findElement(By.xpath(xpath1));
				btnClicking(tdiele1);
				System.out.println("Checked the RadioButtion having value: " +getAttributeElement(tdiele1));
				
				String xpath2 = "//*[@id='booked_form']/table/tbody/tr[2]/td/table/tbody/tr[" +z+ "]/td[2]/input";
				WebElement tdiele2 = trow.findElement(By.xpath(xpath2));
				String bkID=getAttributeElement(tdiele2);
				System.err.println("BOOKING ID BEING CANCELLED: " +bkID);
				
				String xpath3 = "//*[@id='btn_id_" + getAttributeElement(tdiele1) + "']";
				WebElement tdiele3 = trow.findElement(By.xpath(xpath3));
				System.out.println("The BUTTON named '" +getAttributeElement(tdiele3) +"' is CLICKED.");
				btnClicking(tdiele3);
				
				answerYesOnConfirmAlert();
			
				System.err.println("The BOOKING ID '" +bkID +"' is CANCELLED.");
				System.out.println(i);
				System.out.println(z);
			}
			else
				continue;	
		}
	}
	
	public void deleteBookedMultipleSelected(List<String> bkid,List<String> bkdid)
	{
		
		WebElement Bookedtab = getBookedtable();
		List<WebElement> Bookedtablerws=  Bookedtab.findElements(By.tagName("tr"));
		System.out.println("Total table rows are : "+(Bookedtablerws.size()-1));
		for(String keka : bkid)
		{		
			for(int i=0; i<Bookedtablerws.size(); i++)
				{
					int z=i+1;
					if (z>1)
					{
						WebElement trow = Bookedtablerws.get(i);
						String xpaty = "//*[@id='booked_form']/table/tbody/tr[2]/td/table/tbody/tr[" +z+ "]/td[2]/input";
						WebElement tdiele = trow.findElement(By.xpath(xpaty));
						String bookIDvalueFromTag=getAttributeElement(tdiele);
						boolean abc = bookIDvalueFromTag.equals(keka);
						for(String kekka : bkdid)
						{
							boolean def = kekka.equals(bookIDvalueFromTag);
							if(def)
							{
								if(abc)
								{
									System.out.println(i);
									System.out.println(bookIDvalueFromTag);
									String xpatyy = "//*[@id='booked_form']/table/tbody/tr[2]/td/table/tbody/tr[" +z+ "]/td[1]";
									WebElement tdielee = trow.findElement(By.xpath(xpatyy));
									btnClicking(tdielee);
									System.out.println("Checked the checkbox of the BookedID: "+bookIDvalueFromTag);
									
								}
							}
							
						}
							
					}
				}
		}
		btnClicking(getCancelSelected());
		answerYesOnConfirmAlert();
	}
	
	public void deleteBookedAllSelected()
	{
		btnClicking(getBookedItinerary());
		btnClicking(getcheckAllCheckBoxes());
		btnClicking(getCancelSelected());
		answerYesOnConfirmAlert();
	}
	
}
