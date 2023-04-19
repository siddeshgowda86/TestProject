package seleniumfirst;

import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;  
  
public class First {  
  
    public static void main(String[] args) {  
        
    // declaration and instantiation of objects/variables  
    System.setProperty("webdriver.chrome.driver", "C://Drivers//chromeDriver//chromedriver.exe"); 
    
    ChromeOptions chromeoptions=new ChromeOptions();
    chromeoptions.addArguments("--remote-allow-origins=*");
    WebDriver driver=new ChromeDriver(chromeoptions);  
      
// Launch website  
    driver.navigate().to("http://www.google.com/"); 
    driver.manage().window().maximize();
          
    // Click on the search text box and send value  
    driver.findElement(By.id("lst-ib")).sendKeys("javatpoint tutorials");  
          
    // Click on the search button  
    driver.findElement(By.name("btnK")).click();  
    driver.close();
      
    }  
  
} 