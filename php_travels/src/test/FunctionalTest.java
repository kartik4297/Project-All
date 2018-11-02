package test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FunctionalTest {
	protected RemoteWebDriver driver;
//This class handles the test execution in multiple browsers
	//this class is extended by all other TestNG classes in this test script
	@Parameters("browser")
	@BeforeClass
	public void setupDriver(String browser) throws MalformedURLException {
		// will handle 2 major browsers: Chrome & Internet Explorer
		DesiredCapabilities dc = null;
String address="";
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			dc = DesiredCapabilities.chrome();
			dc.setBrowserName("chrome");
			address="http://localhost:6666/wd/hub";

		} 
/*		else if (browser.equalsIgnoreCase("firefox")) {
			dc = DesiredCapabilities.firefox();
			dc.setBrowserName("firefox");
			System.setProperty("webdriver.firefox.bin","C:\\Users\\kartikks\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("newtwork.proxy.type",1);
			profile.setPreference("newtwork.proxy.http","chnproxy.igate.com");
			profile.setPreference("newtwork.proxy.http_port",8080);
			profile.setPreference("network.proxy.ssl", "chnproxy.igate.com");
			profile.setPreference("network.proxy.ssl_port", 8080);
			dc.setCapability(FirefoxDriver.PROFILE, profile);
			address="http://localhost:5557/wd/hub";
		}*/
		else if(browser.equalsIgnoreCase("internetexplorer")){
			// FOR IE BROWSER	
			System.setProperty("webdriver.ie.driver","D:\\IEDriverServer.exe");
			dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			dc.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			address="http://localhost:6668/wd/hub";
		}

		dc.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL(address), dc);
		driver.manage().window().maximize();
	}
	@AfterMethod //AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result){
		//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
		if(ITestResult.FAILURE==result.getStatus()){
			try{
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot=(TakesScreenshot)driver;
				// Call method to capture screenshot
				File src=screenshot.getScreenshotAs(OutputType.FILE);
				// Copy files to specific location 
				// result.getName() will return name of test case so that screenshot name will be same as test case name
				FileUtils.copyFileToDirectory(src, new File("./FailedTestCasesScreenShot/"+result.getName()+".png"));

				System.out.println("Successfully captured a screenshot");
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		}
	}
	//./Config/Propertyfile.txt
	
	@AfterClass
	public void quitDriver() {
		driver.quit();
	}
}

