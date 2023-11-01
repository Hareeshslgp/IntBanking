package com.IntBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.IntBanking.PageObject.LoginPage;

public class TC_LoginTest_001 extends BassClass {


	@Test
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
	
	
}
