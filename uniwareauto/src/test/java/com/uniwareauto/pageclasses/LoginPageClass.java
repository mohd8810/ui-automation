package com.uniwareauto.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class LoginPageClass {
	WebDriver driver;
	By usernameLoc=By.id("username");
	By passwordLoc=By.id("password");
	By loginbuttonLoc=By.className("loginButton");
	By tenantcodeLoc=By.xpath("//*[@access-url= 'https://stgenterprise1.unicommerce.com']");
	
	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
	}
	public LoginPageClass LoginToAdminAsInValidUser(String username,String password){
		driver.findElement(usernameLoc).sendKeys(username);
		driver.findElement(passwordLoc).sendKeys(password);
		driver.findElement(loginbuttonLoc).click();
		return new LoginPageClass(driver);
	}
	public HomePageClass LoginToAdminAsValidUser(String username,String password){
		driver.navigate().refresh();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(usernameLoc).sendKeys(username);
		driver.findElement(passwordLoc).sendKeys(password);
		driver.findElement(loginbuttonLoc).click();

		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(tenantcodeLoc));
		driver.findElement(tenantcodeLoc).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePageClass(driver);
	}
}
