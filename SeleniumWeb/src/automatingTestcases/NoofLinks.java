package automatingTestcases;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;  
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class NoofLinks {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromeDriver\\chromedriver.exe");  
        ChromeOptions chromeoptions=new ChromeOptions();
        chromeoptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeoptions); 
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> links=driver.findElements(By.tagName("a"));
        Thread.sleep(5000);
        int Size=links.size();
        System.out.println(" Number of Links :"+Size);
        driver.close();
        driver.quit();

	}

}
