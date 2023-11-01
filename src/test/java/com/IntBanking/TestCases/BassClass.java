package com.IntBanking.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.IntBanking.Utilities.ReadConfig;

public class BassClass {

	ReadConfig readconfig=new ReadConfig();
	
	
	public String baseURL=readconfig.getAppicationURL();
	public String UserName=readconfig.getUseName();
	public String PassWord=readconfig.getPW();
	public static WebDriver driver= null;
	
	public static Logger logger;
	
	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger=LogManager.getLogger("E-banking");
			PropertyConfigurator.configure("log4j.properties");
		 	
		 if(br.equals("chrome"))
		 {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			ChromeOptions opt = new ChromeOptions();
			opt.addExtensions(new File("./Extension/AddBlock.crdownload"));
			//options.addArguments("--remote-allow-origins=*");
			//ChromeDriverService service=new ChromeDriverService.Builder().withLogOutput(System.out).build();
			//driver = new ChromeDriver(options);
			driver=new ChromeDriver(opt);
			driver.manage().window().maximize();
		 }
		 else if (br.equals("firefox"))
		 {
		 
			 System.setProperty("webdriver.gecko.driver", readconfig.getFirepath());
			 driver = new FirefoxDriver();
		 }
		 else if(br.equals("ie"))
		 {
			 System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
			 driver = new InternetExplorerDriver();
		 }
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File target =new File(System.getProperty("user.dir")+"/ScreenShots"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("ScreenShot Taken");
		
	}
}
