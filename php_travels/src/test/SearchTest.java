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
import com.phptravels.hexatest.pageobject.HomePageCars;
import com.phptravels.hexatest.pageobject.SearchPage;

public class SearchTest extends FunctionalTest{

	@Test(priority=1)  // to ensure this method runs second
	public void applyFilter() throws InterruptedException {
		String str="http://www.phptravels.net/cars/search?pickupLocation=7&dropoffLocation=7&pickupDate=01%2F11%2F2018&pickupTime=02%3A00&dropoffDate=02%2F11%2F2018&dropoffTime=04%3A30";
		driver.get(str);
		SearchPage searchPage = new SearchPage(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		searchPage.verifystarGrade();
		//searchPage.verifypriceRange();
		searchPage.verifcarType();
		//searchPage.verifyairportPickUp();

		//searchPage.select_pickUp(1);
		searchPage.search();
		Thread.sleep(2000);
		Assert.assertEquals(searchPage.getTitle(), "Search Results");
	}
	@Test(priority=2)  // to ensure this method runs second
	public void getDetails() throws InterruptedException {
		String str="http://www.phptravels.net/cars/search?pickupLocation=7&dropoffLocation=7&pickupDate=01%2F11%2F2018&pickupTime=02%3A00&dropoffDate=02%2F11%2F2018&dropoffTime=04%3A30";
		driver.get(str);
		SearchPage searchPage = new SearchPage(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		DetailsPage detailsPage = 	searchPage.showDetails();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Assert.assertEquals(detailsPage.getHead(), "BOOKING OPTIONS");

	}

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
//	}
}
