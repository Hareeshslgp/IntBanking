package com.IntBanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragnDrop {

	WebDriver ldriver;

	public void DragnDrop(WebDriver rdriver)
	{
	
		ldriver=rdriver;
		PageFactory.initElements(rdriver, ldriver);
			
		
	}
	
	@FindBy(xpath="//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")
	WebElement dropdown;
	
	@FindBy(xpath="//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[19]/a")
	WebElement dragndrop;
	
	public void secltdragndrop() throws InterruptedException
	{
		dropdown.click();
		Thread.sleep(2000);
		dragndrop.click();
		
	}
	
		
	}


