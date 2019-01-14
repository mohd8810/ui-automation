package com.uniwareauto.pageclasses;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomePageClass {
	
	WebDriver driver;
	By settings=By.xpath("//i[@class='icon icon_settings']");
	By addwarehouse=By.xpath("//a[@class='btn uni-btn-primary uni-btn-small']");
	By facilitycode=By.xpath("//input[@class='uni-input  errorToolTip']");
	By displayname=By.xpath("//input[@name='displayName']");
	By partyname=By.xpath("//input[@name='name']");
	By address=By.xpath("//input[@name='billingAddressLine1']");
	By state=By.id("billingState");
	By selectsearchbar=By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']");
	By xyz=By.xpath("//div[@class='select2-result-label']");
	By city=By.xpath("//input[@name='billingCity']");
	By pincode=By.xpath("//input[@name='billingPincode']");
	By phone=By.xpath("//input[@name='billingPhone']");
	By shippingcheckbox=By.xpath("//label[@class='uni-checkbox posRelative']");
	By savewarehouse=By.id("saveWareHouse");
	public HomePageClass(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	

	public void createFacility()
	{
		/*Actions action = new Actions(driver);
		WebElement element = driver.findElement(settings);
        action.moveToElement(element).build().perform();
        driver.findElement(arg0)*/
		driver.get("https://stgenterprise1.unicommerce.com/admin/system/facility");
		driver.findElement(addwarehouse).click();
		driver.findElement(facilitycode).sendKeys("autotest");
		driver.findElement(displayname).sendKeys("autotest");
		driver.findElement(partyname).sendKeys("autotest");
		driver.findElement(address).sendKeys("Plot-65");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(state).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*java.util.List<WebElement> elements =driver.findElements(xyz);
		java.util.Iterator<WebElement> program = elements.iterator();
	    while (program.hasNext()) {
	        String values = program.next().getText();
	        //System.out.println(program.next());
	        //System.out.println(values);
	        if(program.next().getText().contains("Chhattisgarh")){
	        	driver.findElement(By.tagName("Chattisgarh"));
	        	System.out.println("selected");
	        }
	        try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}*/
	    driver.findElement(selectsearchbar).click();
	    WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(shippingcheckbox));
		
	   // driver.findElement(shippingcheckbox).click();
	    driver.findElement(city).sendKeys("Delhi");
	    driver.findElement(pincode).sendKeys("110020");
	    driver.findElement(phone).sendKeys("67887889932");
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1000)");
    
	    driver.findElement(shippingcheckbox).click();
	    driver.findElement(savewarehouse).click();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
