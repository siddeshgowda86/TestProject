package seleniumfirst;

import org.openqa.selenium.By;  
import org.openqa.selenium.JavascriptExecutor;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;  
  
public class Second {  
  
    public static void main(String[] args) {  
      
           // System Property for Chrome Driver   
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromeDriver\\chromedriver.exe");  
        ChromeOptions chromeoptions=new ChromeOptions();
        chromeoptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeoptions); 
             // Instantiate a ChromeDriver class.     
        //WebDriver driver=new ChromeDriver();  
          
           // Launch Website  
        driver.navigate().to("http://www.javatpoint.com/");  
          
         //Maximize the browser  
          driver.manage().window().maximize();  
          
          //Scroll down the webpage by 5000 pixels  
        //JavascriptExecutor js = (JavascriptExecutor)driver;  
       // js.executeScript("scrollBy(0, 5000)");   
          
         // Click on the Search button  
       driver.findElement(By.linkText("HTML")).click();     
  
        driver.close();
    }  
  
}  