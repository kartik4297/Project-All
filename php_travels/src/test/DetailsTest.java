package test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.phptravels.hexatest.pageobject.DetailsPage;
import com.phptravels.hexatest.pageobject.PersonalDetailsPage;

public class DetailsTest extends FunctionalTest{



	//  @Test(priority=1)
	//  public void headingTest(){
	//	 
	//	  DetailsPage detailsPage = new DetailsPage(driver);
	//	  String actualhead=detailsPage.getHead();
	//	  Assert.assertEquals(actualhead, "BOOKING OPTIONS");
	//  }
	@Test(priority=1)
	public void isPicUpLocationMatching(){
		DetailsPage detailsPage = new DetailsPage(driver);
		driver.get("http://www.phptravels.net/cars/united-kingdom/manchester/Kia-Pacanto-2014?&pickupLocation=7&dropoffLocation=7&pickupDate=01/11/2018&pickupTime=02:00&dropoffDate=02/11/2018&dropoffTime=04:30");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		String actualLpicLoc= detailsPage.getCurrentPickUpLocation();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Assert.assertEquals(actualLpicLoc, "Manchester");

	}



	@Test(priority=2)
	public void isDropUpLocationMatching(){
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		DetailsPage detailsPage = new DetailsPage(driver);
		String actualdropLoc= detailsPage.getCurrentDropUpLocation();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Assert.assertEquals(actualdropLoc, "Manchester");
	}


	@Test(priority=3)
	public void booking() throws InterruptedException{
		DetailsPage detailsPage = new DetailsPage(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		PersonalDetailsPage page = 	  detailsPage.bookNow();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Assert.assertEquals(page.getHeading(), "PERSONAL DETAILS");
	}

	//  @Test(priority=4)
	//  public void isPickUpDateMatching(){
	//	  DetailsPage detailsPage = new DetailsPage(driver);
	//	  String actualhead=detailsPage.getHead();
	//	  Assert.assertEquals(actualhead, "BOOKING OPTIONS");
	//  }
	//	
	//  @Test(priority=5)
	//  public void isDropUpDateMatching(){
	//	  DetailsPage detailsPage = new DetailsPage(driver);
	//	  String actualhead=detailsPage.getHead();
	//	  Assert.assertEquals(actualhead, "BOOKING OPTIONS");
	//  }
	//	
	//  @Test(priority=6)
	//  public void isPickUpTimeMatching(){
	//	  DetailsPage detailsPage = new DetailsPage(driver);
	//	  String actualhead=detailsPage.getHead();
	//	  Assert.assertEquals(actualhead, "BOOKING OPTIONS");
	//  }
	//	
	//  @Test(priority=7)
	//  public void isDropUpTimeMatching(){
	//	  DetailsPage detailsPage = new DetailsPage(driver);
	//	  String actualhead=detailsPage.getHead();
	//	  Assert.assertEquals(actualhead, "BOOKING OPTIONS");
	//  }



//	@AfterMethod //AfterMethod annotation - This method executes after every test execution
//	public void screenShot(ITestResult result){
//		//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
//		if(ITestResult.FAILURE==result.getStatus()){
//			try{
//				// To create reference of TakesScreenshot
//				TakesScreenshot screenshot=(TakesScreenshot)driver;
//				// Call method to capture screenshot
//				File src=screenshot.getScreenshotAs(OutputType.FILE);
//				// Copy files to specific location 
//				// result.getName() will return name of test case so that screenshot name will be same as test case name
//				FileUtils.copyFileToDirectory(src, new File("D:\\images\\"+result.getName()+".png"));
//
//				System.out.println("Successfully captured a screenshot");
//			}catch (Exception e){
//				System.out.println("Exception while taking screenshot "+e.getMessage());
//			} 
//		}
//		//	 driver.quit();
//	}

}
