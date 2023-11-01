package com.IntBanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {
	
	WebDriver ldriver;
	
	public NewCustomer(WebDriver rdriver)
	{
		 ldriver=rdriver;
		 PageFactory.initElements(rdriver, this);
		 
	}
	
	@FindBy(linkText="New Customer")
	WebElement Newcustomer;
	
	 public void clicknewcustomer() throws InterruptedException 
	 {
		 Newcustomer.click();
		 Thread.sleep(3000);
		 
	 }
	

}
