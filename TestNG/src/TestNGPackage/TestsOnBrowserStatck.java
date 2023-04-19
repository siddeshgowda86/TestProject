package TestNGPackage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;



public class TestsOnBrowserStatck {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		
		String AUTOMATE_USERNAME = "siddeshgowda_GPt4ih";
	    String AUTOMATE_ACCESS_KEY = "rRwyDMpsvUyeJx6T8QEy";
	    String URL = "https://" + AUTOMATE_USERNAME + ":" +      AUTOMATE_ACCESS_KEY + "@hub.browserstack.com/wd/hub";

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os_version", "10.0");
		caps.setCapability("device", "Samsung Galaxy S20");
		caps.setCapability("real_mobile", "true");
		caps.setCapability("browserstack.appium_version", "1.8.0");
		caps.setCapability("browserstack.local", "false");
		caps.setCapability("browser", "chrome");
	    driver = new RemoteWebDriver(new URL(URL), caps);	   
	}
	
	@Test
	public void getPageTitle() {
		
		String expPageTitle = "React App";
		
		// Step - 1 : Get the URL of application.
		driver.get("https://web-locators-static-site-qa.vercel.app/Button");
		
		// Step - 2 : Get the page title 
		String actPageTitle = driver.getTitle();
		
		// Step - 3 : Assert actual page title with expected page title.
		Assert.assertEquals(actPageTitle, expPageTitle);
	}

	public void tearDown() {
		driver.quit();
	}
	
}
