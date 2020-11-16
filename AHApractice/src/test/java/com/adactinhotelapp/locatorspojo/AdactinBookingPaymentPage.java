package com.adactinhotelapp.locatorspojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactinhotelapp.baseclass.AdactinBaseClass;

public class AdactinBookingPaymentPage extends AdactinBaseClass
{

	@SuppressWarnings("unchecked")
	public AdactinBookingPaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")
	private WebElement firstName;
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	@FindBy(id="address")
	private WebElement billingAddress;
	
	@FindBy(id="cc_num")
	private WebElement creditCardNo;
	
	@FindBy(id="cc_type")
	private WebElement creditCardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement creditCardExpMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement creditCardExpYear;	
	
	@FindBy(id="cc_cvv")
	private WebElement cvvNo;
	
	@FindBy(id="book_now")
	private WebElement bookNow;

	@FindBy(id="cancel")
	private WebElement cancelBtn;
	


	
	
	
	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getBillingAddress() {
		return billingAddress;
	}

	public WebElement getCreditCardNo() {
		return creditCardNo;
	}

	public WebElement getCreditCardType() {
		return creditCardType;
	}

	public WebElement getCreditCardExpMonth() {
		return creditCardExpMonth;
	}

	public WebElement getCreditCardExpYear() {
		return creditCardExpYear;
	}

	public WebElement getCvvNo() {
		return cvvNo;
	}

	public WebElement getBookNow() {
		return bookNow;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}


	
	
	

	
	
	
	
	
	
	
	
}
