package com.phptravels.hexatest.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
public class HomePageCars extends PageObject{

	@FindBy(how=How.XPATH,using=".//*[@id='CARS']//button")
	WebElement submit;
	////*[@id="CARS"]/form/div[7]/button

	 @FindBy(xpath="//*[@id='body-section']/section/div[2]/div/div/div[2]/ul/li[4]/a/span")
	 WebElement carTab;
		@FindBy(xpath="//*[@id='select2-drop']/div/input")
		WebElement picloc;
		
	 @FindBy(how=How.XPATH, using="//*[@id='s2id_carlocations']/a")
	 WebElement pickuplink;
	 
	@FindBy(how=How.XPATH,using=".//*[@id='select2-drop']/ul/li[1]/div")
	WebElement manchester;
	
	@FindBy(xpath=".//*[@id='select2-drop']/div/input")
	WebElement droploc; 
	
	@FindBy(how=How.XPATH, using=".//*[@id='s2id_carlocations2']/a/span[1]")
	WebElement dropuplink;
	
	@FindBy(how=How.XPATH,using=".//*[@id='select2-drop']/ul/li/div")
	WebElement manchester2;

	//using Xpath
	@FindBy(xpath="//*[@id='CARS']/form/div[4]/div/select")
	@CacheLookup
	WebElement time1;
	
	//using Xpath
	@FindBy(xpath="//*[@id='CARS']/form/div[6]/div/select")
	@CacheLookup
	WebElement time2;
	
	//using xpath
	@FindBy(how=How.XPATH, using="//*[@id='departcar']")
	WebElement pickdate;
	
	//using xpath
		@FindBy(how=How.XPATH, using="//*[@id='returncar']")
		WebElement dropdate;
		
	
	public HomePageCars(WebDriver driver) {
		super(driver); 
	}

	
	/**
	 * Used to select the check in date for car. Will go to next month and click on second week on Friday
	 */
	

	public void implicitwait(){
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	public void  clickOnCarTab(){
		carTab.click();
	}
	
	public void pickupLocTextBox(String pic) throws InterruptedException	{
		Thread.sleep(2000);
		if(pickuplink.isDisplayed()){
			System.out.println("pickup link clickable");
			pickuplink.click();
			//Thread.sleep(1000);
		}
		else{
			System.out.println("pickup link not clickable");
			//Thread.sleep(1000);
		}
		
		if(picloc.isDisplayed()){
	
			System.out.println("pickupLocTextBox is present");
			picloc.sendKeys(pic);
			//Thread.sleep(1000);
	
		}
		else
			System.out.println("pickupLocTextBox is not present");
		if(manchester.isDisplayed()){
			System.out.println("Manchester is present");
			manchester.click();
		}
		else
			System.out.println("Manchester is not present");
		
	}
	
	public void dropupLocTextBox(String drop) throws InterruptedException
	{
		Thread.sleep(2000);
		if(dropuplink.isDisplayed()){
			System.out.println("dropup link clickable");
			dropuplink.click();
			//Thread.sleep(2000);
		}
		else{
			System.out.println("dropup link not clickable");
			Thread.sleep(2000);
		}
		
		if(droploc.isDisplayed()){
			droploc.sendKeys(drop);
			//Thread.sleep(2000);
	
		}
		else
			System.out.println("dropupLocTextBox is not present");
		if(manchester2.isDisplayed()){
			System.out.println("Manchester is present");
			manchester2.click();
		}
		else
			System.out.println("Manchester is not present");
		
	}
	//TIME
	
	public void select_time1(int index)    
	{
		
		Select sel1= new Select(time1);
		sel1.selectByIndex(index);
	}
	public void select_time2(int index)    
	{
		
		Select sel2= new Select(time2);
		sel2.selectByIndex(index);
	}

	public void verifyButtonClick() throws InterruptedException  
	{
		
		submit.click();
		System.out.println("button clicked");
	}
	public void verifytime1(int index) throws InterruptedException  
	{
		Thread.sleep(2000);
		select_time1(index);
		System.out.println("Time 1 selected");
	}
	
	
	public void verifytime2(int index) throws InterruptedException  
	{
		Thread.sleep(2000);
		select_time2(index);
		System.out.println("Time 2 selected");
	}
	
	
	public void pickUpDate(){
		// Clear field and send date
		pickdate.clear();
		pickdate.sendKeys("01/11/2018");
	}
	
	public void dropUpDate(){
		// Clear field and send date
		dropdate.clear();
		dropdate.sendKeys("02/11/2018");
	}
	
	

//	public void enterData(WebElement element, String data){
//		element.sendKeys(data);
//	}

	
//	public void geterrorMessage(){
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		Boolean is_valid = (Boolean)js.executeScript("return arguments[0].checkValidity();", picloc);
//		String message = (String)js.executeScript("return arguments[0].validationMessage;", picloc);
//		System.out.println("Error Message: "+message);
//	}

	public void checkIn() {

		// used to open the calendar for check in
		WebElement calendar = driver.findElement(By.xpath("//input[@class='form input-lg dpd1']"));

		// used to click on the arrow to change to next month
		WebElement nextMonth = driver.findElement(By.xpath("(//div[@class='datepicker-days']//th[last()])[1]"));

		// used to get second week, Friday
		WebElement date = driver.findElement(By.xpath("/html/body/div[13]/div[1]/table/tbody/tr[2]/td[6]"));

		calendar.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		nextMonth.click();
		date.click();
	}


	public SearchPage submit() {
		if(submit.isDisplayed())
			System.out.println("Submit Present");
		else
			System.out.println("not present");
		submit.click();
		return new SearchPage(driver); 

	}
}
