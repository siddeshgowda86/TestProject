package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Login1 {
	
	
	WebDriver driver;
    String url = "https://qtripdynamic-qa-frontend.vercel.app/pages/login/";
    
    @FindBy (id="floatingInput")
    WebElement username_txt;
    @FindBy (id="floatingPassword")
    WebElement password_txt;
    @FindBy (xpath="//button[normalize-space()='Login to QTrip']")
    WebElement loginbtn;
    
    
    
    public Login1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);

    }
    
    
   public void navigateToLoginPage() {
        if (!this.driver.getCurrentUrl().equals(this.url)) {
            this.driver.get(this.url);
        }   
    }
    
    
    public void PerformLogin(String Username,String Password) throws InterruptedException {
    	username_txt.sendKeys(Username);
    	password_txt.sendKeys(Password);
    	loginbtn.click();
    	Thread.sleep(5000);
    	
    	 
    	
    }
   
    
   
}
