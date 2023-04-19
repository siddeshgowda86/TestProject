package Pages;

import java.sql.Timestamp;
import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {
    WebDriver driver;
    String url="https://crio-qkart-frontend-qa.vercel.app/register";
    public String lastGeneratedUsername = "";
    @FindBy(id="username")
    WebElement username_txt_box;
    @FindBy(id="password")
    WebElement password_txt_box;
    @FindBy (id="confirmPassword")
    WebElement confirm_password_txt_box;
    @FindBy (className="button")
   WebElement register_now_button;

   public Register(WebDriver driver)
   {
    this.driver=driver;
   }

   
   public void navigateToRegisterPage() {
    if (!driver.getCurrentUrl().equals(this.url)) {
        driver.get(this.url);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }
}

public Boolean registerUser(String Username, String Password, Boolean makeUsernameDynamic)
throws InterruptedException {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    String test_data_username;
    String test_data_password = Password;

        if (makeUsernameDynamic)
            // Concatenate the timestamp to string to form unique timestamp
            test_data_username = Username + "_" + String.valueOf(timestamp.getTime());
        else
            test_data_username = Username;

            username_txt_box.sendKeys(test_data_username);
            password_txt_box.sendKeys(test_data_password);
            confirm_password_txt_box.sendKeys(test_data_password);
            register_now_button.click();

            this.lastGeneratedUsername = test_data_username;

           try {
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
                wait.until(ExpectedConditions.urlToBe("https://crio-qkart-frontend-qa.vercel.app/login"));
            } catch (TimeoutException e) {
                return false;
            }
           
           
           
            return this.driver.getCurrentUrl().endsWith("/login");




}
}