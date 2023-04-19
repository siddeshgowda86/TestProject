package automatingTestcases;
import java.time.Duration;

import org.openqa.selenium.By;  
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; 

public class FirstDeom {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromeDriver\\chromedriver.exe");  
        ChromeOptions chromeoptions=new ChromeOptions();
        chromeoptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeoptions); 
        driver.get("https://www.google.com");
        driver.manage().window().maximize();  
        //Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String Text=driver.getTitle();
        System.out.println("Title:"+Text);
        driver.findElement(By.name("q")).sendKeys("amazon");
        Thread.sleep(2000);
        //String Searchtext= driver.findElement(By.xpath("//span[@class='yIn8Od']//span[@class='BTu2cd'][normalize-space()='Amazon.in']")).getText();
        //System.out.println(Searchtext);
        driver.findElement(By.xpath("(//li[@class='sbct']//div[@class='eIPGRd'])[1]")).click();
         driver.close();
         driver.quit();

	}

}
