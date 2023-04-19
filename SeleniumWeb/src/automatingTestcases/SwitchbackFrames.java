package automatingTestcases;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;  
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class SwitchbackFrames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromeDriver\\chromedriver.exe");  
        ChromeOptions chromeoptions=new ChromeOptions();
        chromeoptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeoptions); 
        driver.manage().window().maximize();
        driver.get("http://www.uitestpractice.com/Students/Switchto");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame("iframe_a");
        WebElement d = driver.findElement(By.tagName("h1"));
        System.out.println("Text inside frame: " + d.getText());
        driver.switchTo().defaultContent();
        WebElement e = driver.findElement(By.tagName("h3"));
        System.out.println("Text outside frame: " + e.getText());
        driver.close();
        driver.quit();
        
        

	}

}
