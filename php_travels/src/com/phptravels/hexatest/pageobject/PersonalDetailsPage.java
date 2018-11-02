package com.phptravels.hexatest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PersonalDetailsPage extends PageObject {

	@FindBy(xpath=".//*[@id='body-section']/div/div/div[1]/div/div[1]/div[2]/div[2]/div[1]")
	WebElement head;
	@FindBy(name="firstname")  
	@CacheLookup // to store the element in cache memory
	WebElement firstname;
	
	
		@FindBy(name="lastname")
		@CacheLookup
		WebElement lastname;
		
		@FindBy(name="email")
		@CacheLookup
		public WebElement email;
		
		
		@FindBy(name="confirmemail")
		@CacheLookup
		WebElement confirmemail;
		
		@FindBy(name="phone")
		@CacheLookup
		WebElement phone;
		
		@FindBy(name="address")
		@CacheLookup
		WebElement address;
		
		@FindBy(xpath="//*[@id='select2-drop']/div/input")
		@CacheLookup
		WebElement Country;
	
		@FindBy(name="guest")
		@CacheLookup
		WebElement submit;
		
			
		public void enterfirstname(String fn)
		{
			firstname.sendKeys(fn);
		}
		public void enterlastname(String ln)
		{
			lastname.sendKeys(ln);
		}
		public void enteremail(String em)
		{
			email.sendKeys(em);
			String email1=em;
		}
		
		public void enterconfirmemail(String cemail)
		{
			confirmemail.sendKeys(cemail);
			String email2=cemail;
		}
		
		public void enterphone(String ph)
		{
			phone.sendKeys(ph);
			String phone=ph;
		}
		public void enteraddress(String a)
		{
			address.sendKeys(a);
			String address=a;
		}
	
		
		
		
		public void selectCountry(int index)    
		{
			
			Select selCountry= new Select(Country);
			selCountry.selectByIndex(index);  //1 is passed here
		}
		
		
		
		
		
		
		
		
		public void verifyfirstname() throws InterruptedException  
		{
			Boolean fn=firstname.isDisplayed();
			if(fn=true) 
			{
				System.out.println("User name textbox present");
				enterfirstname("");
				submit.click();
				Thread.sleep(1000);
				enterfirstname("Shubhangi");
			 	submit.click();
			  
			    
			}
			else
			{
				System.out.println("first Name textbox not present");
			}
			
		}			
		


		
	
		
		public void verifylastname() throws InterruptedException  
		{
			Boolean ln=lastname.isDisplayed();
			if(ln=true) 
			{
				System.out.println("lastname  textbox present");
				enterlastname("");
				submit.click();
				Thread.sleep(1000);
				enterlastname("Gurav");
			 	submit.click();
			  
			    
			}
			else
			{
				System.out.println("lastname  textbox not present");
			}
			
		}	
		
		
		
		
		
		
		public void verifyemail() throws InterruptedException  
		{
			Boolean em=email.isDisplayed();
			if(em=true) 
			{
				System.out.println("Email  textbox present");
				enteremail("");
				submit.click();
				Thread.sleep(1000);
				enteremail("example@gmail.com");
			 	submit.click();
			  
			    
			}
			else
			{
				System.out.println("email  textbox not present");
			}
			
		}
		
		
		
		
		
		
		public void verifyconfirmemail() throws InterruptedException  
		{
			Boolean cem=confirmemail.isDisplayed();
			
			if(cem=true) 
			{
				System.out.println("confirm Email  textbox present");
				enterconfirmemail("");
				submit.click();
				Thread.sleep(1000);
				enterconfirmemail("example@gmail.com");
				
				
				
			    
				
				
			}
			else
			{
				System.out.println("confirm email  textbox not present");
			}
			
		}

		
		
		public void verifyphone() throws InterruptedException  
		{
			Boolean ph=phone.isDisplayed();
			if(ph=true) 
			{
				System.out.println("phone number textbox present");
				enterphone("");
				
				Thread.sleep(1000);
				enterphone("9994796915");
			 	
			  
			    
			}
			else
			{
				System.out.println("phone number textbox not present");
			}
			
		}	
		
		
		public void verifyaddress() throws InterruptedException  
		{
			Boolean a=address.isDisplayed();
			if(a=true) 
			{
				System.out.println("address textbox present");
				enteraddress("");
				
				Thread.sleep(1000);
				enteraddress("chennai");
				submit.click();
				
			  
			    
			}
			else
			{
				System.out.println("address textbox not present");
			}
			
		}	

		public void verifCountry() throws InterruptedException  
		{
			Boolean a=Country.isDisplayed();
			if(a=true) 
			{
				System.out.println("country textbox present");
				selectCountry(1);
				
				Thread.sleep(1000);
				submit.click();
			  
			    
			}
			else
			{
				System.out.println("country textbox not present");
			}

		}
		
		
		public void submitReg(){
			submit.click();
		}
	public PersonalDetailsPage(WebDriver driver){
		super(driver);
		
	}
	
	
	
public String getHeading()
{
	return head.getText().toString();
}
}
