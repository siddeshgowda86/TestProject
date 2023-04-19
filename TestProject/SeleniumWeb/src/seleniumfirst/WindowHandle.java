package seleniumfirst;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;  
public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Boolean status=false;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromeDriver//chromedriver.exe");  
	    WebDriver driver=new ChromeDriver();  
		driver.get("https://crio-qkart-frontend-qa.vercel.app");
		String parentwindowid =driver.getWindowHandle();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Privacy policy')]")).click();
        //driver.findElement(By.xpath("//a[contains(text(),'Terms of Service')]")).click();
          Set <String> child= driver.getWindowHandles();
          List<String> hlist = new ArrayList<String>(child);

          Thread.sleep(3000);
          for(String handle:hlist){
              status=true;
              System.out.println(handle);
              }
              //logStatus("Step Success", "getting the list of windows available ", status? "PASS":"FAIL");
               
                      driver.switchTo().window(hlist.get(1));
                         //takeScreenshot(driver, "Navigated to Second Window ","Screenshot20");
                      status = true;
                      Thread.sleep(4000);
                     // logStatus("Step Success", "Switching to second window","DONE");
                        Thread.sleep(3000);
                   WebElement privacy = driver.findElement(By.xpath("//h2[normalize-space()='Privacy Policy']"));
                   
                   if(privacy.getText().equals("Privacy Policy"))
                  {
                      status=true;
                  //logStatus("TestCase10","Successfuly verify the Privacy Policy Contents on the Privacy Policy Page",status ? "Pass":"Fail");

                 }
               else
              {
              // logStatus("TestCase10","Not  verify the Privacy Policy Contents on the Privacy Policy Page",status ? "Pass":"Fail");
                 }
                  //driver.close();
                       //Thread.sleep(3000);
                 
                driver.switchTo().window(hlist.get(0));
                // logStatus("Step Success", "Switching to Parent window","DONE");
                Thread.sleep(4000);
                driver.findElement(By.xpath("//a[contains(text(),'Terms of Service')]")).click();
               // driver.switchTo().window(hlist.get(1));
                //Thread.sleep(4000);
                
               //logStatus("Step Success", "Switching to second window","DONE");
            if (driver.getTitle().equals("QKart"))
                System.out.println("validated");
                else
                    System.out.println("Not Validated");
                Thread.sleep(3000);
                System.out.println(driver.getCurrentUrl());
                if(driver.getCurrentUrl().equals("https://crio-qkart-frontend-qa.vercel.app/terms-of-service"))
                {
                	driver.close();
                }
               // driver.close();
                
            driver.switchTo().window(hlist.get(1));
            //logStatus("Step Success", "Closing the second window","DONE");
            driver.close();
           Thread.sleep(3000);
          // driver.close();
           driver.switchTo().window(hlist.get(0));
          // driver.switchTo().window(parentwindowid);

           //logStatus("Step Success", "closing the first window","DONE");
          //driver.close();
          //Thread.sleep(3000);
          driver.switchTo().window(parentwindowid);
          //driver.quit();
          driver.close();

	}

}
