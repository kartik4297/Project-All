package test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.phptravels.hexatest.pageobject.AccountPage;
import com.phptravels.hexatest.pageobject.LoginPage;
public class LoginTest extends FunctionalTest {

	/**
	 * Logs in with valid credentials and checks that it redirects to the users
	 * account page.
	 */
	@Test(dependsOnMethods="failLogin")  // to ensure this method runs second
	@Parameters({"username", "password"})
	public void login(String username, String password) {
		driver.get("http://www.phptravels.net/login");
		LoginPage loginPage = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		AccountPage accountPage = loginPage.submit();

		// sleep thread for few seconds so page can redirect
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//accountPage.getTitle();
		Assert.assertEquals(accountPage.getTitle(), "My Account");
	}

	/**
	 * Attempts to log in with invalid credentials. Checks to make sure error
	 * message is displayed and with correct message.
	 */
	@Test
	@Parameters({"fakeUsername", "fakePassword"})
	public void failLogin(String fakeUsername, String fakePassword) {
		driver.get("http://www.phptravels.net/login");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterUserName(fakeUsername);
		loginPage.enterPassword(fakePassword);
		loginPage.submit();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
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
//		//	 driver.quit();
//	}

}
