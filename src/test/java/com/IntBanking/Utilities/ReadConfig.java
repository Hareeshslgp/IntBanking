package com.IntBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig ()
	{
		File src=new File("./Configuration_Files/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro =new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Excpetin is "+e.getMessage());
		}
	}
		public String getAppicationURL()
		{
			String url=pro.getProperty("baseURL");
			return url;
		}
		
		public String getUseName()
		{
			String uname=pro.getProperty("UserName");
			return uname;
		}
		
		public String getPW()
		{
			String pw=pro.getProperty("PassWord");
			return pw;
		}
		
		public String getChromePath()
		{
			String chromepath=pro.getProperty("chromepath");
			return chromepath;
		}
		
		public String getIEpath()
		{
			String iepath=pro.getProperty("iepath");
			return iepath;
		}
		
		public String getFirepath()
		{
			String firepath=pro.getProperty("firefoxpath");
			return firepath;
		}
		
		
		
		
}
