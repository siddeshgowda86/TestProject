package Pages;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NewTest {

    static WebDriver driver;
    public static String lastGeneratedUserName;
    String driverPath = "C://Drivers//chromeDriver//chromedriver.exe";
    String url = "https://crio-qkart-frontend-qa.vercel.app";
    
        @BeforeSuite (alwaysRun =true)
        public  void createDriver() throws MalformedURLException {
        
        	System.out.println("launching Chrome browser"); 
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
    }

    public void registerNewuser() throws InterruptedException{
        SoftAssert sa =new SoftAssert();
        Register register=new Register(driver);
        register.navigateToRegisterPage();
        sa.assertTrue(register.registerUser("Testuser","abc@123",true),"Failed to  Create new user");
        lastGeneratedUserName = register.lastGeneratedUsername;
    }

    @Test( description="Verify User logedin")
    public void TestCase() throws InterruptedException{
        registerNewuser();
        String lastgeneratedUserName = lastGeneratedUserName;
        Login login = new Login(driver);
        login.navigateToLoginPage();
        Boolean status = login.PerformLogin(lastgeneratedUserName, "abc@123");
        Assert.assertTrue(status);

    }

    @AfterSuite
    public static void quitDriver() {
        System.out.println("quit()");
        driver.quit();
    }
    
}
