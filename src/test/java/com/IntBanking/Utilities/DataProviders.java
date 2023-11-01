package com.IntBanking.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//LoginData.xlsx";
		XLUtils xl=new XLUtils(path);
		
		int rownum=xl.getRowCount("Sheet1");
		int colcount=xl.getCellCount("Sheet1", 1);
		
		String apidata[][]=new String[rownum][colcount];
		
		for(int i=0; i<rownum ;i++)
		{
			for(int j=0; j<colcount ;j++)
			{
				apidata[i][j]=xl.Getcelldata("Sheet1", i, j);
			}
		}
		return apidata;
	}
	
	
	
	@DataProvider(name="Usernames")
	public String[] getUsernames() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//TestdataUser.xlsx";
		XLUtils xl=new XLUtils(path);
		
		int rownum=xl.getRowCount("Sheet1");
	
		
		String apidata[]=new String[rownum];
		
		for(int i=1; i<rownum ;i++)
		{
			
			
				apidata[i-1]=xl.Getcelldata("Sheet1", i, 1);
			
		}
		return apidata;
	}
	

}
