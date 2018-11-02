package com.phptravels.hexatest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
public class SearchPage extends PageObject{
	
	
//	@FindBy(xpath="//*[@id='body-section']/section/div[2]/div/div/div[2]/ul/li[4]/a")  
//	@CacheLookup // to store the element in cache memory
//	WebElement carsButton;
	
	//using Xpath
	@FindBy(xpath="//*[@id='body-section']/div[6]/div/div[2]/form/button[1]")
	@CacheLookup
	WebElement starGrade;  //   
	
	//using Xpath
	@FindBy(xpath=".//*[@id='body-section']/div[6]/div/div[2]/form/button[2]")
	
	@CacheLookup
	WebElement priceRange;  
	
	//using Xpath
	@FindBy(xpath="//*[@id='body-section']/div[6]/div/div[2]/form/button[4]")
	@CacheLookup
	WebElement airportPickUp;  
	
	//using Xpath
	@FindBy(xpath="//*[@id='body-section']/div[6]/div/div[2]/form/button[3]")
	@CacheLookup
	WebElement carType;
	
//	//using Xpath
//	@FindBy(how=How.NAME, using=".//*[@id='collapse5']/div/select")
//	@CacheLookup
//	WebElement selPickUp;
	
	//using Xpath
	@FindBy(how=How.XPATH, using=".//*[@id='searchform']")
	@CacheLookup
	WebElement search;
	
	//using Xpath
	@FindBy(how=How.XPATH, using=".//*[@id='body-section']/div[6]/div/div[3]/div/h1")
	@CacheLookup
	WebElement filterResultText;

	
	
	//using Xpath
	@FindBy(how=How.XPATH, using=".//*[@id='body-section']/div[6]/div/div[3]/div/table/tbody/tr/td/div[3]/a/button")
	@CacheLookup
	WebElement deatils;
	
	
	
	public boolean show_starGrade()    
	{
		if(starGrade.isDisplayed())
		{
			starGrade.click();
			return true;
		}
		return false;
	}
	public boolean show_priceRange()    
	{
		if(priceRange.isDisplayed())
		{
			priceRange.click();
			return true;				//   
		}
		return false;
	}
	public boolean show_carType()    
	{
		if(carType.isDisplayed())
		{
			carType.click();
			return true;				   
		}
		return false;
	}
	public boolean show_airportPickUp()    
	{
		if(airportPickUp.isDisplayed())
		{
			//airportPickUp.click();
			return true;				   
		}
		return false;
	}
//	public void select_pickUp(int index)    
//	{
//		if(selPickUp.isDisplayed()){
//		Select sel= new Select(selPickUp);
//		sel.selectByIndex(index);
//		}
//		else
//			System.out.println("Select not present");
//	}

	
	
	//Star Grade visibility validation
	public void verifystarGrade() throws InterruptedException  
	{
		
		Thread.sleep(2000);
		if(show_starGrade())
		{
			//starGrade.click();
			System.out.println("Star Grade has been detected");
		}
		else
			System.out.println("Star Grade not found");
	}
	
	//Price range visibility validation
	public void verifypriceRange() throws InterruptedException  
	{
		
		Thread.sleep(2000);
		if(show_priceRange())
		{
			priceRange.click();
			System.out.println("Price Range has been detected");
		}
		else
			System.out.println("Price Range not found");
	}
	
	//Price range visibility validation
	public void verifcarType() throws InterruptedException  
	{
		System.out.println("In here");
		Thread.sleep(2000);
		if(show_carType())
		{
			carType.click();
			System.out.println("Price Range has been detected");
		}
		else
			System.out.println("Price Range not found");
	}
	
	//Airport Pickup visibility validation
//	public void verifyairportPickUp() throws InterruptedException  
//	{
//		System.out.println("Select box");
//		Thread.sleep(2000);
//		if(show_airportPickUp())
//		{
//			airportPickUp.click();
//			Thread.sleep(2000);
//			select_pickUp(1);
//			System.out.println("Pick up Airport has been detected");
//		}
//		else
//			System.out.println("Pick up Airport not found");
//	}

	
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}

	public void search()
	{
		search.click();
	
	}
	
	
	public String getTitle() {
		return driver.getTitle();
	}
	public String getCurrentPageUrl() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}
	
	public DetailsPage showDetails(){
		deatils.click();
		return new DetailsPage(driver);
		
	}

	
}

