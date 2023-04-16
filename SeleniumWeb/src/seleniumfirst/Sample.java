package seleniumfirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
public class Sample {
public static final String AUTOMATE_USERNAME = "siddeshgowda_GPt4ih";
public static final String AUTOMATE_ACCESS_KEY = "rRwyDMpsvUyeJx6T8QEy";
public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
public static void main(String[] args) throws Exception {
 DesiredCapabilities caps = new DesiredCapabilities();
 caps.setCapability("os_version", "10");
 caps.setCapability("resolution", "1920x1080");
 caps.setCapability("browser", "Chrome");
 caps.setCapability("browser_version", "latest");
 caps.setCapability("os", "Windows");
 caps.setCapability("name", "Sample Java test using Try block"); // test name
 caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
 final WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
 try {
   // go to bstackdemo.com
   driver.get("https://bstackdemo.com/");
   // click a button
   driver.findElement(By.xpath("//strong[normalize-space()='Offers']")).click();
   System.out.println(driver.getTitle());
   System.out.println(driver.getCurrentUrl());
   } catch (Exception e) {
     // print any exception
     System.out.println(e);
     }
    // quit the driver
   driver.quit();
 }
}

