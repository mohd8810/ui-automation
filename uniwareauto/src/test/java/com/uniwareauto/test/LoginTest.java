package com.uniwareauto.test;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.uniwareauto.pageclasses.HomePageClass;
import com.uniwareauto.pageclasses.LoginPageClass;



public class LoginTest extends BaseTest{
	LoginPageClass objLogin;
	HomePageClass objHome;
	String username;
	String password;
	  @BeforeTest
	  public void launchBrowser() throws Exception {
		
		  //driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); 
		  
	  }	
@Test(priority=1)
public void validLogin()
{System.out.println("in valid login");
	try {
		username=fu.getConstants("username");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		password =fu.getConstants("password");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	   objLogin=new LoginPageClass(driver);
	   objLogin.LoginToAdminAsValidUser(username, password);
}
@Test(priority=0)
public void invalidLogin() {
	objLogin=new LoginPageClass(driver);
	   objLogin.LoginToAdminAsInValidUser("karun1@unicommerce.ocm", "password");	
}
}
