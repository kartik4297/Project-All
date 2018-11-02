package com.phptravels.hexatest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class DetailsPage extends PageObject {
	
public DetailsPage(WebDriver driver){
super(driver);	
}


@FindBy(xpath="//*[@id='body-section']/div[4]/div/div[1]")
WebElement bookingoption;

@FindBy(xpath=".//*[@id='s2id_pickuplocation']/a")
WebElement currpicloc;

@FindBy(xpath=".//*[@id='departcar2']")
WebElement currpickupdate;

@FindBy(xpath=".//*[@id='s2id_droplocation']/a")
WebElement currdropupdate;



@FindBy(xpath=".//*[@id='returncar2']")
WebElement currdroploc;

@FindBy(xpath=".//*[@id='body-section']/div[4]/div/div[2]/form/button")
WebElement bookbtn;





public String getHead(){
	return  bookingoption.getText().toString();
}

public String getCurrentPickUpLocation() {
	
	return currpicloc.getText();
}
public String getCurrentDropUpLocation() {
	
	return currpicloc.getText();
}

public PersonalDetailsPage bookNow(){
	bookbtn.click();
	return new PersonalDetailsPage(driver);
}

}
