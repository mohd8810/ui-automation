package com.uniwareauto.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.uniwareauto.pageclasses.HomePageClass;

public class HomePageTest extends BaseTest{
	HomePageClass objHome;
	@BeforeTest
	  public void launchBrowser() throws Exception {
		
		 
		//driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); 
		  
	  }	
@Test	
public void createFacility(){
objHome=new HomePageClass(driver);
objHome.createFacility();
		
	}
}
