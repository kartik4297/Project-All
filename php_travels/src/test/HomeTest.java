package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.phptravels.hexatest.pageobject.HomePageCars;
import com.phptravels.hexatest.pageobject.SearchPage;

public class HomeTest extends FunctionalTest{

	XSSFWorkbook wb1;
	XSSFSheet sheet1;
	String pickuplocation;
	String dropofflocation;
	@Test(priority=2)  // to ensure this method runs second
	public void searchCarsByPickupLoc() throws InterruptedException, IOException {
		driver.get("http://www.phptravels.net");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		HomePageCars homePageCars = new HomePageCars(driver);
		
//		File src= new File("D:\\Car_Rental.xlsx");
//		//using Java API specify workbook path
//		FileInputStream fis = new FileInputStream(src);
//		//to load entire workbook use XSSFWorkbook class
//		 wb1 = new XSSFWorkbook(fis);  //XSS used for .xlsx file
//		 sheet1 = wb1.getSheetAt(1);
//		
//				//1. Launch Chrome Browser
//				driver.get("D://js-form-validation (1)//js-form-validation//example-javascript-form-validation.html");
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				driver.manage().window().maximize();
//				homePageCars = PageFactory.initElements(driver, HomePageCars.class);
//		pickuplocation=sheet1.getRow(182).getCell(5).getStringCellValue();
//		dropofflocation=sheet1.getRow(183).getCell(5).getStringCellValue();
//		
//		System.out.println("------------------->>>>>>>>>"+pickuplocation);
//		System.out.println("------------------->>>>>>>>>"+dropofflocation);
//			
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
//		
		homePageCars.clickOnCarTab();
		Thread.sleep(2000);
		homePageCars.pickupLocTextBox("Man");
		homePageCars.dropupLocTextBox("Man");
	
		homePageCars.verifytime2(10);
//		Thread.sleep(1000);
		homePageCars.verifytime1(5);
//		Thread.sleep(1000);
		homePageCars.pickUpDate();
//		Thread.sleep(1000);
		homePageCars.dropUpDate();
		Thread.sleep(1000);
		SearchPage searchPage = homePageCars.submit();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i")));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Assert.assertEquals(searchPage.getTitle(), "Search Results");
	}
//	
	@Test(priority=1)
	public void searchFailedByPickupLoc() throws InterruptedException{
		driver.get("http://www.phptravels.net");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		HomePageCars homePageCars = new HomePageCars(driver);
		homePageCars.clickOnCarTab();
		Thread.sleep(1000);
		homePageCars.dropupLocTextBox("Man");
		Thread.sleep(1000);
		homePageCars.verifytime1(5);
		Thread.sleep(1000);
		homePageCars.verifytime2(10);
		Thread.sleep(1000);
		homePageCars.dropUpDate();
		Thread.sleep(1000);
		homePageCars.pickUpDate();
		Thread.sleep(1000);
		SearchPage searchPage = homePageCars.submit();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//homePageCars.geterrorMessage();
	}


//	@AfterMethod //AfterMethod annotation - This method executes after every test execution
//	 public void screenShot(ITestResult result){
//	 //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
//	 if(ITestResult.FAILURE==result.getStatus()){
//	 try{
//	 // To create reference of TakesScreenshot
//	 TakesScreenshot screenshot=(TakesScreenshot)driver;
//	 // Call method to capture screenshot
//	 File src=screenshot.getScreenshotAs(OutputType.FILE);
//	 // Copy files to specific location 
//	 // result.getName() will return name of test case so that screenshot name will be same as test case name
//	 FileUtils.copyFileToDirectory(src, new File("D:\\images\\"+result.getName()+".png"));
//	
//	 System.out.println("Successfully captured a screenshot");
//	 }catch (Exception e){
//	 System.out.println("Exception while taking screenshot "+e.getMessage());
//	 } 
//	 }
//	// driver.quit();
//	 }
	
	
	
	
}
//
//<test name="InternetExplorer">
//<parameter name="browser" value="internetexplorer" />
//<classes>
//	<class name="test.HomeTest" />
//</classes>
//</test>