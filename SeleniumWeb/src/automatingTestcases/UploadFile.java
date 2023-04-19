package automatingTestcases;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;  
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class UploadFile {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromeDriver\\chromedriver.exe");  
        ChromeOptions chromeoptions=new ChromeOptions();
        chromeoptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeoptions); 
        driver.manage().window().maximize();
		
		driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		 WebElement m=driver.findElement(By.xpath("//input[@type='file']"));
		 m.sendKeys("C:\\Users\\USER\\Desktop\\new.txt");
		 Thread.sleep(3000);
		 driver.close();
	}

}
