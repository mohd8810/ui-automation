package com.uniwareauto.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.uniwareauto.cofig.FileUtil;
import com.uniwareauto.utils.dbQuery;
import com.uniwareauto.utils.dbUtil;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	public static Connection connection;
	public static WebDriver driver;
	//Properties prop;
	String environment;
   // ExcelUtils x = new ExcelUtils();
    FileUtil fu=new FileUtil();
    //BrowserUtil bu;
    dbUtil du=new dbUtil();
    dbQuery dq=new dbQuery();
    
  @BeforeSuite
  public void beforeTest() throws IOException {
	fu.getConstants("dbUrl");
    	try {
	connection=du.getConnection(fu.getConstants("dbUrl"));
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  
	 
	try {
		//x.setExcelFile(fu.getPath() +"testdata.xlsx", "Sheet1");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 //String s="chrome";
	String s = fu.getConstants("browser");
	 driver=invokeBrowser(s);
	  driver.get(fu.getConstants("AdminUrl"));
	 //driver.get("http://stgpos.unicommerce.com");
		 
  }

  @AfterSuite
  public void afterTest() throws SQLException {
	  dq.deleteParty();
      dbUtil.closeConnection();
	  driver.close();
	  
	  
  }

  private WebDriver invokeBrowser(String browser)
  {
  	
  	System.out.println("in browser utils");
  	if(browser.equalsIgnoreCase("Firefox"))
  	  {
  	
  	  driver=new FirefoxDriver();  
  	  System.out.println("driver invoked");
  	
  }
  	else if (browser.equalsIgnoreCase("chrome"))
  	{
  		System.out.println("in chromedriver ");
  		System.setProperty("webdriver.chrome.driver","/Users/admin/Downloads/chromedriver");
  		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
  		ChromeOptions options = new ChromeOptions();
  		options.addArguments("test-type");
  		capabilities.setCapability("chrome.binary", "<Path to binary>");
  		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
  		driver = new ChromeDriver(capabilities);


  		          System.out.println("driver invoked");
  	}
  	return driver;
  }
}
