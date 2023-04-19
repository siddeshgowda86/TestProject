package seleniumfirst;
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;  
public class Iframes {

	public static void main(String[] args) throws InterruptedException {
		Boolean status=false;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromeDriver//chromedriver.exe");  
	    WebDriver driver=new ChromeDriver();  
		//driver.get();
		driver.navigate().to("https://crio-qkart-frontend-qa.vercel.app/thanks");
		//WebDriverWait text = new WebDriverWait(driver, 30);
		
       // text.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
          // takeScreenshot(driver, "Switching to frame1 ","Screenshot24");
		driver.switchTo().frame(0);
       Thread.sleep(3000);
       status = true;
       //logStatus("Step Success", "Switching over to advertisement frame 1", status ? "Pass" : "Fail");
       if(driver.findElement(By.xpath("//p[@class='para']")).getText().equalsIgnoreCase("Ipad Mini 64GB")){
           WebElement viewcart=driver.findElement(By.xpath("//button[text()='View Cart']"));
           if (viewcart.isEnabled()) {
              // logStatus("Step", "Test Case 12: Verified Button in iframe 1 is clickable",
                      // status ? "Pass" : "Fail");
               WebElement buynow = driver.findElement(By.xpath("//button[text()='Buy Now']"));
               System.out.println(buynow.getText());
               if (buynow.isEnabled()) {
                   buynow.isDisplayed();
                   status = true;
                   
               }
           }
       
       }
       driver.switchTo().defaultContent();
        Thread.sleep(3000);
       //driver.switchTo().frame(1);
      // WebDriverWait wait1 = new WebDriverWait(driver, 30);
       //wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
        driver.switchTo().frame(1);
       // takeScreenshot(driver, "Switching to frame2 ","Screenshot25");
        status=true;
        if(driver.findElement(By.xpath("//p[@class='para']")).getText().equalsIgnoreCase("Galaxy A21"))
        {
            status=true;
            //logStatus("STEP SUCCESS","Test Case 12: Switching over to advertisement frame 2",status  ? "PASS"  :"Fail");

        }
        try{
               WebElement buynow1= driver.findElement(By.xpath("//button[text()='Buy Now']"));
               buynow1.isEnabled();
               buynow1.isSelected();
               //buynow1.click();
                 //buynow1.click();
               status=true;
               Thread.sleep(4000);
               //logStatus("STEP SUCCESS","Clicking button on the advertisement2 page",status ? "PASS":"FAILl");
               
               
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        
          driver.switchTo().parentFrame(); 
       
	}

}
