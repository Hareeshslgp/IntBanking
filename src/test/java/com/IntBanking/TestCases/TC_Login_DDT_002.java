package com.IntBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.IntBanking.PageObject.LoginPage;
import com.IntBanking.Utilities.XLUtils;

public class TC_Login_DDT_002 extends BassClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	
	{
		LoginPage lp=new LoginPage(driver);
		WebDriverWait exwait=new WebDriverWait(driver,20);
		lp.setUsrname(user);
		logger.info("User Name is Provided");
		lp.setPassword(pwd);
		logger.info("PW is Provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPreset()==true)
		{
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			//logger.warn("Invlid Usr PW");
			//SoftAssert softassert=new SoftAssert();
			//softassert.
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Loggin Paased ");
		}
	}
	
	public boolean isAlertPreset() //user defined method to check alert present or not 
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/IntBanking/TestData/LoginData.xlsx";
		    int colcount;
			int rownum;
			
				rownum = XLUtils.getRowCount(path, "Sheet1");
				colcount = XLUtils.getCellCount(path, "Sheet1", 1);
				String logindata[][]=new String[rownum][colcount];
				
				for(int i=1;i<rownum ;i++)
				{
					for(int j=1;j<colcount ; j++)
					{
						logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
					}
				}
				
				return logindata;

		
			
	
		
	}
	
	
}
