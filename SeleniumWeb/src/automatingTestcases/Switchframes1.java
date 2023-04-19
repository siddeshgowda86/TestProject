package automatingTestcases;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;  
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Switchframes1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromeDriver\\chromedriver.exe");  
        ChromeOptions chromeoptions=new ChromeOptions();
        chromeoptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeoptions); 
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/frames");
        String Text=driver.getWindowHandle();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.partialLinkText("Nested")).click();
        driver.switchTo().frame("frame-bottom");
        WebElement m = driver.findElement(By.cssSelector("body"));
        System.out.println("Frame text: " +m.getText());
        Thread.sleep(3000);
        String T=driver.getTitle();
        System.out.println(T);
        
        
       driver.navigate().to("https://the-internet.herokuapp.com/frames");
        System.out.println("Switch back");
        Thread.sleep(2000);
        driver.close();
		
	}

}
