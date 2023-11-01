package com.IntBanking.TestCases;

import org.testng.annotations.Test;

import com.IntBanking.PageObject.DragnDrop;
import com.IntBanking.PageObject.LoginPage;

public class TC_DragDrop_003 extends BassClass {
	
	
	@Test
	public void DragndropTest() throws InterruptedException
	{
	logger.info("URL Opened");
	LoginPage lp=new LoginPage(driver);
	DragnDrop dd=new DragnDrop();
	lp.setUsrname(UserName);
	lp.setPassword(PassWord);
	lp.clickSubmit();
	Thread.sleep(2000);
	logger.info("Login successful");
	dd.DragnDrop(driver);
	Thread.sleep(2000);

	}
}
