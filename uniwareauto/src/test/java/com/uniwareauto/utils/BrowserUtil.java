package com.uniwareauto.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniwareauto.test.BaseTest;






public class BrowserUtil  extends BaseTest{
	
public WebDriver InvokeBrowser(String browser)
{
	
	System.out.println("in browser utils");
	if(browser.equalsIgnoreCase("Firefox"))
	  {
	
	  driver=new FirefoxDriver();  
	  System.out.println("driver invoked");
	
}
	return driver;
}
public WebDriver maximizeBrowser(WebDriver driver) {
	driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); 
	return driver;
	
}
}
