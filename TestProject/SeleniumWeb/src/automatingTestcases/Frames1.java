package automatingTestcases;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;  
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Frames1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromeDriver\\chromedriver.exe");  
        ChromeOptions chromeoptions=new ChromeOptions();
        chromeoptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeoptions); 
        String url ="http://the-internet.herokuapp.com/nested_frames";
         driver.get(url);
         driver.manage().window().maximize();  
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         List<WebElement> f = driver.findElements(By.tagName("frame"));
         System.out.println("Total number " + f.size());
         driver.switchTo().frame("frame-bottom");
          WebElement Text=driver.findElement(By.xpath("//body"));
          String T=Text.getText();
          System.out.println("Text is:"+T);
          Thread.sleep(5000);
          driver.switchTo().defaultContent();
          driver.switchTo().frame("frame-top");
          driver.switchTo().frame("frame-middle");
          WebElement Text1=driver.findElement(By.xpath("//div[@id='content']"));
          String t=Text1.getText();
          System.out.println("Text is:"+t);
         driver.quit();

	}

}
