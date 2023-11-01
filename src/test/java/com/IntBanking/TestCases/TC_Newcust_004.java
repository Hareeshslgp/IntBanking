package com.IntBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.IntBanking.PageObject.LoginPage;
import com.IntBanking.PageObject.NewCustomer;

public class TC_Newcust_004 extends BassClass{

	
	@Test(priority=1)
	public void LoginTest() throws IOException
	{
		//driver.get(baseURL);
		logger.info("URL Opened");
		LoginPage lp=new LoginPage(driver);
		lp.setUsrname(UserName);
		lp.setPassword(PassWord);
		lp.clickSubmit();
		logger.info("Login successful");
		//String titile = driver.getTitle();
		//System.out.println(titile);
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			captureScreen(driver, "LoginTest");
			
		}
		
		else
		{
			captureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
		   logger.info("Login test Failed");
		}
		
	}
	
	@Test(priority=2)
	
	public void newcutomer() throws InterruptedException
	{
		Thread.sleep(2000);
		NewCustomer cus=new NewCustomer(driver);
		cus.clicknewcustomer();
		Thread.sleep(2000);
		logger.info("Navigte to New Customer creation window");

		
		}
}
