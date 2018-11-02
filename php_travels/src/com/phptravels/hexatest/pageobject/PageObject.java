package com.phptravels.hexatest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
	protected WebDriver driver;
	
	public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}

/*With the help of this class we have implemented efficient coding practice 
because each time a submit button is pressed on any of the page and page elements 
get refreshed. and  In order to locate the elements correctly we need PageFactory.*/
