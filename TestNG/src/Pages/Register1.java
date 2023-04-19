package Pages;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register1 {
	
	 WebDriver driver;
	    String url="https://qtripdynamic-qa-frontend.vercel.app/pages/register/";
	    public String lastGeneratedUsername="";
	    @FindBy (id="floatingInput")
	    WebElement username_txt;
	    @FindBy (id="floatingPassword")
	    WebElement password_txt;
	    @FindBy (name="confirmpassword")
	    WebElement cnfpassword_txt;
	    @FindBy (xpath="//button[contains(text(),'Register Now')]")
	    WebElement registerbtn;
	    
	    public Register1(WebDriver driver)
	    {
	     this.driver=driver;
	    }
	    
	    public void navigateToRegisterPage() {
	        if (!driver.getCurrentUrl().equals(this.url)) {
	            driver.get(this.url);
	            PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
	        }
	    }
	    
	    public void clickregister()
		{
			registerbtn.click();
			
			
			System.out.println("Register button is clicked");

		}
	    
	    
	    public void registerUser(String Username,String Password,Boolean makeUsernameDynamic) throws InterruptedException {
	    	
	    	if (makeUsernameDynamic)
	    		Username=Username+UUID.randomUUID().toString();
	    	
	    	lastGeneratedUsername=Username;
	    	System.out.println(lastGeneratedUsername);
	    	username_txt.sendKeys(Username);
			password_txt.sendKeys(Password);
			cnfpassword_txt.sendKeys(Password);
			registerbtn.click();
			Thread.sleep(5000);
			
	    		    
		   
             /* WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
               wait.until(ExpectedConditions.urlToBe("https://qtripdynamic-qa-frontend.vercel.app/pages/login/"));*/
                  
	         // return this.driver.getCurrentUrl().endsWith("/login");
	   }
	   

	
	    
	    
}
