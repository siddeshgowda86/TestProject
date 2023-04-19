package automatingTestcases;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;  
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; 
public class Frames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromeDriver\\chromedriver.exe");  
        ChromeOptions chromeoptions=new ChromeOptions();
        chromeoptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeoptions); 
       
        driver.manage().window().maximize();  
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.get("https://www.softwaretestinghelp.com/");
        List<WebElement> elements = driver.findElements(By.tagName("iframe"));
        int numberOfTags = elements.size();
        System.out.println("No. of Iframes on this Web Page are: " +numberOfTags);
     // Switch to the frame using the frame id
        System.out.println("Switching to the frame");
        WebElement iframe=driver.findElement(By.xpath("(//iframe[@name='aswift_0'][1])"));
        driver.switchTo().frame(iframe);
     // Print the frame source code
        System.out.println("Frame Source" +driver.getPageSource());
         
        // Switch back to main web page
        driver.switchTo().defaultContent();
         
        driver.quit();
        
		
	}

}
