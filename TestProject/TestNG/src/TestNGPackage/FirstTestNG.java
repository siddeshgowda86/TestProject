package TestNGPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestNG {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";

   
  @Test
  public void verifyHomepageTitle() {
       
      System.out.println("launching Chrome browser"); 
      System.setProperty("webdriver.chrome.driver", "C://Drivers//chromeDriver//chromedriver.exe");  
	    WebDriver driver=new ChromeDriver();  
      driver.get(baseUrl);
      driver.manage().window().maximize();
      String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      System.out.println("Test Passed");
      driver.close();
  }
}
