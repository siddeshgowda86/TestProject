package LearningGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;



public class selenium {

	//WebDriver driver;
	
	@Test
	public void setup() throws MalformedURLException {
		 
		 // Step - 1 : Set the browser .exe path
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromeDriver//chromedriver.exe");  
	    WebDriver driver=new ChromeDriver();  
	    driver.get("https://web-locators-static-site-qa.vercel.app/Button");
	    String expPageTitle = "React App";
	    String actPageTitle = driver.getTitle();
	    Assert.assertEquals(actPageTitle, expPageTitle);
		 // Step - 2 : Create the object of DesiredCapabilities class
		   DesiredCapabilities capabilities = new DesiredCapabilities();
		 // Step - 3 : Set browserName using setCapability method
		   capabilities.setCapability("browserName", "chrome");
		 // Step - 4 : Set version using setCapability method
		   capabilities.setCapability("version", "102.0.5005.115");
		 // Step - 5 : Set platform using setCapability method
		   capabilities.setCapability("platform", "WIN10");
		 /**
		  *  Step - 6 : Create the object of RemoteWebDriver 
		  *  a. Set the Hub URL
		  *  b. Pass DesiredCapabilities object
		  */
		   driver = new RemoteWebDriver(new URL("http://192.168.116.54:4444/wd/hub"), capabilities);
		   
		   
			
			// Step - 1 : Get the URL of application.
			
			
			// Step - 2 : Get the page title 
			
			
			// Step - 3 : Assert actual page title with expected page title.
		   driver.quit();
			
	}
	
	
	
}

